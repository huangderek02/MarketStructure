package tokenizer_and_parser;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;



/**
 * Class and ALL methods created by:
 * @author u7117043
 * 
 * Tokenizer Test Class
 * 
 */
public class TokenizerTest {

	Tokenizer tokenizer = new Tokenizer();
	String testString;
	
	@Test(timeout = 1000)
	public void consumeWhiteSpaceTest() {
		testString = " \t \n a 123";
		
		assertEquals("consumeWhiteSpace did not remove 'space' character", "", tokenizer.consumeWhiteSpace(" "));
		assertEquals("consumeWhiteSpace did not remove 'tab' character", "", tokenizer.consumeWhiteSpace("\t"));
		assertEquals("consumeWhiteSpace did not remove 'new line' character", "", tokenizer.consumeWhiteSpace("\n"));
		
		assertEquals("consumeWhiteSpace() did not remove all whitespaces!", "a 123", tokenizer.consumeWhiteSpace(testString));
		
	}
	
	@Test(timeout = 1000)
	public void consumeEndSpaceTest() {
		testString = "a 123\n \t \t";
		
		assertEquals("consumeEndpace did not remove 'space' character", "", tokenizer.consumeEndSpace(" "));
		assertEquals("consumeEndSpace did not remove 'tab' character", "", tokenizer.consumeEndSpace("\t"));
		assertEquals("consumeEndSpace did not remove 'new line' character", "", tokenizer.consumeEndSpace("\n"));
		
		assertEquals("consumeEndSpace did not remove all whitespaces!", "a 123", tokenizer.consumeEndSpace(testString));
		
	}
	
	@Test(timeout = 1000)
	public void nextIsIntegerTest() {

		assertTrue(tokenizer.nextIsInteger("123"));
		assertTrue(tokenizer.nextIsInteger("012389012849318408"));
		assertTrue(tokenizer.nextIsInteger("123123, ABCD ++ \n,,>"));
		assertTrue(tokenizer.nextIsInteger("123 \t \n \t  , 123"));
		
		assertFalse(tokenizer.nextIsInteger(" 123, 123"));
		assertFalse(tokenizer.nextIsInteger("abcd"));
		assertFalse(tokenizer.nextIsInteger("-456"));
		assertFalse(tokenizer.nextIsInteger("123 23, a"));
		assertFalse(tokenizer.nextIsInteger("5 a,"));
	}
	
	@Test(timeout = 1000)
	public void tokenizeStringTestSimple() {
		
		ArrayList<Object> expected = new ArrayList<Object>();
		testString = "<>=,: PAGES COST TOPIC CODE EDITION ISBN, Potatoes, 123";
		
		expected.addAll(Tokenizer.symbols);
		expected.addAll(Tokenizer.keywords);
		expected.add(',');
		expected.add("Potatoes");
		expected.add(',');
		expected.add((Integer) 123);

		assertEquals(expected, tokenizer.tokenizeString(testString));
		
	}
	
	@Test(timeout = 1000)
	public void tokenizeStringTest1() {
		
		//Manually tokenized expected output
		ArrayList<Object> expected = new ArrayList<Object>(
				Arrays.asList("f24kWr>Wip6:",',',"B87l6:TOPICb5GjO",',',"PAGES","CX2MAM::",',',':',(Integer) 1,',', "30a",',', "210938128309128390182"));
	
		testString = "f24kWr>Wip6:,B87l6:TOPICb5GjO,PAGESCX2MAM::,:01,30a,210938128309128390182";
		

		assertEquals(expected, tokenizer.tokenizeString(testString));
		
	}
	
	
}
