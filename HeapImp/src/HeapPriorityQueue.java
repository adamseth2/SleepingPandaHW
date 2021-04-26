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
        elementData = (E[]) new Comparable[10];
        size = 0;
    }

    // Adds the given element to this queue.
    // Justin
    // TIME COMPLEXITY: O(log N)
    public void add(E value) {
        if (size == elementData.length - 1) {
            elementData = Arrays.copyOf(elementData, 2 * elementData.length);
        }
        // adding in heap to rightmost leaf
        elementData[size() + 1] = value;

        int curIndex = size + 1;
        boolean correctPosition = false;
        while (!correctPosition && hasParent(curIndex)) {
            int parent = parent(curIndex);
            if (elementData[curIndex].compareTo(elementData[parent]) < 0) {
                swap(elementData, curIndex, parent);
                curIndex = parent(curIndex);
            } else {
                correctPosition = true;
            }
        }
        size++;
    }

    // Returns true if there are no elements in this queue.
    // Justin
    // TIME COMPLEXITY: O(1)
    public boolean isEmpty() {
        if (size != 0)
            return false;
        return true;
    }

    // Returns the minimum value in the queue without modifying the queue.
    // If the queue is empty, throws a NoSuchElementException.
    // Justin
    // TIME COMPLEXITY: O(1)
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        // Since it is a min heap the minimum value is the first value of the array
        return elementData[1];
    }

    // Removes and returns the minimum value in the queue.
    // If the queue is empty, throws a NoSuchElementException.
    // Adam
    // TIME COMPLEXITY: O(log N)
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        // removes first element then moves last element to first element position
        E minValue = elementData[1];
        elementData[1] = elementData[size];
        elementData[size] = null;
        size--;
        int currNodeIndex = 1;
        boolean correctPosition = false;
        while (!correctPosition && hasLeftChild(currNodeIndex)) {
            int smallerChild;
            // sets what child is smaller
            if (rightChild(currNodeIndex) <= size
                    && elementData[leftChild(currNodeIndex)].compareTo((elementData[rightChild(currNodeIndex)])) < 0) {
                smallerChild = rightChild(currNodeIndex);
            } else {
                smallerChild = leftChild(currNodeIndex);
            }
            if (elementData[currNodeIndex].compareTo(elementData[smallerChild]) > 0) {
                swap(elementData, currNodeIndex, smallerChild);
            } else {
                correctPosition = true;
            }
        }
        // TO DO
        return minValue;
    }

    // ERIC Returns the number of elements in the queue.
    // TIME COMPLEXITY: O(1)
    public int size() {
        return size;
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

    // ERIC helpers for navigating indexes up/down the tree
    // TIME COMPLEXITY: O(1)
    private int parent(int index) {
        return index / 2;
    }

    // ERIC returns index of left child of given index
    // TIME COMPLEXITY: O(1)
    private int leftChild(int index) {
        return index * 2;
    }

    // ERIC returns index of right child of given index
    // TIME COMPLEXITY: O(1)
    private int rightChild(int index) {
        return index * 2 + 1;
    }

    // ERIC returns true if the node at the given index has a parent (is not the
    // root)
    // TIME COMPLEXITY: O(1)
    private boolean hasParent(int index) {
        return index > 1;
    }

    // ERIC returns true if the node at the given index has a non-empty left
    // TIME COMPLEXITY: O(1)
    private boolean hasLeftChild(int index) {
        return leftChild(index) <= size;
    }

    // ERIC returns true if the node at the given index has a non-empty right
    // TIME COMPLEXITY: O(1)
    private boolean hasRightChild(int index) {
        return rightChild(index) <= size;
    }

    // ERIC switches the values at the two given indexes of the given array
    // TIME COMPLEXITY: O(1)
    private void swap(E[] a, int index1, int index2) {
        E x = a[index1];
        a[index1] = a[index2];
        a[index2] = x;
    }
}
