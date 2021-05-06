//importSearchTreeNode;

// Class SearchTree stores and prints a binary search tree of
// objects of type E.  E must implement the Comparable<E>
// interface.

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SearchTree<E extends Comparable<E>> {
    private SearchTreeNode<E> overallRoot; // root of overall tree

    // post: constructs an empty search tree
    public SearchTree() {
        overallRoot = null;
    }

    // post: value added to tree so as to preserve binary search tree
    public void add(E value) {
        overallRoot = add(overallRoot, value);
    }

    // post: value added to tree so as to preserve binary search tree
    private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
        if (root == null) {
            root = new SearchTreeNode<E>(value);
        } else if (root.data.compareTo(value) >= 0) {
            root.left = add(root.left, value);
        } else {
            root.right = add(root.right, value);
        }
        return root;
    }

    // post: returns true if tree contains value, returns false otherwise
    public boolean contains(E value) {
        return contains(overallRoot, value);
    }   

    // post: returns true if given tree contains value, returns false otherwise
    private boolean contains(SearchTreeNode<E> root, E value) {
        if (root == null) {
            return false;
        } else {
            int compare = value.compareTo(root.data);
            if (compare == 0) {
                return true;
            } else if (compare < 0) {
                return contains(root.left, value);
            } else {   // compare > 0
                return contains(root.right, value);
            }
        }
    }

    // post: prints the data of the tree, one per line
    public void print() {
        printInorder(overallRoot);
    }

    // post: prints the data of the tree using an inorder traversal
    private void printInorder(SearchTreeNode<E> root) {
        if (root != null) {
            printInorder(root.left);
            System.out.println(root.data);
            printInorder(root.right);
        }
    }

    private static class SearchTreeNode<E> {
        public E data;                   // data stored in this node
        public SearchTreeNode<E> left;   // left subtree
        public SearchTreeNode<E> right;  //  right subtree

        // post: constructs a leaf node with given data
        public SearchTreeNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with the given data and links
        public SearchTreeNode(E data, SearchTreeNode<E> left,
                              SearchTreeNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }


    // post: value removed from tree so as to preserve binary search tree
    public void remove(E value) {
    	overallRoot = remove(overallRoot, value);
    }
    
    
 // post: value removed to tree so as to preserve binary search tree
    private SearchTreeNode<E> remove(SearchTreeNode<E> root, E value) {
    	if (root == null) {
    		return null;
    	} 
    	int comp = root.data.compareTo(value);
    	if (comp > 0) {
    		root.left = remove(root.left, value);
    	} else if (comp < 0) {
    		root.right = remove(root.right, value);
    	} else {
    		if (root.right == null) {
    			return root.left;
    		} else if (root.left == null) {
    			return root.right;
    		} else {
    			root.data = findSmallest(root.right);
    			root.right = remove(root.right, root.data);
    		}
    	}
    	return root;
    }
    
	
	// post: return the smallest value in the binary search tree  
    private E findSmallest(SearchTreeNode<E> root) {
    	if (root.left == null) {
    		return root.data;
    	} else {
    		return findSmallest(root.left);
    	}
    	
    }
	//Eric implemented the method
  //Adam: bug fixes
  //Justin: Time complexity
  //time complexity: O(n)
  //space complexity: O(n)
	  public void dfsIter() {
      Stack<SearchTreeNode<E>> stack = new Stack<>();
      SearchTreeNode<E> currentNode = overallRoot;
        while (!stack.empty() || currentNode != null)
        {
            if (currentNode != null)
            {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            else {
                currentNode = stack.pop();
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.right;
            }
        }
    }
  //Eric implemented the methods
  //Adam: bug fixes
  //Justin: Time complexity
	//time complexity: O(n)
	//space complexity: O(n)
	  public void dfsRecur() {
      dfsRecurHelper(overallRoot);
    }
    private void dfsRecurHelper(SearchTreeNode<E> node) {
      if (node == null) {
        return;
      }
      dfsRecurHelper(node.left);
      System.out.print(node.data + " ");
      dfsRecurHelper(node.right);
    }
}
