package tokenizer_and_parser;

import com.example.marketstructure.Listing;
import com.example.marketstructure.MarketActivity;
import com.example.marketstructure.Textbook;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

//Used for sorting
import java.util.Collections;
import java.util.Comparator;

/**
 * Class and ALL methods created by:
 * @author u7117043
 * 
 * The actual textbook filterer that gets the textbooks for the UI.
 * Case INSENSITIVE when comparing search term to textbook values.
 * 
 * Uses the following classes:
 * - ListingTextbookData: contains the library of textbooks in the app
 * - BTree: stores the library of books in a Tree that can quickly find access relevant textbooks
 * - Parser: parses a user search following CFG to get data
 * 
 * Improvements:
 * - ISBN search is slow, improvement may require a BTre specific to search for it
 *
 *
 * How to use in UI Class:
 * 1) Get the text in the search bar as a string.
 * 2) Create a Textbook Searcher instance
 * 3) Use the TextbookSearcher method parserSearch() with the search string as input
 * 4) Use one of the sort methods on the Textbook Searcher instance (Most likely is sortAlphabeticalAscending)
 * 5) Use the TextbookSearcher method getResults() to get the related textbooks.
 * 
 * OPTIONAL
 * 6) Add error toast(s) when something goes wrong or results are empty
 *
 * Example:
 *
 * TextbookSearcher tbSearcher = new TextbookSearcher();
 * tbSearcher.parseSearch("The users search string goes here");
 * tbSearcher.sortAlphabeticalAscending();
 *
 * ArrayList<Textbook> results = tbSearcher.getResults();	<-- update recycle viewer with this
 *
 */
public class TextbookSearcher{

	static BTree BTreeTextbooks = new BTree(10);
	
	//Initialize BTree with books inserted
	static {
		for(Textbook tb: MarketActivity.listingsArrayList_search) BTreeTextbooks.insert(tb);
	}
	
	//Instance variables
	private Parser parser = Parser.getInstance();
	private ArrayList<Textbook> results;
	
	
	public TextbookSearcher() {
		results = new ArrayList<Textbook>();
	}
	
	public ArrayList<Listing> getResults(){

		ArrayList<Listing> r = new ArrayList<Listing>();

		for(Textbook tb : results){
			Listing tbListing = (Listing) tb;
			r.add(tbListing);
		}
		return r;
	}
	
	
	public void parseSearch(String text) {
		
		results.clear();
		parser.resetParser();
		
		parser.parseSearch(text);
		
		searchTermResults();
		
		topicFilter();
		
		codeFilter();
		
		pageFilter();
		
		costFilter();
		
		editionFilter();
		
		isbnTextbook();
	}
	
	
	
	//Add all textbooks related to terms from parser. Ignore duplicates
	private void searchTermResults() {
		
		HashSet<Textbook> termTextbooks = new HashSet<Textbook>();
		
		for(String term : parser.searchTerms) {
			termTextbooks.addAll(BTreeTextbooks.find(term));
		}
		
		results.addAll(termTextbooks);
	}
	
	//Filter Methods------------------------------------------------------------------------------------------------------------------------------
	
	//Remove textbooks that do not contain wanted topics
	void topicFilter() {
		
		if(parser.topicTerms.isEmpty() || results.isEmpty()) return;
		
		ArrayList<Textbook> filteredResults = new ArrayList<Textbook>(results);
		
		for(Textbook tb : results) 
			if(!parser.topicTerms.contains(tb.getTopic().toLowerCase())) filteredResults.remove(tb);
			
		results = filteredResults;
	}
	
	//Remove textbooks that do not contain wanted codes
	void codeFilter() {
		if(parser.codeTerms.isEmpty() || results.isEmpty()) return;
		
		ArrayList<Textbook> filteredResults = new ArrayList<Textbook>(results);
		
		for(Textbook tb : results) 
			if(!parser.codeTerms.contains(tb.getTopicCode().toLowerCase())) filteredResults.remove(tb);
			
		results = filteredResults;
	}
	
	
	//Add the textbook with wanted isbn to the start of the list. Doesnt rely on results being non empty
	void isbnTextbook() {
		if(parser.ISBN == null) return;
		
		for(Textbook tb : MarketActivity.listingsArrayList_search)
			if(tb.getIsbn().equals(parser.ISBN)) {
				
				if(results.contains(tb)) results.remove(tb);
				results.add(0,tb);
				return;
			}
	}
	
	//Remove textbooks that are not in range of specified pages
	void pageFilter() {
		
		if(results.isEmpty()) return;
		
		ArrayList<Textbook> filteredResults = new ArrayList<Textbook>(results);
		
		for(Textbook tb : results) {
			
			if(parser.pageOperation[0] != null && tb.getNumberOfPages() >= parser.pageOperation[0]) {
				filteredResults.remove(tb);
				continue;
			}
				
			
			if(parser.pageOperation[1] != null && tb.getNumberOfPages() <= parser.pageOperation[1]) {
				filteredResults.remove(tb);
				continue;
			}
			
			if(parser.pageOperation[2] != null && tb.getNumberOfPages() != parser.pageOperation[2]) {
				filteredResults.remove(tb);
				continue;
			}
		}
		
		results = filteredResults;
		
	}
	
