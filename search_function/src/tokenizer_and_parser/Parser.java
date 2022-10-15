package tokenizer_and_parser;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class and ALL methods created by:
 * @author u7117043
 *  
 * 
 * Abbreviations:
 * - exp = expression
 * - id = identifier
 * - op = operation/operator
 * - int = integer
 * 
 * () is used for definitions
 * <> is used for variables
 * 
 * Context Free Grammar
 * 
 * <exp>		= <term>, <exp> | <term>
 * <term>		= <id> | <op_keyword> | <id_keyword> | 	
 * <id>			= (any string non keyword or symbol string)
 * <op_keyword>	= PAGES <op> <int> | COST <op> <int> | EDITION <op> <int>
 * <op> 		= < | > | =
 * <int>		= (any positive or 0 integer less than 9999)
 * <id_keyword>	= TOPIC: <id> | CODE: <id> | ISBN: <isbn>
 * <isbn> 	    = (a string that conforms to isbn format, see isbn section)  
 * 
 * 
 * The way the search function will work is by applying filters in sequential order:
 * 
 * - Find all books related to identifier(s)
 * - Find all books related to TOPIC
 * - Find all books related to CODE
 * - Find all books related to COST
 * - Find all books related to PAGES
 * 
 * If a filter is empty skip it 
 * 		- e.g. no identifier leads to every book; now apply TOPIC filter and so on
 * 
 * If a filter results in no books stop or skip it and show user which filter resulted in no books (maybe add message saying how many books before this filter)
 * 		- e.g. "No books found with: COST < 10, however 5 books found without this filter"
 *  
 *  
 *  NOTES:
 *  - Integer tokens will be less than 10000 and greater than or equal to 0
 *  - keywords related to operators stored as an array, related to id's stored in arraylist
 *  - isbn stored as single string, ignoring dashes
 * 
 */

public class Parser {
	
	//List of search terms the user wants in the books title
	ArrayList<String> searchTerms = new ArrayList<String>();
	
	ArrayList<String> topicTerms = new ArrayList<String>();
	
	ArrayList<String> codeTerms = new ArrayList<String>();
	
	ArrayList<String> errorStrings = new ArrayList<String>();
	
	/*
	 * Stores integers related to this filtering: 
	 * - Integer at [0] is related to < 
	 * - Integer at [1] is related to >
	 * - Integer at [2] is related to =
	 */
	Integer[] pageOperation = new Integer[3];
	Integer[] costOperation = new Integer[3];
	Integer[] editionOperation = new Integer[3];
	
	//Only check for one ISBN
	String ISBN = null;
	
	
	//Import special strings and characters
	static final ArrayList<Character> operators = new ArrayList<Character>(Arrays.asList('<', '>','='));
	
	static final ArrayList<String> op_keywords = new ArrayList<String>(Arrays.asList("PAGES", "COST", "EDITION"));
	
	static final ArrayList<String> id_keywords = new ArrayList<String>(Arrays.asList("TOPIC", "CODE", "ISBN"));
	
	static final ArrayList<Character> digits = Tokenizer.digits;
	
	/*
	 * Singleton DP: Only one instance of parser should exists
	 */
	
	private static Parser instance = null;
	
	private Parser() {};
	
	public static Parser getInstance() {
		if(instance == null) instance = new Parser();
		return instance;
	}
	
	
	/**
	 * Resets all instance variables to default: 
	 * removes all search terms and operation arrays.
	 * Should be called every time we parseSearch
	 */
	public void resetParser() {
		
		searchTerms	= new ArrayList<String>();
		topicTerms = new ArrayList<String>();
		codeTerms = new ArrayList<String>();
		errorStrings = new ArrayList<String>();
		
		
		pageOperation = new Integer[3];
		costOperation = new Integer[3];
		editionOperation = new Integer[3];
		
		ISBN = null;
		
	}
	
	/**
	 * 
	 * The method we will give the user's search query to. 
	 * Tokenizes the search and attempts to parse the tokens.
	 * Information on the search is stored in the parser
	 * 
	 */
	public void parseSearch(String text) {
		Tokenizer tokenizer = new Tokenizer();
		
		ArrayList<Object> tokens = tokenizer.tokenizeString(text);
		
		parseExpression(tokens);
	}
	
