package tokenizer_and_parser;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 * @author u7117043
 * 
 * BTree test class
 * 
 * Note that BTree only relies on the textbook title.
 * 
 * More tests required but ignored due to limited time.
 * - tests for parent (more extensive)
 * - tests for children 
 * 
 */

public class BTreeTest{
	
	private static BTree tree3 = new BTree(3);
	private static BTree tree7 = new BTree(7);
	ArrayList<Textbook> expectedKeys;
	
	//Testbook subclass for tests. Only title is relevant
	private static class TextbookTitleOnly extends Textbook {

		private TextbookTitleOnly(String title) {
			super(null, title, 0, null, null, 0,0, 0, null, null);
		}
		
	}
	
	//Arbitrary textbooks for testing
	static Textbook a = new TextbookTitleOnly("a book");
	static Textbook b = new TextbookTitleOnly("b book");
	static Textbook c = new TextbookTitleOnly("c book");
	static Textbook d = new TextbookTitleOnly("d book");
	static Textbook e = new TextbookTitleOnly("e book");
	static Textbook f = new TextbookTitleOnly("f book");
	static Textbook g = new TextbookTitleOnly("g book");
	static Textbook h = new TextbookTitleOnly("h book");
	static Textbook i = new TextbookTitleOnly("i book");
	static Textbook j = new TextbookTitleOnly("j book");
	static Textbook k = new TextbookTitleOnly("k book");
	static Textbook l = new TextbookTitleOnly("l book");
	static Textbook m = new TextbookTitleOnly("m book");	
	static Textbook n = new TextbookTitleOnly("n book");	
	static Textbook o = new TextbookTitleOnly("o book");
	static Textbook p = new TextbookTitleOnly("p book");
	static Textbook q = new TextbookTitleOnly("q book");
	static Textbook r = new TextbookTitleOnly("r book");
	static Textbook s = new TextbookTitleOnly("s book");
	static Textbook t = new TextbookTitleOnly("t book");
	static Textbook u = new TextbookTitleOnly("u book");
	static Textbook v = new TextbookTitleOnly("v book");
	static Textbook w = new TextbookTitleOnly("w book");
	static Textbook x = new TextbookTitleOnly("x book");
	static Textbook y = new TextbookTitleOnly("y book");
	static Textbook z = new TextbookTitleOnly("z book");
	
	@Before
	public void setUp() {
		expectedKeys = new ArrayList<Textbook>();
		tree3 = new BTree(3);
		tree7 = new BTree(7);
	}
	
	public static void doubleInsert(Textbook tb) {
		tree3.insert(tb);
		tree7.insert(tb);
	}
	
	@Test(timeout = 1000)
	public void BTreeTestRoot() {
		tree3 = new BTree(3);
		tree7 = new BTree(7);
		
		doubleInsert(b);
		doubleInsert(a);
		doubleInsert(b);
		
		expectedKeys.add(a);
		expectedKeys.add(b);
		expectedKeys.add(null);
		
		assertEquals(expectedKeys, tree3.keys);
		assertTrue(tree3.isRoot);
		assertNull(tree3.parent);
		
		expectedKeys.clear();

		expectedKeys.add(a);
		expectedKeys.add(b);
		expectedKeys.add(null);
		expectedKeys.add(null);
		expectedKeys.add(null);
		expectedKeys.add(null);
		expectedKeys.add(null);
		
		assertEquals(expectedKeys, tree7.keys);
		assertTrue(tree7.isRoot);
		assertNull(tree7.parent);
	}
	

	
	@Test(timeout = 1000)
	public void BTreeTestNonChild3() {
		tree3 = new BTree(3);
		
		tree3.insert(t);
		tree3.insert(a);
		tree3.insert(g);
		tree3.insert(i);
		tree3.insert(j);
		tree3.insert(f);
		
		expectedKeys.add(g);
		expectedKeys.add(null);
		expectedKeys.add(null);
		
		assertEquals(expectedKeys, tree3.keys);
		
		expectedKeys.clear();
		
		expectedKeys.add(a);
		expectedKeys.add(f);
		expectedKeys.add(null);
		
		assertEquals(expectedKeys, tree3.children.get(0).keys);
		
		
		expectedKeys.clear();
		
		expectedKeys.add(i);
		expectedKeys.add(j);
		expectedKeys.add(t);
		
		assertEquals(expectedKeys, tree3.children.get(1).keys);
		
		tree3.insert(z);
		tree3.insert(x);
		tree3.insert(n);
		
		expectedKeys.clear();
		
		expectedKeys.add(g);
		expectedKeys.add(j);
		expectedKeys.add(x);
		
		assertEquals(expectedKeys, tree3.keys);
		
		expectedKeys.clear();
		
		expectedKeys.add(a);
		expectedKeys.add(f);
		expectedKeys.add(null);
		
		assertEquals(expectedKeys, tree3.children.get(0).keys);
		
		expectedKeys.clear();
		
		expectedKeys.add(i);
		expectedKeys.add(null);
		expectedKeys.add(null);
		
		assertEquals(expectedKeys, tree3.children.get(1).keys);
		
		
		expectedKeys.clear();
		
		expectedKeys.add(n);
		expectedKeys.add(t);
		expectedKeys.add(null);
		
		assertEquals(expectedKeys, tree3.children.get(2).keys);
		
		
		expectedKeys.clear();
		
		expectedKeys.add(z);
		expectedKeys.add(null);
		expectedKeys.add(null);
		
		assertEquals(expectedKeys, tree3.children.get(3).keys);
		

	}
	
	//TODO
	@Test(timeout = 1000)
	public void FindTest() {
		
	}
	
	//Null Pointer Exception: assertions redundant until fixed 
	@Test(timeout = 1000)
	public void BTreeTestBigTest() {
		
		tree3 = new BTree(3);
		
		tree3.insert(a);
		tree3.insert(b);
		tree3.insert(c);
		tree3.insert(d);
		tree3.insert(e);
		tree3.insert(f);
		tree3.insert(g);
		tree3.insert(h);
		tree3.insert(i);
		tree3.insert(j);
		tree3.insert(k);
		tree3.insert(l);
		tree3.insert(m);
		tree3.insert(n);
		tree3.insert(o);
		tree3.insert(p);
		tree3.insert(q);
		tree3.insert(r);
		tree3.insert(s);
		tree3.insert(t);
		tree3.insert(u);
		tree3.insert(v);
		tree3.insert(w);
		tree3.insert(x);
		tree3.insert(y);
		tree3.insert(z);
	}
	
	
	
}
	