	//Remove textbooks that are not in range of specified cost
	void costFilter() {
		
		if(results.isEmpty()) return;
		
		ArrayList<Textbook> filteredResults = new ArrayList<Textbook>(results);
		
		for(Textbook tb : results) {

			Listing tbAsListing = (Listing) tb;
			Double tbPrice = Double.parseDouble(tbAsListing.getListingPrice());

			if(parser.costOperation[0] != null && tbPrice >= parser.costOperation[0]) {
				filteredResults.remove(tb);
				continue;
			}
				
			
			if(parser.costOperation[1] != null && tbPrice <= parser.costOperation[1]) {
				filteredResults.remove(tb);
				continue;
			}
			
			//Rounded down price to nearest integer
			if(parser.costOperation[2] != null && (int) Math.round(tbPrice)  != parser.costOperation[2]) {
				filteredResults.remove(tb);
				continue;
			}
		}
		
		results = filteredResults;
	}
	
	//Remove textbooks that are not in range of specified editions
	void editionFilter() {
		if(results.isEmpty()) return;
		
		ArrayList<Textbook> filteredResults = new ArrayList<Textbook>(results);
		
		for(Textbook tb : results) {


			if(parser.editionOperation[0] != null && tb.getEdition() >= parser.editionOperation[0]) {
				filteredResults.remove(tb);
				continue;
			}
				
			
			if(parser.editionOperation[1] != null && tb.getEdition() <= parser.editionOperation[1]) {
				filteredResults.remove(tb);
				continue;
			}
			
			if(parser.editionOperation[2] != null && tb.getEdition()  != parser.editionOperation[2]) {
				filteredResults.remove(tb);
				continue;
			}
		}
		
		results = filteredResults;
		
	}
	
	
	//Sorter Methods------------------------------------------------------------------------------------------------------------------------------
	
	//Sort A-Z
	public void sortAlphabeticalAscending() {
		
		Collections.sort(results, new Comparator<Textbook>() {
		    @Override
		    public int compare(Textbook lhs, Textbook rhs) {
		        // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
		    	
		        return lhs.getTitle().toLowerCase().compareTo(rhs.getTitle().toLowerCase());
		    }
		});
	}
	
	//Sort Z-A
	public void sortAlphabeticalDescending() {
		
		sortAlphabeticalAscending();
		
		Collections.reverse(results);
	}
	
	
	//Cost from low to high
	public void sortCostAscending() {
		Collections.sort(results, new Comparator<Textbook>() {
		    @Override
		    public int compare(Textbook lhs, Textbook rhs) {
		       
		    	// -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
				Listing left = (Listing) lhs;
				Listing right = (Listing) rhs;
				Double leftPrice = Double.parseDouble(left.getListingPrice());
				Double rightPrice = Double.parseDouble(right.getListingPrice());

		    	if(leftPrice < rightPrice) return -1;
		    	if(leftPrice == rightPrice) return 0;
		    	return 1;
		    }
		});
	}
	
	//Cost from high to low
	public void sortCostDescending() {
		sortCostAscending();
		Collections.reverse(results);
	}
	
	
	//Sort by topic (Topics in A-Z)
	public void sortTopicAscending() {
		
		Collections.sort(results, new Comparator<Textbook>() {
		    @Override
		    public int compare(Textbook lhs, Textbook rhs) {
		        // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
		    	
		        return lhs.getTopic().toLowerCase().compareTo(rhs.getTopic().toLowerCase());
		    }
		});
	}
	
	//Sort by topic (Topics in Z-A)
	public void sortTopicDescending() {
		
		sortTopicAscending();
		
		Collections.reverse(results);
	}
	
	
	//Sort by edition from low to high
	public void sortEditionAscending() {
		
		Collections.sort(results, new Comparator<Textbook>() {
		    @Override
		    public int compare(Textbook lhs, Textbook rhs) {
		        // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending

		    	if(lhs.getEdition() < rhs.getEdition()) return -1;
		    	if(lhs.getEdition() == rhs.getEdition()) return 0;
		    	return 1;
		    }
		});

	}
	
	//Sort by edition from high to low
	public void sortEditionDescending() {
		
		sortEditionAscending();
		
		Collections.reverse(results);
	}
	
	
	//Sort by pages from low to high
	public void sortPageAscending() {
		Collections.sort(results, new Comparator<Textbook>() {
		    @Override
		    public int compare(Textbook lhs, Textbook rhs) {
		        // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending

		    	if(lhs.getNumberOfPages() < rhs.getNumberOfPages()) return -1;
		    	if(lhs.getNumberOfPages() == rhs.getNumberOfPages()) return 0;
		    	return 1;
		    }
		});

	}
	
	//Sort by pages from high to low
	public void sortPageDescending() {
		sortPageAscending();
		
		Collections.reverse(results);

	}
	
	
}
