/**
 * Implements O(1) queue operations
 */
public class FastQ {

    /** Underlying array for the queue */
    private String[] array;
    /** Size of the underlying array */
    private int size;
    /** How many elements are in the queue; cannot exceed size */
    private int used;
    /** front of the queue -- next element to remove */
    private int front;
    /** back of the queue -- next position to insert if used < size */
    private int back;

    private static final int DEFAULT_SIZE = 4;

    /** Full constructor */
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

    /** Default constructor */
    public FastQ() {
        this(DEFAULT_SIZE);
    } // default constructor

    /** Adds an element to the queue in O(1) if there is room in the array */
    public boolean add(String string) {
        boolean thereIsRoom = this.used < this.size;
        if (thereIsRoom && string != null) {
            // New element is added to the back position of the array
            this.array[this.back] = string;
            // Send the back to ... well ... the back, ensuring that it wraps
            // around to keep it within the array
            this.back = (this.back + 1) % this.size;
            // Update usage
            this.used++;
        }
        // Done
        return thereIsRoom;
    } // method add

    /** Removes the longest-stored value from the queue in O(1) */
    public String remove() {
        // Prepare to return null unless there are data stored in the array
        String returned = null;
        if (this.used > 0) {
            // Grab what's i the front
            returned = this.array[this.front];
            // Then empty the front
            this.array[this.front] = null;
            // Move the front to the next element, making sure it stays
            // within the array bounds
            this.front = (this.front + 1) % this.size;
            // Update the count of data stored in the array
            this.used--;
        }
        // Done
        return returned;
    } // method remove

} // class FastQ
