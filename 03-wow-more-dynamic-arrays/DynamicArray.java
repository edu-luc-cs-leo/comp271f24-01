public class DynamicArray {

    private static final int DEFAULT_SIZE = 4;
    private String[] foundation;
    private int occupancy;

    // Constructor that initializes array with a given size, defaulting to 4 if size <= 0
    public DynamicArray(int size) {
        this.foundation = new String[size > 0 ? size : DEFAULT_SIZE];
        this.occupancy = 0;
    }

    // Constructor that initializes array based on another array, shallow copying it
    public DynamicArray(String[] data) {
        this(data != null ? data.length : DEFAULT_SIZE);
        if (data != null) {
            this.foundation = data;
            this.occupancy = data.length;
        }
    }

    // Default constructor using the default size of 4
    public DynamicArray() {
        this(DEFAULT_SIZE);
    }

    // Checks if the target string exists in the array
    public boolean contains(String target) {
        for (int i = 0; i < this.occupancy; i++) {
            if (target != null && target.equals(this.foundation[i])) return true;
        }
        return false;
    }

    // Retrieves the element at a specified index
    public String get(int index) {
        return (index >= 0 && index < this.foundation.length) ? this.foundation[index] : null;
    }

    // Removes the element at a specified index, shifting subsequent elements left
    public String remove(int index) {
        if (index >= 0 && index < this.occupancy) {
            String removed = this.foundation[index];
            for (int i = index; i < occupancy - 1; i++) {
                this.foundation[i] = this.foundation[i + 1];
            }
            this.foundation[--occupancy] = null;
            return removed;
        }
        return null;
    }

    // Deletes the element at a specified index by using remove
    public void delete(int index) {
        remove(index);
    }

    // Resizes the underlying array by increasing its capacity by 1
    private void resize() {
        String[] temp = new String[this.foundation.length + 1];
        System.arraycopy(this.foundation, 0, temp, 0, this.occupancy);
        this.foundation = temp;
    }

    // Inserts a string into the array and resizes if the array is full
    public void insert(String string) {
        if (string != null && this.occupancy == this.foundation.length) resize();
        this.foundation[this.occupancy++] = string;
    }

    // Creates a string representation of the array
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < this.occupancy; i++) {
            sb.append(this.foundation[i]);
            if (i < this.occupancy - 1) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    // Returns the index of the first occurrence of a string, or -1 if not found
    public int index(String string) {
        for (int i = 0; i < this.occupancy; i++) {
            if (string.equals(this.foundation[i])) return i;
        }
        return -1;
    }

    // Returns the percentage of occupied positions in the array, rounded to 2 decimal places
    public double usage() {
        return Math.round((this.occupancy / (double) this.foundation.length) * 10000) / 100.0;
    }

    // Main method for testing
    public static void main(String[] args) {
        String[] testData = { "Java", "Python", "C", "C++", "Fortran" };
        DynamicArray test = new DynamicArray(testData);
        
        // Test toString(), index(), and usage()
        System.out.println(test.toString());    // Expected: [Java, Python, C, C++, Fortran]
        System.out.println(test.index("C++"));  // Expected: 3
        System.out.println(test.index("COBOL"));// Expected: -1
        System.out.println(test.usage());       // Expected: 100.0
    }
}
