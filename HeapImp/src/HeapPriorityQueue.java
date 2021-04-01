import java.util.Arrays;
import java.util.NoSuchElementException;

// Implements a priority queue of comparable objects using a
// min-heap represented as an array.
public class HeapPriorityQueue<E extends Comparable<E>> {
    private E[] elementData;
    private int size;
    
    // Constructs an empty queue.
    @SuppressWarnings("unchecked")
    public HeapPriorityQueue() {
        elementData = (E[])new Comparable[10];
        size = 0;
    }
    
    // Adds the given element to this queue.
    //Justin
    public void add(E value) {
        if(size == elementData.length - 1){
            elementData = Arrays.copyOf(elementData, 2 * elementData.length);
        }
        //adding in heap to rightmost leaf
        elementData[size() + 1] = value;

        int curIndex = size + 1;
        boolean correctPosition = false;
        while(!correctPosition && hasParent(curIndex)){
            int parent = parent(curIndex);
            if(elementData[curIndex].compareTo(elementData[parent]) < 0){
                swap(elementData, curIndex, parent);
                curIndex = parent(curIndex);
            } else {
                correctPosition = true;
            }
        }
        size++;
    }
    
    // Returns true if there are no elements in this queue.
    //Justin
    public boolean isEmpty() {
        if(elementData[0] == null)
            return false;
        return true;
    }
    
    // Returns the minimum value in the queue without modifying the queue.
    // If the queue is empty, throws a NoSuchElementException.
    //Justin
    public E peek() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        //Since it is a min heap the minimum value is the first value of the array
    	return elementData[0];
    }
    
    // Removes and returns the minimum value in the queue.
    // If the queue is empty, throws a NoSuchElementException.
    public E remove() {
        //TO DO
    	return null;
    }
    
    // Returns the number of elements in the queue.
    public int size() {
    	// TO DO
        return 0;
    }
    
    // Returns a string representation of this queue, such as "[10, 20, 30]";
    // The elements are not guaranteed to be listed in sorted order.
    public String toString() {
        String result = "[";
        if (!isEmpty()) {
            result += elementData[1];
            for (int i = 2; i <= size; i++) {
                result += ", " + elementData[i];
            }
        }
        return result + "]";
    }
    
    
    // helpers for navigating indexes up/down the tree
    private int parent(int index) {
    	// TO DO
        return -1;
    }
    
    // returns index of left child of given index
    private int leftChild(int index) {
    	// TO DO
        return -1;
    }
    
    // returns index of right child of given index
    private int rightChild(int index) {
    	// TO DO
        return -1;
    }
    
    // returns true if the node at the given index has a parent (is not the root)
    private boolean hasParent(int index) {
    	// TO DO
        return false;
    }
    
    // returns true if the node at the given index has a non-empty left child
    private boolean hasLeftChild(int index) {
    	// TO DO
        return false;
    }
    
    // returns true if the node at the given index has a non-empty right child
    private boolean hasRightChild(int index) {
    	// TO DO
        return false;
    }
    
    // switches the values at the two given indexes of the given array
    private void swap(E[] a, int index1, int index2) {
    	// TO DO
    }
}
