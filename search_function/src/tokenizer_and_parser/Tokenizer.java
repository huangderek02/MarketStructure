package tokenizer_and_parser;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author u7117043
 * 
 * The Tokenizer Class takes a String and tokenizes it, storing it in a list.
 * Special phrases: symbols, keywords and positive integers are stored as separate tokens. (see static final class variables)
 * 
 * Tokenizer ignores whitespace at the start and end of a token. Tokens stops at comma to allow for some flexibility 
 * in use of special phrases in a string:
 * 
 * E.g. The following string: "The 1900's greatest potato = a black hole" 
 * will be tokenized as SINGLE STRING rather than: ["The", 1900, "'s greatest potato", =, "a black hole"]
 *
 */

public class Tokenizer {
	
/*
 * These variables of tokenizer are not used currently as unlike in lecture
 * this class converts the entire string into tokens. 
 * 
 * Every string is technically valid since an identifier is simply a search query.
 * However not every string will result in a return.
 */
	

	/*
	 * List of special characters and keywords that act as separate tokens.
	 * 
	 * We keep digits as characters since the search terms can include them. (Not just used as integers)
	 */
	static final ArrayList<Character> symbols = new ArrayList<Character>(Arrays.asList('<', '>','=', /*'"',*/ ',', ':'));
	
	static final ArrayList<String> keywords = new ArrayList<String>(Arrays.asList("PAGES", "COST", "TOPIC", "CODE"));
	
