package tokenizer_and_parser;

import java.util.ArrayList;

/**
 * 
 * BTree Class for textbooks.
 * 
 * This class was created ENTIRELY from scratch using rules from COMP2100 lecture.
 * 
 * This class stores textbooks in a B-Tree with a set max number of keys. 
 * 
 * 
 * Errors: 
 * 
 * split(), having a BTree of height greater than 3 breaks the tree. 
 * Suspected error in children when splitting causing null pointer error
 *--------------------------------------------------------------------------------------
 * Improvements/refactoring/cleaning:
 * 
 * 	insert(): 
 *	 - split into smaller methods
 *	 - add multiple ways to insert (currently uses title only)
 * 
 * 	isRoot variable: 
 *	 - redundant as boolean (checking parent does the same)
 * 
 * 	find():
 * 	- add more precise find (This is related to improving insert method)
 * -------------------------------------------------------------------------------------
 * 
 * @author u7117043
 *
 */
public class BTree {
	
	int maxKeys;
	int maxChildren;	//equals max keys + 1
	
	ArrayList<Textbook> keys = new ArrayList<Textbook>();
	ArrayList<BTree> children = new ArrayList<BTree>();
	boolean isRoot;
	
	BTree parent = null;


	/**
	 * 
	 * Constructor for a new BTree. This should be called once
	 * when we construct a BTree.
	 * 
	 * @param maxKeys the max number of keys.
	 */
	BTree(int maxKeys){
		this.maxKeys = maxKeys;
		this.maxChildren = maxKeys + 1;
		isRoot = true;
		
		for(int i = 0; i < maxKeys; i++) keys.add(null);
		for(int i = 0; i < maxChildren; i++) children.add(null);
		
	}
	
	
	
	/** 
	 * 
	 * Private constructor used by addChild(). BTree is never a root
	 */
	private BTree(BTree parent) {
		isRoot = false;
		
		this.parent = parent;
		this.maxKeys = parent.maxKeys;
		this.maxChildren = parent.maxChildren;
		
		for(int i = 0; i < maxKeys; i++) keys.add(null);
		for(int i = 0; i < maxChildren; i++) children.add(null);
	}
	

	/**
	 * Return list of textbooks with title that contains the term
	 * @param term
	 */
	public ArrayList<Textbook> find(String term) {
		

		ArrayList<Textbook> returnList = new ArrayList<Textbook>();
		
		if(term == null) return returnList;
		
		int nextChild = 0;	//Search this child for more textbooks
		
		
		for(Textbook textbook: keys) {
			if(textbook == null) break;
			
			if(textbook.title.contains(term)) {
				returnList.add(textbook);
			}
			
			//Search child of the first textbook alphabetically greater than the term. Will be 0 if all greater than the term
			if(textbook.title.compareTo(term) < 0) {
				nextChild = keys.indexOf(textbook) +1;
			}
			
		}
		
		if(children.get(nextChild) == null) return returnList;
		returnList.addAll(children.get(nextChild).find(term));
		
		return returnList;
		
	}
	
	
	void insert(Textbook textbook) {
		
		
		//No duplicate textbooks
		if(textbook == null || keys.contains(textbook)) return;
		
		//When inserting into root
		if(isRoot) {
			
			//When root has no children and is not full
			if(keys.contains(null) && allNull(children)) {
				
				insertIntoKeys(textbook);
				return;
			}
			
			//When root has no children and is full
			if(!keys.contains(null) && allNull(children)) {
				
				splitRoot();
				insert(textbook);
				return;
			}
			
			//When root has children
			for(int i = 0; i < maxKeys; i++) {
				Textbook tb = keys.get(i);
				
				/*
				 * When we reach a null we go to closest pointer before it (which is child at index i)
				 * 
				 * OR
				 * 
				 * When we reach a title that is "greater than" the inserting textbook title alphabetically
				 */
				if(tb == null || textbook.title.compareTo(tb.title) < 0) {
					children.get(i).insert(textbook);
					return;
				}

			}
			
			//If we reach the end of the textbooks in keys than it must be greater than all alphabetically
			children.get(maxChildren-1).insert(textbook);
			return;
			
		} //End of if Root statement
		
		//When inserting into non root
		
		//When subtree has no children and is not full
		if(keys.contains(null) && allNull(children)) {
			
			insertIntoKeys(textbook);
			return;
		}
		
		//When subtree has no children and is full
		if(!keys.contains(null) && allNull(children)) {
			
			split();
			parent.insert(textbook);
			return;
		}
		
		//When subtree has children
		for(int i = 0; i < maxKeys; i++) {
			Textbook tb = keys.get(i);
			
			/*
			 * When we reach a null we go to closest pointer before it (which is child at index i)
			 * 
			 * OR
			 * 
			 * When we reach a title that is "greater than" the inserting textbook title alphabetically
			 */
			if(tb == null || textbook.title.compareTo(tb.title) < 0) {
				children.get(i).insert(textbook);
				return;
			}
		}
		
		//If we reach the end of the textbooks in keys than it must be greater than all alphabetically
		children.get(maxChildren-1).insert(textbook);
		return;
		
	} //End of insert method
	



