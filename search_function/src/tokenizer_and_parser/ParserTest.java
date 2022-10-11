package tokenizer_and_parser;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 * @author u7117043
 * 
 * Parser Test Class
 * 
 * Checks the parser variables are correct since most methods are private.
 * The correctness can be checked by checking the result which is stored in
 * the parser variables.
 * 
 * Tests exist for the parser variables:
 * - searchTerms
 * - topicTerms
 * - codeTerms
 * - errorStrings
 * 
 * TODO: pageOperation, costOperation
 *
 */

public class ParserTest {
	
	
	Parser parser = Parser.getInstance();
	String input = "";
	ArrayList<String> expectedStrings = new ArrayList<String>();
	Integer[] expectedArray = new Integer[3];
	
	@Before
	public void setUp() {
		parser.resetParser();
		expectedStrings = new ArrayList<String>();
	}
	
	@Test(timeout = 1000)
	public  void parserErrorTest() {
		
		input = ", ab, 12, <, >, =, COST: \t \n 123, PAGES < 12a, EDITION > 456789, TOPIC, CODE < COMP2100, CODE: TOPIC, TOPIC: 12, EDITION < 12, EDITION > 14, PAGES < 300, PAGES >450, COST < 50, COST > 60  ,ISBN: 123-123-123-12123123, 3018239812381293812, EDITION ";
		
		parser.parseSearch(input);
		
		expectedStrings.add("Warning: Search term starts with a comma!");
		expectedStrings.add("Your search term: [" + "ab" + "] is too short or invalid!");
		expectedStrings.add("Your search term: [" + "12" + "] is too short or invalid!");
		expectedStrings.add("Attempted to start a term with operator: [" + "<" +  "]");
		expectedStrings.add("Attempted to start a term with operator: [" + ">" +  "]");
		expectedStrings.add("Attempted to start a term with operator: [" + "=" +  "]");
		expectedStrings.add("Invalid operator: [" + ":" +  "] following keyword [" + "COST" +"]");
		expectedStrings.add("Invalid integer: [" + "12a" +  "] following keyword [" + "PAGES <"  + "] is too large or not an integer!");
		expectedStrings.add("Invalid integer: [" + "456789" +  "] following keyword [" + "EDITION >"  + "] is too large or not an integer!");
		expectedStrings.add("Invalid symbol: [" + "," +  "] following keyword [" + "TOPIC" +"]");
		expectedStrings.add("Invalid symbol: [" + "<" + "] following keyword [" + "CODE" +  "]" );
		expectedStrings.add("The term: [" + "TOPIC" + "] following keyword [" + "CODE" + "] is invalid!" );
		expectedStrings.add("The term: [" + "12" + "] following keyword [" + "TOPIC" + "] is invalid!");
		expectedStrings.add("Your range for [EDITION] is invalid!");
		expectedStrings.add("Your range for [PAGES] is invalid!");
		expectedStrings.add("Your range for [COST] is invalid!");
		expectedStrings.add("Your ISBN: [" + "123-123-123-12123123" + "] contains an error!");
		expectedStrings.add("Keyword [" + "EDITION" + "] is missing an operator or integer!");
		
		assertEquals(expectedStrings,parser.errorStrings);
	}
	
	@Test(timeout = 1000)
	public void parserTestSearchTerms() {
		
		input = "Half Life 3, TOPIC: games, PAGEs < 12, <identity>, id, identity";

		parser.parseSearch(input);
		
		expectedStrings.add("Half Life 3");
		expectedStrings.add("PAGEs < 12");
		expectedStrings.add("identity");
		
		assertEquals(expectedStrings, parser.searchTerms);
		
	}
	
	@Test(timeout = 1000)
	public void parserTestTopicTerms() {
		
		input = "TOPIC: 123, TOPIC: <potatoes, TOPIC: Potates>, TOPIC: mathes, TOPICS: too, TOPIC  = mathes, TOPIC: 123a";
		
		parser.parseSearch(input);
		
		expectedStrings.add("Potates>");
		expectedStrings.add("mathes");
		expectedStrings.add("123a");
		
		
		assertEquals(expectedStrings, parser.topicTerms);
	}
	
	@Test(timeout = 1000)
	public void parserTestCodeTerms() {
		
		input = "CODE: 123, CODE: <potatoes, CODE: Potates>, CODE: mathes, code: too, CODE  = mathes, CODE: 123a";
		
		parser.parseSearch(input);
		
		expectedStrings.add("Potates>");
		expectedStrings.add("mathes");
		expectedStrings.add("123a");
		
		assertEquals(expectedStrings, parser.codeTerms);
	}
	
	
	@Test(timeout = 1000)
	public void parserTestISBN() {
		
		input = "ISBN: 12-3-2-2123-12,";
		
		parser.parseSearch(input);
		
		assertEquals("1232212312", parser.ISBN);
		
		input = "ISBN: 0123456-789-012";
		
		parser.parseSearch(input);
		
		expectedStrings.add("Warning: You can only search for one ISBN at a time! " + "1232212312" + " was ignored");
		
		assertEquals("0123456789012", parser.ISBN);
		
		assertEquals(expectedStrings ,parser.errorStrings );
	}
	
	@Test(timeout = 1000)
	public void parserTestPageOperation() {
		
		input = "PAGES = 453, PAGES: 12, PAGES < 12123123, PAGES < 4, PAGES < 20, PAGES > 2, PAGES > 10, PAGES = 36";
		
		expectedArray[0] = 4;
		expectedArray[1] = 2;
		expectedArray[2] = 36;
		
		parser.parseSearch(input);
		
		assertArrayEquals(expectedArray, parser.pageOperation);
	}
	
	@Test(timeout = 1000)
	public void parserTestCostOperation() {
		
		input = "COST = 453, COST: 12, COST < 12123123, COST < 4, COST < 20, COST > 2, COST > 10, COST > 10, COST = 36";
		
		expectedArray[0] = 4;
		expectedArray[1] = 2;
		expectedArray[2] = 36;
		
		parser.parseSearch(input);
		
		assertArrayEquals(expectedArray, parser.costOperation);
	}

	@Test(timeout = 1000)
	public void parserTestEditionOperation() {
		
		input = "EDITION = 453, EDITION: 12, COST < 12123123, EDITION < 4, EDITION < 20, EDITION > 2, EDITION > 10, EDITION > 10, EDITION = 36";
		
		expectedArray[0] = 4;
		expectedArray[1] = 2;
		expectedArray[2] = 36;
		
		parser.parseSearch(input);
		
		assertArrayEquals(expectedArray, parser.editionOperation);
	}
}





