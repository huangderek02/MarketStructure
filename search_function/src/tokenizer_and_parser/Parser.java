package tokenizer_and_parser;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author u7117043
 *  
 * NOTE:
 * "<id>" for <term> is not yet implemented in tokenizer. If used it will allow symbols or keywords in the identifier.
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
 * <term>		= <id> | <op_keyword> | <id_keyword> | 	(unused alternative) "<id>"  
 * <id>			= (any string non keyword or symbol string)
 * <op_keyword>	= PAGES <op> <int> | COST <op> <int>
 * <op> 		= < | > | =
 * <int>		= (any positive or 0 integer)
 * <id_keyword>	= TOPIC: <id> | CODE: <id>
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
 */

public class Parser {
	
	//List of search terms the user wants in the books title
	ArrayList<String> searchTerms = new ArrayList<String>();
	
	ArrayList<String> topicTerms = new ArrayList<String>();
	
	ArrayList<String> codeTerms = new ArrayList<String>();
	
	/*
	 * Stores integers related to this filtering: 
	 * - Integer at [0] is related to < 
	 * - Integer at [1] is related to >
	 * - Integer at [2] is related to =
	 */
	Integer[] pageOperation = new Integer[3];
	Integer[] costOperation = new Integer[3];
	
	
	//Import special strings and characters
	static final ArrayList<Character> operators = new ArrayList<Character>(Arrays.asList('<', '>','='));
	
	static final ArrayList<String> op_keywords = new ArrayList<String>(Arrays.asList("PAGES", "COST"));
	
	static final ArrayList<String> id_keywords = new ArrayList<String>(Arrays.asList("TOPIC", "CODE"));
	
	static final ArrayList<Character> digits = Tokenizer.digits;
	
	
	
	/**
	 * Resets all instance variables to default: 
	 * removes all search terms and operation arrays.
	 * Should be called every time we parseSearch
	 */
	public void resetParser() {
		searchTerms = new ArrayList<String>();
		pageOperation = new Integer[3];
		costOperation = new Integer[3];
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
		
		//TODO:Remove when finished
		System.out.println(tokens);
		
		parseExpression(tokens);
	}
	
