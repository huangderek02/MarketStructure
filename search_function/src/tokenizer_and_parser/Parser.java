package tokenizer_and_parser;

import java.util.ArrayList;

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
 * <term>		= <id> | <op_keyword> | <id_keyword> | "<id>"  
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
	
	/*
	 * Stores integers related to this filtering: 
	 * - Integer at [0] is related to < 
	 * - Integer at [1] is related to >
	 * - Integer at [2] is related to =
	 */
	Integer[] pageOperation = new Integer[3];
	Integer[] costOperation = new Integer[3];
	
	
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
		
		if(tokens == null || tokens.isEmpty()) return;
		
		parseTerm(tokens.remove(0));

		/*
		 * A term must be followed by a comma. Any term should have consumed necessary tokens
		 * to be valid. Consume any tokens until a comma since any term must be followed by one
		 */
		while(!tokens.isEmpty()) {
	
			if(tokens.get(0).equals(",")) {
				tokens.remove(0);
				break;
			}
			tokens.remove(0);
		}
		
//		System.out.println("\nremoved all before comma " + tokens);
		
		//If last token is a comma do nothing
		if(tokens.isEmpty()) return;

		parseExpression(tokens);
		
	}
	
	private void parseTerm(Object token) {

		//if()

		parseIdentifier();
	}
	
	
	
	private void parseIdentifier() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		Parser a = new Parser();
		
		a.parseSearch("There once was a ship, that put to see, PAGES<123, COST TOPIC, Ez,  ");
	}

}