	static final ArrayList<Character> digits = new ArrayList<Character>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
	
	
	/**
	 * Remove all white space characters at the start of a string. 
	 * White spaces are any combination of 'space' and 'tab'
	 * @param text The text we want to remove white spaces from
	 * @return String without initial white spaces. Spaces later are left as is
	 */
	public String consumeWhiteSpace(String text) {
		
		String r = text;
		
		if(!r.isEmpty() && (r.charAt(0) == ' ' || r.charAt(0) == '\t')) {
			r = r.substring(1,r.length());
			r = consumeWhiteSpace(r);
		}
		
		return r;
	}
	
	
	/**
	 * NOTE:
	 * This method should only be called on tokens that are identifiers since it ignores other keywords and symbols
	 * 
	 * Remove all white space characters at the end of a string. 
	 * This is necessary since identifiers end when a comma is reached
	 * White spaces are any combination of 'space' and 'tab'
	 * @param text The text we want to remove white spaces from
	 * @return String without initial white spaces. Spaces later are left as is
	 */
	public String consumeEndSpace(String text) {
		
		int finalCharIndex = 0;
		
		for(int i = 0; i < text.length(); i ++) {
			if(text.charAt(i) != ' ' && text.charAt(i) != '\t') finalCharIndex = i + 1;
			
		}
		
		
		return text.substring(0, finalCharIndex);
	}

	
	/**
	 * UNUSED, INTEGRATED INTO METHOD:
	 * tokenizeString()
	 * 
	 * Check if the next token is a keyword.
	 * @param text The text given should not be empty.
	 */
	private boolean nextIsKeyword(String text) {

		for(String k:keywords) {
			if(text.length() < k.length()) continue;
			if(text.substring(0,k.length()).equals(k)) return true;
		}
		return false;
	}
	
	
	/**
	 * NOTE:
	 * Method should work in tokenizeString but may cause error when called individually.
	 * This is because it does not check if the string is empty which is done by tokenizeString
	 * 
	 * Check if the next token is an integer.
	 * A valid integer token contains only digits with no white space or other characters between digits.
	 * White space after an integer is ignored. An integer ends when it reaches a comma (or text is empty)
	 * @param text The text given should not be empty.
	 */
	private boolean nextIsInteger(String text) {
		
		
		if(text.charAt(0) == ' ' || text.charAt(0) == '\t') {
			text = consumeWhiteSpace(text);
			
			if(text.isEmpty() || text.charAt(0) == ',') return true;
			else return false;
		}
		
		if(digits.contains(text.charAt(0))) {
			
			if(text.length() == 1 || text.charAt(1) == ',') return true;
			
			return nextIsInteger(text.substring(1,text.length()));
		}
		
		return false;
	}
	
	
	/**
	 * NOTE:
	 * If we want to convert to tokenizer like in lecture:
	 * 
	 * - Change linked list return to void (change method name to nextToken or something reflective)
	 * - Remove While loop
	 * - Add statement for empty text
	 * - uncomment the instance variables at the start of class and use those instead (refactoring may help clarify code though)
	 * 
	 * 
	 * Given a string return as a list of tokens:
	 * Integers are stored as [Integer]
	 * symbols are stored as [Characters]
	 * keywords and identifiers (non 
	 * 
	 * 
	 */
	public ArrayList<Object> tokenizeString(String text){
		
		
		ArrayList<Object> tokens = new ArrayList<Object>();
		
		String remainingText = consumeWhiteSpace(text);
		
		/*
		 * Adds tokens to the list while text still remains.
		 */
		while(!remainingText.isEmpty()) {

			//If next token is a keyword store corresponding keyword 
			for(String k:keywords) {
				
				if(remainingText.length() < k.length()) continue;
				
				if(remainingText.substring(0,k.length()).equals(k)) {
					tokens.add(k);
					
					remainingText = consumeWhiteSpace(remainingText.substring(k.length(), remainingText.length()));
					 break;
				}
			}
			if(remainingText.isEmpty()) break;
		
			
			/*	
			 * TODO: Delete this once 100% sure
			 * 
			 * BACKUP
			 * Old code.
			 * 
			 * Not as concise but works and is easy to follow. Needs if statement for every keyword
			 * 
			if(nextIsKeyword(remainingText)) {
				
				//keyword is PAGES
				if(remainingText.substring(0,5).equals("PAGES")) {
					
					tokens.add("PAGES");
					
					if(remainingText.length() > 5)remainingText = remainingText.substring(5, remainingText.length());
					else remainingText = "";
				}
				
				//keyword is TOPIC
				else if(remainingText.substring(0,5).equals("TOPIC")) {
					
					tokens.add("TOPIC");
					
					if(remainingText.length() > 5)remainingText = remainingText.substring(5, remainingText.length());
					else remainingText = "";
				}
				
				//keyword is COST
				else if(remainingText.substring(0,4).equals("COST") ) {
					tokens.add("COST");
					
					if(remainingText.length() > 4)remainingText = remainingText.substring(4, remainingText.length());
					else remainingText = "";
				}
				
				//keyword is CODE
				else if(remainingText.substring(0,4).equals("CODE")) {
					tokens.add("CODE");
					
					if(remainingText.length() > 4)remainingText = remainingText.substring(4, remainingText.length());
					else remainingText = "";
				}
				
				else if(remainingText.substring(0,7).equals("POTATOE")) {
					tokens.add("POTATOE");
					
					if(remainingText.length() > 7)remainingText = remainingText.substring(7, remainingText.length());
					else remainingText = "";
				}
				
				//After any symbol, whether it is an operator or not, the next token starts after we ignore white space infront of it
				remainingText = consumeWhiteSpace(remainingText);
				
				
			}
				*/
			
			

			//If next token is a symbol store corresponding symbol as a Character
			if(symbols.contains(remainingText.charAt(0))) {
				tokens.add(remainingText.charAt(0));
								
				if(remainingText.length() > 1) {
					remainingText = consumeWhiteSpace(remainingText.substring(1, remainingText.length()));
					
				}
				else remainingText = "";
				
				
			}
			
			/*
			 * If next token is an integer (Separated from identifiers to make it easy to understand)
			 * save token as an integer.
			 * 
			 * NOTE:
			 * consumeEndWhiteSpace makes the if statement for integer (ln 158 -170) redundant if we keep as strings
			 * This however may be necessary if we decide to it instead as an integer rather than convert it later with a try catch
			 */
			
			else if(nextIsInteger(remainingText)) {
				
				String integerToken = "";
				
				while(!remainingText.isEmpty() && digits.contains(remainingText.charAt(0))) {
					integerToken = integerToken + remainingText.charAt(0);
					remainingText = remainingText.substring(1,remainingText.length());
				}
				
				tokens.add(Integer.parseInt(integerToken));
				remainingText = consumeWhiteSpace(remainingText);
				
			}

			/* 
			 * TODO:
			 * 
			 * 1)
			 * If we decide to implement soft search and hard search as separate using quotations (like Google)
			 * then we need to separate identifiers for soft search. For example if we search:
			 * 
			 * Linear Algebra 		(soft search)
			 * "Linear Algebra"		(hard search)
			 * 
			 * The soft search will return all results that contain the string "Linear" or "Algebra" preferably with both
			 * The hard serach will return all results that contain the string "Linear Algebra" only.
			 * 
			 * 
			 * 2)
			 * Ignore all identifiers that are not at least length 3 
			 */
			
			/* 
			 * If next token is not a keyword or symbol, then it is a identifier. An identifier ends before the next comma
			 * The token is built by checking each character until it reaches a comma or it reaches the end of the string
			 */
			else {
				
				String identifier = "";						//The token we add.			
				String newRemainingText = remainingText;	//The text after we add the token
				
				for(int i = 0; i < remainingText.length(); i++) {
					
					if(remainingText.charAt(i) != ',') {
						identifier = identifier + remainingText.charAt(i);
						
						if(newRemainingText.length() > 1) newRemainingText = newRemainingText.substring(1,newRemainingText.length());
						else newRemainingText = "";
					}
					else break;
				}
				
				//Add the identifier without any end white space and remove this from the remainingText
				remainingText = newRemainingText;
				tokens.add(consumeEndSpace(identifier));
			}
			
			
		} //End of Loop
		
		return tokens;
	}
	

	
	//TODO REMOVE WHEN DONE
	