	/* 
	 * Extract information from an expression. An expression should be:
	 * <exp> = <term>, <exp> | <term>
	 */
	private void parseExpression(ArrayList<Object> tokens) {
		
		if(tokens == null || tokens.isEmpty() || tokens.size() == 0) return;
		
		//A term should not start with a comma token. Ignore if they are present
		if(tokens.get(0) == (Object) ',') {
			
			errorStrings.add("Warning: Search term starts with a comma!");
			tokens.remove(0);
			parseExpression(tokens);
			return;
		}
		
		//A term should not start with an operator.
		if(operators.contains(tokens.get(0))) {
			
			errorStrings.add("Attempted to start a term with operator: [" + tokens.get(0).toString() +  "]");
			while(!tokens.isEmpty()) {
				
				if(tokens.get(0).equals(',')) {
					tokens.remove(0);
					break;
				}
				tokens.remove(0);
			}
			parseExpression(tokens);
			return;
		}
		
		parseTerm(tokens);

		/*
		 * Terms start and end after a comma.
		 * Remove all tokens associated with the first term and the comma separating it from the next term if it exists.
		 */
		while(!tokens.isEmpty()) {
	
			if(tokens.get(0).equals(',')) {
				tokens.remove(0);
				break;
			}
			tokens.remove(0);
		}
		
		//If the previous term was the final term in the list of tokens.
		if(tokens.isEmpty()) return;

		parseExpression(tokens);
		
	}
	
	
	/*
	 * 
	 * Extract information from a term. A term should be:
	 * <term>		= <id> | <op_keyword> | <id_keyword> | "<id>" 
	 */
	private void parseTerm(ArrayList<Object> tokens) {

		if(op_keywords.contains(tokens.get(0)))
			parseOPKeyword(tokens);
		
		else if(id_keywords.contains(tokens.get(0)))
			parseIDKeyword(tokens);
		
		
		else {
			String identifier = parseIdentifier(tokens.get(0));
			
			if(identifier == null) {
				
				errorStrings.add("Your search term: [" + tokens.get(0) + "] is too short or invalid!" );
				return;
			}
			
			searchTerms.add(identifier);
		}
	}
	
	
	/*
	 * Extract information from an op_keyword:
	 * <op_keyword>	= PAGES <op> <int> | COST <op> <int> | EDITION <op> <int>
	 */
	private void parseOPKeyword(ArrayList<Object> tokens) {
		
		//Not enough tokens to be valid
		if(tokens.size() < 3) {
			
			errorStrings.add("Keyword [" + tokens.get(0) + "] is missing an operator or integer!");
			return;
		}
		
		//Note that method is called if and only if 1st token is a string
		String key = (String) tokens.get(0);
		Character op = null;
		Integer posInt = null;
		
		//2nd token must be an operator to be valid
		if(operators.contains(tokens.get(1))) op = (Character) tokens.get(1);
		else {
			
			errorStrings.add("Invalid operator: [" + tokens.get(1).toString() +  "] following keyword [" + tokens.get(0).toString() +"]");
			return;
		}
		
		//3rd token must be a positive integer (and 0 but less than 10 thousand)
		if(tokens.get(2).getClass() == Integer.class) posInt = (Integer) tokens.get(2);
		else {
			
			errorStrings.add("Invalid integer: [" + tokens.get(2).toString() +  "] following keyword [" + tokens.get(0).toString() + " " + tokens.get(1).toString() + "] is too large or not an integer!");
			return;
		}
		
		//Related to the instance's operation arrays. See comments for them (located at start of the class)
		int index;
		
		//Token contains a valid <op_keyword>. Check which operator
		switch(op) {
		
		case '<': 
			index = 0;
			break;
			
		case '>':
			index = 1;
			break;
			
		case '=':
			index = 2;
			break;
			
		default:
			
			//Impossible block unless error in code or operator is missing case statement
			
			System.out.println("Invalid operator: " + op + " Check ArrayList operators and that parseOPKeyword has switch case for this operator");
			return;
		
		}

		
		//Replace only if the number is null or if number will filter more searches
		if(key == "PAGES") {
			
			
			//Empty number or =
			if(index == 2) {
				pageOperation[index] = posInt;
				return;

			}

			//Entry for less than <
			if(index == 0) {
				if(pageOperation[1] != null && pageOperation[1] > posInt) errorStrings.add("Your range for [PAGES] is invalid!");
				
				if(pageOperation[0] == null || pageOperation[0] > posInt) pageOperation[index] = posInt;

			}
				
			
			//Entry for less than >
			if(index == 1) {
				if(pageOperation[0] != null && pageOperation[0] < posInt) errorStrings.add("Your range for [PAGES] is invalid!");
				
				if(pageOperation[1] == null || pageOperation[1] > posInt) pageOperation[index] = posInt;

			}
			
		}
		
		else if(key == "COST") {
			
			
			//Empty number or =
			if(index == 2) {
				costOperation[index] = posInt;
				return;

			}

			//Entry for less than <
			if(index == 0) {
				if(costOperation[1] != null && costOperation[1] > posInt) errorStrings.add("Your range for [COST] is invalid!");
				
				if(costOperation[0] == null || costOperation[0] > posInt) costOperation[index] = posInt;

			}
				
			
			//Entry for less than >
			if(index == 1) {
				if(costOperation[0] != null &&costOperation[0] < posInt) errorStrings.add("Your range for [COST] is invalid!");
				
				if(costOperation[1] == null || costOperation[1] > posInt) costOperation[index] = posInt;

			}
			
		}
		
		else if(key == "EDITION") {
			
			//Empty number or =
			if(index == 2) {
				editionOperation[index] = posInt;
				return;

			}

			//Entry for less than <
			if(index == 0) {
				if(editionOperation[1] != null && editionOperation[1] > posInt) errorStrings.add("Your range for [EDITION] is invalid!");
				
				if(editionOperation[0] == null || editionOperation[0] > posInt) editionOperation[index] = posInt;

			}
				
			
			//Entry for less than >
			if(index == 1) {
				if(editionOperation[0] != null &&  editionOperation[0] < posInt) errorStrings.add("Your range for [EDITION] is invalid!");
				
				if(editionOperation[1] == null || editionOperation[1] > posInt) editionOperation[index] = posInt;

			}
			
		}
		
		//Add additional OPkeyword if statements here
		
	}

	
	/*
	 * Extract information from an id_keyword:
	 * <id_keyword>	= TOPIC: <id> | CODE: <id>
	 */
	private void parseIDKeyword(ArrayList<Object> tokens) {
		
		//Already checked first token is a keyword in parseTerm()
		String key = (String) tokens.get(0);
		
		
		
		
		//Not enough tokens to be valid
		if(tokens.size() < 3) {
			
			errorStrings.add("Keyword [" + tokens.get(0) + "] is missing colon or identifer!");
			return;
		}
		
		if(tokens.get(1) != (Object) ':') {
			
			errorStrings.add("Invalid symbol: [" + tokens.get(1).toString() + "] following keyword [" + tokens.get(0).toString() +  "]" );
			return;
		}

		//ISBN takes an integer rather than an identifier
		if(key == "ISBN") {
			
			if(tokens.get(2).getClass() != String.class) {
				
				errorStrings.add("Your ISBN: [" + tokens.get(2).toString() + "] contains an error!" );
				return;
			}
			
			String isbn = isbnFormat((String) tokens.get(2));
			
			if(isbn == null) {
				errorStrings.add("Your ISBN: [" + tokens.get(2).toString() + "] contains an error!" );
				return;
			}
			
			if(ISBN != null) errorStrings.add("Warning: You can only search for one ISBN at a time! " + ISBN + " was ignored");
			ISBN = isbn;
			return;
		}
		
		
		//The third token is the related ID
		String id = parseIdentifier(tokens.get(2));

		//Error if identifier is a keyword or not long enough
		if(id == null) {
			errorStrings.add("The term: [" + tokens.get(2) + "] following keyword [" + tokens.get(0) + "] is invalid!" );
			return;
		}
		
		id = id.toLowerCase();
		
		if(key == "TOPIC") {
			topicTerms.add(id);
			return;
		}
		
		if(key == "CODE") {
			codeTerms.add(id);
			return;
		}
		
		System.out.println("Tried to parseIDKeyword but keyword was not an ID keyword!");
	}
	



