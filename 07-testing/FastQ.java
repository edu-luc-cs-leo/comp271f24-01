public class FastQ {

    private String[] array;
    private int size;
    private int used;
    private int front;
    private int back;

    private static final int DEFAULT_SIZE = 4;

    /**
     * Full constructor
     */
    public FastQ(int size) {
        if (size < 1) {
            size = DEFAULT_SIZE;
        }
        this.size = size;
        this.array = new String[this.size];
        this.used = 0;
        this.front = 0;
        this.back = 0;
    } // full constructor

    /**
     * Default constructor
     */
    public FastQ() {
        this(DEFAULT_SIZE);
    } // default constructor

    /**
     * This method adds an element to a queue object
     * in constant-time. This is achieved by not looping
     * over the entire array. We keep track of the back
     * of the queue in this case. Since queues follow
     * the first-in / first-out principle, the element
     * is added to the back. We add that element,
     * increment the back pointer to be the element
     * we added, and increment this.used to show
     * that another space has been taken up.
     *
     * @param string: element to be added
     * @return boolean: true if the element was successfully added,
     * false if otherwise;
     */
    public boolean add(String string) {
        boolean added = false;

        if (this.used != this.size) {
            // add new element to the back of the queue
            this.array[this.back] = string;
            // Shift back element one position to the right. % this.size
            // ensures that if the back index goes out of bounds, it is
            // reset to index 0
            this.back = (this.back + 1) % this.size;
            // Increment used to reflect the addition of an element
            this.used++;
            added = true;
        } // guard statement

        return added;
    } // method add


    /**
     * This method removes an element from a queue object
     * in constant-time. This is achieved by not looping
     * over the entire array. Rather, we keep track of the
     * element at the front and back of the array. Since a
     * queue uses first-in / first-out logic, we can
     * simply set the first element to null and shift
     * the "front" element one index to the right.
     * This is more efficient than using a loop as
     * the intermediate elements are not logged or
     * touched.
     *
     * @return String: the element that was removed
     */
    public String remove() {
        String removed = this.array[this.front];

        if (this.used != 0) {
            // set first element to null (FIFO)
            this.array[this.front] = null;
            // shift front one element to the right. % this.size ensures that
            // the index does not go out of bounds
            this.front = (this.front + 1) % this.size;
            // Since we removed an element, decrement the space taken up
            this.used--;
        } // guard statement

        return removed;
    } // method remove


} // class FastQ
