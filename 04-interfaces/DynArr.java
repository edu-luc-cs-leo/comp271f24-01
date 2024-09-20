
/**
 * A simple class to demonstrate dynamic behavior with arrays. Objects of this
 * class store strings in an array that grows to match the demand for storage.
 * 
 * The class is based on an underlying string array. Objects can be initialized
 * to any size; otherwise they'll be initialized to the default size. For
 * example,
 * 
 * DynamicArray da1 = new DynamicArray(10);
 * 
 * will have initially room for 10 strings, while
 * 
 * DynamicArray da2 = new DynamicArray();
 * 
 * will have initially room for 4 strings.
 */
public class DynArr implements Comparable271<DynArr> {

    /** Default size for underlying array */
    private static final int DEFAULT_SIZE = 4;

    /** The underlying array for this class */
    private String[] foundation;

    /** Measures how many places in the array are in use */
    private int occupancy;

    /**
     * Full constructor. Initializes the underlying array to the specified size. The
     * size must be a positive, non zero value. Otherwise the constructor uses the
     * default size value.
     */
    public DynArr(int size) {
        // If size <= 0 use default -- this is a good time to demo ternary operator
        size = (size > 0) ? size : DEFAULT_SIZE;
        this.foundation = new String[size];
        this.occupancy = 0;
    } // full constructor

    /**
     * Array-based constructor -- used for testing. Originally this constructor used
     * a shallow array copy (foundation=data). The revised code below creates a deep
     * copy of data into foundation.
     * 
     * @param data
     */
    public DynArr(String[] data) {
        this(DEFAULT_SIZE);
        if (data != null) {
            this.foundation = new String[data.length];
            for (int i = 0; i < data.length; i++) {
                this.foundation[i] = data[i];
            }
            this.occupancy = data.length;
        }
    } // array-based constructor

    /**
     * Default constructor
     */
    public DynArr() {
        this(DEFAULT_SIZE);
    } // default constructor

    /**
     * Accessor for this.foundation
     */
    public String[] getFoundation() {
        return this.foundation;
    } // method getFoundation

    /**
     * Implements the Comparable inteface. The method determines if the current
     * object (this) is greater, same, or less than the called object (other). Size
     * is computed as the number of characters in each object. The method treats
     * null objects as zero length. The following comparisons are considered:
     * 
     * notNull.compareTo(null) ..... returns 1 because a not null object, even with
     * zero characters has more substance than a null
     * 
     * notNull.compareTo(notNull) .. computers the actual character count for both
     * objects and returns their difference
     * 
     * The comparison
     * 
     * null.compareTo(whatever)
     * 
     * is not considered because the method is called by an instance of class
     * Dynamic Array (i.e., "this") and therefore the invoking object is never null.
     * 
     * @param other Dynamic Array object to compare this instance with
     * @return a negative int if this instance is letter than the other object, 0
     *         if the two objects have the same size, and a positive int when
     *         this instance is greater than the other object.
     */
    public int compareTo(DynArr other) {
        int diff = 1;
        if (other != null) {
            diff = countCharacters(this) - countCharacters(other);
        }
        return diff;
    } // method compareTo

    /**
     * Counts the characters in all strings of a Dynamic Array object. The method is
     * private and can be called only from this.compareTo. The compareTo method
     * ensures that countCharacters will never be called with a null arguments.
     * 
     * @param da Dynamic array object to count its characters (string lengths),
     *           guaranteed to never be null.
     * @return the total number of characters among all strings stored in the
     *         object's underlying array.
     */
    private int countCharacters(DynArr da) {
        int characterCount = 0;
        for (String s : da.getFoundation()) {
            if (da != null) {
                characterCount += s.length();
            }
        }
        return characterCount;
    } // method countCharacters