	/*
	 * NOTE: 
	 * - This returns a String unlike other parse methods since 
	 *   id's can be stored in different arrays depending on the term.
	 *   
	 * - This takes a single token rather than the entire list
	 * 
	 * Extract information from an id:
	 * <id> = (any string of length greater than 2)
	 * 
	 * id cannot be a used keyword, symbol, integer and must be of type String
	 * id should be at least 3 letters minimum
	 * 
	 * Error messages are dealt with in higher method calls since we want to let
	 * the user know which part of their search is incorrect
	 * 
	 * @return null if requirements not met. Else the first token as type String
	 */
	private String parseIdentifier(Object token) {
		
		if(token.getClass() != String.class || op_keywords.contains(token) || id_keywords.contains(token)) {
			return null;
		}
		
		String searchTerm = (String) token;
		
		if(searchTerm.length() < 3) {
			return null;
		}
		
		
		return searchTerm;
		
	}


	/**
	 * 
	 * An isbn is either 10 or 13 digits long. Dashes are allowed
	 * 
	 * @Return null if invalid. ISBN without dashes if valid
	 */

	private String isbnFormat(String string) {
		
		String isbn = "";
		
		for(int index = 0; index < string.length(); index++) {

			if(!digits.contains(string.charAt(index)) && string.charAt(index) != '-') return null;
			
			if(digits.contains(string.charAt(index))) isbn = isbn + string.charAt(index);
			
		}
		
		
		if(isbn.length() != 10 && isbn.length() != 13) 	return null;
		
		
		return isbn;
	}
	

	

}