	/**
	 * Check if a an array list contains non null values
	 * The list should not be null
	 * @param <T>
	 * 
	 */
	private static <T> boolean allNull(ArrayList<T> list) {
		
		for(T object : list) {
			if(object != null) return false;
		}

		return true;
	}


	
	/**
	 * Split a non root when keys are full by:
	 * - Moving median textbook to parent.
	 * - All keys less than median go to its left pointer. (Parent remains the same)
	 * - All keys greater than median go to its right pointer (Parent remains the same)
	 * 
	 */
	private void split() {
		
		int median = maxKeys/2;
		Textbook medianTB = null;
		
		BTree leftChild = new BTree(parent);
		
		BTree rightChild = new BTree(parent);
		
		for(int i = 0; i < maxKeys; i++) {
			
			//When i is less than median insert the key and its point into left child
			if(i < median) {
				leftChild.insertIntoKeys(keys.get(i));
				leftChild.children.set(i,children.get(i));
			}
			
			/*
			 * When i is greater than median insert the key and its point into left child
			 * Note that for i = median + 1 we want to set it at index 0 
			 */
			if(i > median){
				rightChild.insertIntoKeys(keys.get(i));
				rightChild.children.set(i - median - 1,children.get(i));
			}
			
			//Pointer is added to left child since we start at 
			if(i == median) {
				leftChild.children.set(i,children.get(i));
				medianTB = keys.get(i);
			}
			
		}


		
		// (When parent is or is not root and)? NOT full insert median into parent
		if(/*parent.isRoot &&*/ parent.keys.contains(null)) {
			
			//Correct the new parent for the left and right child's children.
			for(BTree bt : leftChild.children) {
				if(bt != null) bt.parent = this;
			}
			
			for(BTree bt : rightChild.children) {
				if(bt != null) bt.parent = rightChild;
			}
			
			int rightIndex = parent.children.indexOf(this) + 1;
			
			parent.insertIntoKeys(medianTB);
			
			this.keys = leftChild.keys;
			this.children = leftChild.children;
		
			parent.children.add(rightIndex, rightChild);
			parent.children.remove(null);
			return;	
		}
		
		
		//When parent is root and is full split it and insert key into parent
		if(parent.isRoot) {
			parent.splitRoot();
			
			leftChild.parent = this.parent;
			rightChild.parent = this.parent;
			
			//Correct the new parent for the left and right child's children.
			for(BTree bt : leftChild.children) {
				if(bt != null) bt.parent = this;
			}
			
			for(BTree bt : rightChild.children) {
				if(bt != null) bt.parent = rightChild;
			}
			
			int rightIndex = parent.children.indexOf(this) + 1;
			
			parent.insertIntoKeys(medianTB);
			
			this.keys = leftChild.keys;
			this.children = leftChild.children;
		
			parent.children.add(rightIndex, rightChild);
			parent.children.remove(null);
			return;	
		}
		
		/* When parent is not root and full split the parent. 
		 * Note that insert() will recursively split the tree until it can be added.
		 * 
		 * FIXME: Contains error. We need to change the parent but it is null for some situations. 
		 * 		  Additionally some keys go missing
		 */
		if(!parent.isRoot) {
			
			parent.split();
			int newParentIndex = this.parent.parent.children.indexOf(this.parent) + 1;
			this.parent = this.parent.parent.children.get(newParentIndex);
			
			
			return;
		}
		
	}


	/**
	 * 
	 * Split the root when keys are full by using the median key as the only key in the new root,
	 *  all keys less than the median key as the left child
	 *  all keys greater than median key as right child.
	 * 
	 * Note that children of the keys are also moved to the corresponding spot on the newly formed tree
	 * Uses set since it may be null and index of child matters 
	 * 
	 * Current tree stays as the root
	 */
	private void splitRoot() {
		
		//Median rounds down for odd. 3/2 becomes 1
		int median = maxKeys/2;
		Textbook medianTB = null;
		
		BTree leftChild = new BTree(this);
		
		BTree rightChild = new BTree(this);
		
		
		
		for(int i = 0; i < maxKeys; i++) {
			//When i is less than median insert the key and its point into left child
			if(i < median) {
				leftChild.insertIntoKeys(keys.get(i));
				leftChild.children.set(i,children.get(i));
			}
			
			/*
			 * When i is greater than median insert the key and its point into left child
			 * Note that for i = median + 1 we want to set it at index 0 
			 */
			if(i > median){
				rightChild.insertIntoKeys(keys.get(i));
				rightChild.children.set(i - median - 1,children.get(i));
			}
			
			//Pointer is added to left child since we start at 
			if(i == median) {
				leftChild.children.set(i,children.get(i));
				medianTB = keys.get(i);
			}
		}
		
		//Need to add right most pointer. Should be set at median index (Hard to think about. Shown by doing an example)
		rightChild.children.set(median, children.get(maxChildren - 1));
		
		keys = new ArrayList<Textbook>();
		children = new ArrayList<BTree>();
		
		for(int i = 0; i < maxKeys; i++) keys.add(null);
		for(int i = 0; i < maxChildren; i++) children.add(null);
		
		keys.set(0,medianTB);
		
		
		//Correct the new parent for the left and right child's children.
		for(BTree bt : leftChild.children) {
			if(bt != null) bt.parent = leftChild;
		}
		
		for(BTree bt : rightChild.children) {
			if(bt != null) bt.parent = rightChild;
		}
		
		children.set(0,leftChild);
		children.set(1,rightChild);
		
		
		
	}



	/**
	 * Insert a textbook into the keys. No checking whether it should be done
	 * Should only be done with keys has a null
	 * 
	 * @param textbook
	 */
	private void insertIntoKeys(Textbook textbook) {
		
		for(int i = 0; i < maxKeys; i++) {
			Textbook tb = keys.get(i);
			
			//Set to earliest null
			if(tb == null) {
				keys.set(i, textbook);
				return;
			}
			
			//Add title in alphabetical order and remove a null to keep size the same
			if(textbook.title.compareTo(tb.title) < 0) {
				keys.add(i, textbook);
				keys.remove(null);
				return;
			}
			
		}
		
		keys.add(textbook);
	

	}
	
	
	@Override
	public String toString() {
		return "\nKeys: " + keys + ", Children: " + children ;
		
	}
	
	

}