	public static void main(String[] args) {
		
		//Testing methods
		Tokenizer a = new Tokenizer();
		
		String s  = " ";
		s = a.consumeEndSpace(s);
		
		System.out.println(s + "|END");
		
		s = "123, adb ";
		
//		int sAsInt = Integer.parseInt(s);	//Must be after consume white space		
//		System.out.println(sAsInt); 		//ignores front zeroes
		
		System.out.println("0123456789");
		System.out.println("Is s an integer? " + a.nextIsInteger(s));
		
		
		//Testing with Object class
		
		Object ob = "420 a";
		
		Integer obi = 0;
		
		try {
			obi = Integer.parseInt((String )ob);
		}
		catch(Exception e){
			System.out.println("Object is no an Integer");

		}
		
		if(String.class.isInstance(ob)) System.out.println("ob is an object \n");
		else System.out.println("Not an instance of class \n");
		
		
		
		//Testing sub section of method
		
		String r = "PAGES <    123   , a, abc de 	, TOPIC PAGES COST  CODE CODE < < > = 12 PAGES, POTATOE";
		
		ArrayList<Object> result = a.tokenizeString(r);
		
		System.out.println(result);
		

		System.out.println(r);
		
		for(Object ins: result) {
			System.out.println(ins + " : is of class " + ins.getClass());
		}
		
		char c1 = 'a';
		Character c2 = 'a';
		
		System.out.println();
		
		String potato = "The 1900's greatest potato = a black hole, Another Token";
		
		System.out.println(a.tokenizeString(potato));
		
//		r = a.consumeWhiteSpace(r);
//		
//		System.out.println("Next is a keyword? " + a.nextIsKeyword(r));
//		

		
	} //End of Main
	
	
}
