import java.util.Arrays;

public class EasyMultiplications {

    public static final int DEFAULT_BASE = 10;

    /**
     * Converts an array of single digits into a scalar value for a given number
     * system base. The method expects that the input array contains only single
     * digits and that each digit is < base. No guard statement is in place for this
     * expectation.
     * 
     * @param array input array with single digit elements
     * @param base  number system base
     * @return a scalar value for the digits represented in the array; e.g. the
     *         array [4,0,7,7] will be converted to the scalar 4077.
     */
    public static int convertToScalar(int[] array, int base) {
        int scalar = 0;
        int power = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            scalar += array[i] * power;
            power *= base;
        }
        return scalar;
    } // method convertToScalar

    /** Helper convertToScalar for default number base */
    public static int convertToScalar(int[] array) {
        return convertToScalar(array, DEFAULT_BASE);
    } // overloaded convertToScalar

    /**
     * Converts a scalar value to an array of single digits.
     * 
     * @param scalar input value to be converted to array
     * @param base   number system base to use
     * @return an array with the input value's single digits; e.g., the scalar 4077
     *         will be converted to array [4,0,7,7]
     */
    public static int[] convertToArray(final int scalar, int base) {
        int[] array = new int[1 + (int) Math.log10(scalar)];
        int temp = scalar;
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = temp % base;
            temp /= base;
        }
        return array;
    } // method convertToArray

    /** Helper convertToArray for default number base */
    public static int[] convertToArray(final int scalar) {
        return convertToArray(scalar, DEFAULT_BASE);
    } // overloaded convertToArray

    public static void main(String[] args) {
        int[] x = { 1, 2, 3, 4 };
        int[] y = { 5, 6, 7, 8 };
        int xScalar = convertToScalar(x);
        int yScalar = convertToScalar(y);
        int product = xScalar * yScalar;
        int[] result = convertToArray(product);
        System.out.println(Arrays.toString(result));
    }

} // class EasyMultiplications