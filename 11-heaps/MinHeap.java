import java.util.ArrayList;

/**
 * A simple minimum heap implementation. The class is parameterised for any
 * object E as long as it implements the Comparable interface. Such objects may
 * be typed as
 * 
 * class E implements comparable<E> {...}
 * 
 * for example,
 * 
 * class HuffmanNode implements Comparable<HuffmanNode> {...}
 * 
 * The minimum heap is stored in an array list.
 * 
 * NOTE ON MAGIC VALUE 2: this data structure is abstracted as a complete binary
 * tree whose nodes maintain the minimum heap property: parent values are always
 * less than the values of their children. The data structure is implemented by
 * an arraylist emulating the parent-children pointers as algebraic rules, e.g.
 * 
 * parent of position [i] = position [(i-1)/2]
 * 
 * Because these algebraic rules pertain to a <em>binary</em> tree, the literal
 * 2 is not consider a magic value.
 * 
 */
public class MinHeap<E extends Comparable<E>> {

    /** Arraylist to hold the contentes of the min heap */
    private ArrayList<E> heap;

    /** Default constructor */
    public MinHeap() {
        this.heap = new ArrayList<>();
    } // default constructor

    /**
     * Returns the number of items currently present in the heap
     * 
     * @return int with size of underlying arraylist
     */
    public int size() {
        return this.heap.size();
    } // method size

    /**
     * The position of the left child of node at position i in the array.
     * 
     * @param i parent index
     * @return index of parent's left child
     */
    private int leftChildIndex(int i) {
        return 2 * i + 1;
    } // method leftChildIndex

    /**
     * The position of the right child of node at position i in the array
     * 
     * @param i parent index
     * @return index of parent's right child
     */
    private int rightChildIndex(int i) {
        return 2 * (i + 1);
    } // method rightChildIndex

    /**
     * The position of the parent of a node at position i in the array
     * 
     * @param i child index
     * @return position of child's parent
     */
    private int parentIndex(int i) {
        return (i - 1) / 2;
    } // method parentIndex

    /**
     * Add a new value to the tree and ensure that the min-heap property is
     * observed.
     * 
     * @param value int value to add
     */
    public void insert(E e) {
        // Place the new value at the end of the arraylist
        this.heap.add(e);
        // Move the newly added value where it needs to be
        this.floatUp(heap.size() - 1);
    } // method insert

    /**
     * Ensure that the element at position i is properly moved through the array to
     * maintain the min. heap property. The element is compared to the value of its
     * parent node (whose position is available through the parentIndex method. If
     * the element's value is less that its parents', we swap places and try again,
     * noting that the element is now at the parent's position.)
     * 
     * @param i position of the element to ensure it's properly ... heapified.
     */
    private void floatUp(int i) {
        // Loop ends when item reaches the root of the tree (i==0) or when the heap
        // property parent < child is achieved earlier.
        while (i > 0 && heap.get(i).compareTo(heap.get(parentIndex(i))) < 0) {
            // Swap child with parent
            this.swap(i, parentIndex(i));
            // repeat for the new position of the child
            // (which is now where its parent was)
            i = parentIndex(i);
        }
    } // method floatUp

    /**
     * Swap places between two elements in the arraylist
     * 
     * @param i position of the first of the two elements
     * @param j position of the second of the two elements
     */
    private void swap(int i, int j) {
        E temp = this.heap.get(i);
        this.heap.set(i, this.heap.get(j));
        this.heap.set(j, temp);
    } // method swap

    /**
     * Obtain the minimum value in the arraylist without removing the element
     * 
     * @return the first element of the arraylist always contains the smallest value
     *         or null if heap already empty
     */
    public E getMin() {
        E minValue = null;
        if (this.heap.size() > 0) {
            minValue = this.heap.get(0);
        }
        return minValue;
    } // method getMin

    /**
     * Remove and return the smallest value in the array list, then rearrange the
     * arraylist to maintain the min. heap property. Rearrangement involves removing
     * the last element from the heap (ie the last element from the underlying
     * arraylist), inserting it at the top, probabaly violating the min-heap
     * property, then keep pushing that value down, below the smallest of the two
     * children, until the min-heap property is restored. This rearrangement is done
     * by method floatDn.
     * 
     * @return the first element of the arraylist which is always the smallest value
     *         in the arraylist.
     */
    public E removeMin() {
        // Item to return
        E minValue = null;
        if (this.heap.size() > 0) {
            minValue = this.getMin();
            E lastElement = this.heap.remove(this.heap.size() - 1);
            // Take the last item out of the arraylist and place it in the beginning (since
            // the element there is being returned as minValue)
            if (!this.heap.isEmpty()) {
                // Place the last element to the beginning of the heap. This will probably
                // violate the min heap property.
                this.heap.set(0, lastElement);
                // Restore min heap property by pushing the newly placed value as far down as
                // needed.
                this.floatDn(0);
            }
        }
        return minValue;
    } // method removeMin

    /**
     * Move a value down the tree where it is under a parent node with a smaller
     * value -- effectively we perform this operation by moving the value further
     * into the array until the min heap property is restored.
     * 
     * @param i value in array to move to a new position that restores the heap
     *          property
     */
    private void floatDn(int i) {
        int minIndex = i;
        // Check if node at [i] is greater than its left child -- this violates the
        // min-heap property and we may need to swap parent and left child.
        int left = this.leftChildIndex(i);
        if (left < this.heap.size() && this.heap.get(left).compareTo(this.heap.get(minIndex)) < 0) {
            minIndex = left;
        }
        // Check if node at [i] is greater than its right child -- again, this violates
        // the min-heap property.
        int right = rightChildIndex(i);
        if (right < this.heap.size() && this.heap.get(right).compareTo(this.heap.get(minIndex)) < 0) {
            minIndex = right;
        }
        /*
         * After these two checks we'll know if node [i] is greater than either of its
         * children, thus violating the min-heap property. We'll also know which child
         * is the smallest, so that we can swap the larger parent below it. And we
         * continue recursively until the min-heap property is restored. NOTE ON
         * RECURSION: for large heaps, this method could potentially lead to a stack
         * overflow. To avoid this, we can implement this method recursively.
         */
        if (i != minIndex) {
            this.swap(i, minIndex);
            this.floatDn(minIndex);
        }
    } // method floatDn

    /** Simple string representation */
    public String toString() {
        return this.heap.toString();
    } // method toString

} // class MinHeap