    /**
     * Checks if the specified string is present in the dynamic array.
     * 
     * @param target The string to search for in the array
     * @return true if the string is found, false otherwise
     */
    public boolean contains(String target) {
        boolean found = false;
        /*
         * Before introducing this.occupancy in the object, the method traversed
         * this.foundation through its entire length, i.e., the while loop allowed its
         * index i to reach this.foundation.length. As we saw, however, not every
         * element in this.foundation may be used. this.occupancy tells us what is the
         * last used element in this.foundation. There is no point searching after that
         * element, as all values are going to be null. So, for the while loop here we
         * change the condition from while(i<this.foundation length &...) to
         * while(i<this.occupancy &&...)
         */
        if (target != null && this.foundation != null) {
            int i = 0;
            // No need to guard against occupancy==0, because if array is empty, loop will
            // not even run.
            while (i < this.occupancy && !found) {
                found = this.foundation[i] != null && this.foundation[i].equals(target);
                i++;
            }
        }
        return found;
    } // method contains

    /**
     * Retrieves the string at the specified index in the array.
     * 
     * @param index The index of the string to retrieve
     * @return The string at the specified index, or null if the index is invalid
     */
    public String get(int index) {
        String string = null;
        // No need to guard against occupancy==0, because if array is empty, the method
        // will return null anyway
        if (index >= 0 && this.foundation != null && index < this.foundation.length) {
            string = this.foundation[index];
        }
        return string;
    } // method get

    /**
     * Removes the string at the specified index in the array and sets its position
     * to null. Then it moves every element to the right of the removed element, one
     * position to the left. The position of the last element to be copied to the
     * left is then emptied out (null).
     * 
     * @param index The index of the string to remove
     * @return The string that was removed, or null if the index is invalid
     */
    public String remove(int index) {
        String removed = null;
        // We check occupancy, because there is no reason to perform this in an empty
        // array
        if (this.occupancy > 0 && index >= 0 && index < this.foundation.length) {
            removed = this.foundation[index];
            this.foundation[index] = null;
            // Shift things after the removed string, one position to the left
            for (int i = index; i < occupancy - 1; i++) {
                this.foundation[i] = this.foundation[i + 1];
            }
            // Previously last occupied cell, now empty
            this.foundation[occupancy - 1] = null;
            // update occupancy
            this.occupancy--;
        }
        return removed;
    } // method remove

    /**
     * Deletes the string at the specified index in the array.
     * 
     * This method uses this.remove and simply ignores the returned string.
     * 
     * @param index The index of the string to delete
     */
    public void delete(int index) {
        String whatEver = remove(index);
    } // method delete

    /**
     * Resizes the underlying array by increasing its capacity by 1.
     * 
     * This method is called internally when the current array reaches its capacity
     * and a new element needs to be inserted.
     */
    private void resize() {
        String[] temp = new String[this.foundation.length + 1];
        /*
         * Instead of:
         * for (int i = 0; i < this.foundation.length; i++) {
         * we can write
         * for (int i = 0; i < this.occupancy; i++) {
         * since there is no reason to copy null values from one array to another.
         */
        for (int i = 0; i < this.occupancy; i++) {
            temp[i] = this.foundation[i];
        }
        this.foundation = temp;
    } // method resize

    /**
     * Inserts a new string into the dynamic array.
     * 
     * If the string is not null and the array is full, it will be resized to
     * accommodate the new element.
     * 
     * @param string The string to insert into the array
     */
    public void insert(String string) {
        // Guard against null argument
        if (string != null) {
            // If there is no room left in underlying array, resize it first
            if (this.occupancy == this.foundation.length) {
                this.resize();
            }
            // Room in underlying array assured
            this.foundation[this.occupancy] = string;
            this.occupancy++;
        }
    } // method insert

    /** Driver/test code */
    public static void main(String[] args) {
        final String PASS = "Pass";
        final String FAIL = "Fail";
        final String NON_EXISTING = "COBOL";
        // Test data
        String[] testData = { "Java", "Python", "C", "C++", "Fortran" };
        DynArr test = new DynArr(testData);
    } // method main

} // class DynamicArray
