
public class DemoSorting {

    // Default largest array size
    private static final int DEFAULT_UPTO = 64 * 64;
    // Default max value for random number range
    private static final int DEFAULT_MAX_VALUE = 1024;
    // Default min value for random number range
    private static final int DEFAULT_MIN_VALUE = 1;
    // Default repetitions for each experiment to smooth data
    private static final int SMOOTH_FACTOR = 30;
    // Default format for integer values
    private static final String FMT_INT = "%5d";
    // Default format for double values
    private static final String FMT_DBL = "%15.5f";
    // Constant for initial array size and growth factor
    private static final int SIZE = 2;

    /**
     * Default call to method that runs the experiments
     */
    static void runExperiments() {
        runExperiments(DEFAULT_UPTO,
                DEFAULT_MIN_VALUE,
                DEFAULT_MAX_VALUE,
                SMOOTH_FACTOR);
    } // method runExperiments

    /**
     * Measure the time it takes to sort an array using inserting and merge sort.
     * 
     * The method measures the time it takes to sort an array of a given size, for
     * multiple sizes. The same random array is used to test insertion and merge
     * sorts. For each array size, the method conducts multiple trials to average
     * the sorting time.
     * 
     * @param upTo         Maximum size of array to test. Method starts with an
     *                     array of size 2 and progresses to the maximum size
     *                     doubling the size. Effectively, this produces an
     *                     exponential sample space.
     * @param minValue     The minimum random integer in the test array
     * @param maxValue     The maximum random integer in the test array
     * @param smoothFactor How many times to repeat the experiment for a given array
     *                     size, to obtain a smooth average
     */
    static void runExperiments(int upTo, int minValue, int maxValue, int smoothFactor) {
        // Timining variables
        long startTime, endTime, duration, sumInsertion, sumMerge;
        // Test arrays
        int[] testInsertion, testMerge;
        // Reported average time
        double averageInsertion, averageMerge;
        // Principal loop: determines the size of the array to test
        for (int n = SIZE; n <= upTo; n *= SIZE) {
            // Cumulator for averaging execution time
            sumInsertion = 0L;
            sumMerge = 0L;
            // Secondary loop: repeat measurements for this size array to obtain smooth
            // averages
            for (int experiment = 0; experiment < smoothFactor; experiment++) {
                // Obtain a test array for insertion sort
                testInsertion = Sorting.randomArray(n, minValue, maxValue);
                // Deep copy the test array to use in merge sort -- same as Arrays.copyOf
                testMerge = new int[n];
                for (int i = 0; i < n; i++) {
                    testMerge[i] = testInsertion[i];
                }
                // Start the clock for insertion sort
                startTime = System.nanoTime();
                // Execute teh sort
                Sorting.insertionSort(testInsertion);
                // Stop the clock
                endTime = System.nanoTime();
                // How long did it take?
                duration = endTime - startTime;
                // Update the cumulative sum for insertion sort
                sumInsertion += duration;
                // Start the clock for merge sort
                startTime = System.nanoTime();
                // Execute the merge sort
                Sorting.mergeSort(testMerge);
                // Stop the clock
                endTime = System.nanoTime();
                // How long did it take?
                duration = endTime - startTime;
                // Update the cumulative sum for merge sort
                sumMerge += duration;
            } // end-of averaging loop
              // Compute and report averages
            averageInsertion = sumInsertion / (double) smoothFactor;
            averageMerge = sumMerge / (double) smoothFactor;
            System.out.printf("\n" + FMT_INT + " " + FMT_DBL, n, averageInsertion);
            System.out.printf(" " + FMT_DBL, averageMerge);
        } // end of principal loop
    } // method runExperiments

    public static void main(String[] args) {
        runExperiments(10000, 10, 10000, 500);
    } // method main
} // class DemoSorting