	/*
	 * TODO: Need to check if the first token is a comma or invalid and remove it
	 * 
	 * Extract information from an expression. An expression should be:
	 * <exp> = <term>, <exp> | <term>
	 */
	private void parseExpression(ArrayList<Object> tokens) {
		
		if(tokens == null || tokens.isEmpty() || tokens.size() == 0) return;
		
		//A term should not start with a comma token. Ignore if they are present
		if(tokens.get(0) == (Object) ',') {
			System.out.println("Warning: Search term starts with a comma!");
			tokens.remove(0);
			parseExpression(tokens);
			return;
		}
		
		//A term should not start with an operator.
		if(operators.contains(tokens.get(0))) {
			//TODO add to errors
			System.out.println("Attempted to start a term with operator: [" + tokens.get(0).toString() +  "], ADD TO ERRORS");
			tokens.remove(0);
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
		
//		System.out.println("\nremoved all before comma " + tokens);
		
		//If the previous term was the final term in the list of tokens.
		if(tokens.isEmpty()) return;

		parseExpression(tokens);
		
	}
	
	
	/*
	 * TODO: Add statement for "<id>". Only if we are using hard and soft search
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
			
			if(identifier == null) return;
			
			searchTerms.add(identifier);
		}
	}
	
	
	/*
	 * Extract information from an op_keyword:
	 * <op_keyword>	= PAGES <op> <int> | COST <op> <int>
	 */
	private void parseOPKeyword(ArrayList<Object> tokens) {
		
		//Not enough tokens to be valid
		if(tokens.size() < 3) {
			//TODO: Add to errors
			System.out.println("Tried to parse keyword with less than 3 tokens!, ADD TO ERRORS");
			return;
		}
		
		//Note that method is called if and only if 1st token is a string
		String key = (String) tokens.get(0);
		Character op = null;
		Integer posInt = null;
		
		//2nd token must be an operator to be valid
		if(operators.contains(tokens.get(1))) op = (Character) tokens.get(1);
		else {
			//TODO: Add to errors
			System.out.println("Invalid operator: [" + tokens.get(1).toString() +  "] following keyword: " + tokens.get(0).toString() + "ADD TO ERRORS");
			return;
		}
		
		//3rd token must be a positive integer (and or 0)
		if(tokens.get(2).getClass() == Integer.class) posInt = (Integer) tokens.get(2);
		else {
			//TODO: Add to errors
			System.out.println("Invalid integer: [" + tokens.get(2).toString() +  "] following keyword: " + tokens.get(0).toString() + tokens.get(1).toString() + "ADD TO ERRORS");
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
			
			System.out.println("Invalid operator: + " + op + " Check ArrayList operators and that parseOPKeyword has switch case for this operator");
			return;
		
		}

		if(key == "PAGES") {
			pageOperation[index] = posInt;
			return;
		}
		
		if(key == "COST") {
			costOperation[index] = posInt;
			return;
		}
		
		
	}

	
	/*
	 * Extract information from an id_keyword:
	 * <id_keyword>	= TOPIC: <id> | CODE: <id>
	 */
	private void parseIDKeyword(ArrayList<Object> tokens) {
		// TODO 
		
		//Not enough tokens to be valid
		if(tokens.size() < 3) {
			//TODO: Add to errors
			System.out.println("Tried to parse keyword with less than 3 tokens!, ADD TO ERRORS");
			return;
		}
		
		if(tokens.get(1) != (Object) ':') {
			//TODO: Add to errors
			System.out.println("Invalid symbol: [" + tokens.get(1).toString() + "] following keyword: " + tokens.get(0).toString() +  ", ADD TO ERRORS" );
			return;
		}

		//Note that method is called if and only if 1st token is a string
		String key = (String) tokens.get(0);
		
		//The third token is the related ID
		String id = parseIdentifier(tokens.get(2));

		//Note that if the id has an error it will be dealt with by parseIdentifier
		if(id == null) return;
		
		
		if(key == "TOPIC") {
			topicTerms.add(id);
			return;
		}
		
		if(key == "CODE") {
			codeTerms.add(id);
			return;
		}
		
		System.out.println("Tried to parseIDKeyword but keyword was not and ID keyword!");
	}
	
	/*
	 * NOTE: 
	 * - This returns a String unlike other parse methods since 
	 *   id's can be stored in different arrays depending on the term.
	 *   
	 * - This takes a single token rather than the entire list
	 * 
	 * Extract information from an id:
	 * <id> = (any string)
	 * 
	 * id cannot be a used keyword, symbol, integer and must be of type String
	 * id should be at least 3 letters minimum
	 * 
	 * @return null if requirements not met. Else the first token as type String
	 */
	private String parseIdentifier(Object token) {
		
		if(token.getClass() != String.class) {
			//TODO: Add to errors
			System.out.println("Invalid search term: [" + token.toString() + "], ADD TO ERRORS" );
			return null;
		}
		
		String searchTerm = (String) token;
		
		if(searchTerm.length() < 3) {
			//TODO: Add to errors
			System.out.println("Your search term: [" + searchTerm + "] is too short, ADD TO ERRORS" );
			return null;
		}
		
		
		return searchTerm;
		
	}

	

	
	public static void main(String[] args) {
		Parser a = new Parser();
		
		Object[] o = new Object[3];
		Integer i = 1;
		o[1] = i;
		if(o[1].getClass() == Integer.class) System.out.println("ASDASD");
		
//		a.parseSearch("There once was a ship, that put to see, PAGES<12, COST < TOPIC, Ez,  ");
//		
//		for(Integer ai: a.pageOperation) {
//			System.out.println(ai);
//		}
//		
		a.parseSearch(",<myNumbers: 123,TOPIC:ENGN12312, CODE :   AS1	, 123");
		
		
		System.out.println("page operation: ");
		for(Integer ai: a.pageOperation) {
			System.out.println(ai);
		}
	
		System.out.println("cost operation: ");
		for(Integer ai: a.costOperation) {
			System.out.println(ai);
		}
	
		System.out.println("topic terms: " + a.topicTerms);
		System.out.println("code terms: " + a.codeTerms);
		System.out.println("search terms: " + a.searchTerms);
 

	}
	
	/*Testing methods, not related to class
	 * 
	 * 	ArrayList<Integer> intA = new ArrayList<Integer>();
		
		intA.add(1);
		intA.add(2);
		intA.add(3);
		
		System.out.println(testm(intA));
	 * 
	 */
	private static String testm(ArrayList<Integer> ii) {
		
		testn(ii);
		
		return ii.toString();
	}

	private static ArrayList<Integer> testn(ArrayList<Integer> ii) {
		
		ii.remove(0);
		
		return ii;
	}
	

}
