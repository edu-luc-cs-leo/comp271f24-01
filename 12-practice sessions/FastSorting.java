import java.util.Arrays;
import java.util.Random;

public class FastSorting {

    /**
     * Linear-time sorting of an int array, using a lookup table. Performance is
     * 2n+W where n is the size of the input array and W is the dynamic range of
     * values in the array defined as
     * 
     * range = max(array) - min(0, min(array))
     * 
     * In theory, this method performs in O(n), faster than mergesort and other
     * techinques that deliver in O(nlogn) time. However, the dynamic range is a
     * significant factor. A large dynamic range will require substantial memory
     * allocation. Furthermore, this method is faster only when
     * 
     * 2n + range < nlogn
     * 
     * For range greater than nlogn-2n, mergesort will perform faster and with
     * negligible memory requirements.
     */
    static int[] linearSort(int[] array) {
        // Guard statements for trivial cases
        final int TRIVIAL_SIZE_BOUNDARY = 2;
        // If array is smaller than the trivial size, it's already sorted
        if (array.length < TRIVIAL_SIZE_BOUNDARY) {
            return array;
        }
        // If array has two elements, it may only require their swapping
        // to be sorted
        if (array.length == TRIVIAL_SIZE_BOUNDARY) {
            if (array[0] > array[1]) {
                int temp = array[0];
                array[0] = array[1];
                array[1] = temp;
            }
            return array;
        }
        // Not trivial cases ... find array's min and max values first
        int smallest = 0; // Start with 0, change only if neg value
        int largest = array[0];
        for (int value : array) {
            if (value < smallest) {
                smallest = value;
            }
            if (value > largest) {
                largest = value;
            }
        }
        // Range of arrays values
        int range = largest - smallest;
        // Prepare the presence array
        int[] present = new int[range + 1];
        // Use the values of the input array as index for the presence
        // array to record the occurence of a value and its frequency
        for (int value : array) {
            present[value - smallest]++;
        }
        // Prepare and populate the sorted array
        int[] sorted = new int[array.length];
        // Index for output array
        int k = 0;
        for (int i = 0; i < present.length; i++) {
            for (int j = 0; j < present[i]; j++) {
                sorted[k++] = i + smallest;
            }
        }
        return sorted;
    } // method linearSort

    /**
     * Performance measurement between linearSort and Arrays.sort
     */
    public static void measure() {
        // Constants
        final int SIZE = 1024; // input array size
        final int FROMTO = 500; // +/- range of array values
        final int REPEAT = 500; // average results after so mary tries
        // Initialize test array, random number generator, and timing variables
        int[] testArray = new int[SIZE];
        Random rand = new Random();
        long startTime, linearTime = 0, mergeTime = 0;
        // Repeat the experiment
        for (int trial = 0; trial < REPEAT; trial++) {
            // Populate test array
            for (int i = 0; i < testArray.length; i++) {
                testArray[i] = -FROMTO + 2 * rand.nextInt(FROMTO);
            }
            // Measure linearSort time
            startTime = System.nanoTime();
            linearSort(testArray);
            linearTime += System.nanoTime() - startTime;
            // Measure Arrays.sort
            startTime = System.nanoTime();
            Arrays.sort(testArray);
            mergeTime += System.nanoTime() - startTime;
        }
        // Report results
        System.out.printf("\n\nPerformed %d tests on an array with %,d elements.", REPEAT, SIZE);
        System.out.printf("\nThe range of values is from %,d to %,d.", -FROMTO, FROMTO);
        
        System.out.printf("\n\nLinear sort took %,13d nsec", linearTime / REPEAT);
        System.out.printf("\n Merge sort took %,13d nsec\n\n", mergeTime / REPEAT);     
    } // method measure

    public static void main(String[] args) {
        int[] positiveOnly = { 14, 12, 10, 8, 6, 4, 2, 1 };
        int[] anyValue = { -13, 11, 12, 13, -2, -4, 5, 6 };
        int[] repeats = { -11, 1, -11, 48, 5, 4, 700, -11 };
        System.out.println(Arrays.toString(linearSort(positiveOnly)));
        System.out.println(Arrays.toString(linearSort(anyValue)));
        System.out.println(Arrays.toString(linearSort(repeats)));
        measure();
    } // method main
} // class FastSorting