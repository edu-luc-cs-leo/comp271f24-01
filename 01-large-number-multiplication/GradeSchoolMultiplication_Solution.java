import java.util.Arrays; // for toString() only

public class GradeSchoolMultiplication_Solution {

    private static final int DEFAULT_BASE = 10;

    /**
     * Multiplies two integers represented as arrays and returns their product also
     * in the form of an array. Only single-digit multiplications are allowed to be
     * performed with the built-in multiplication operator (*). We are also using
     * single-digit arithmetic for addition, division, and modulo and we are allowed
     * a carry digit.
     * 
     * @param x    one of the two arrays with the interests to multiply
     * @param y    the other array with the integer to multiply
     * @param base the number base of the system (for carry and single digit ops)
     * @return the product of the two numbers in arrays, also in the form of an
     *         array.
     */
    public static int[] multiply(final int[] x, final int[] y, final int base) {
        // Declare the output array
        int[] result;
        // If one of the input arrays has 0 length, prepare to return [0]
        if (x.length == 0 || y.length == 0) {
            result = new int[1];
        } else {
            // Prepare the result array with as many digits as the two input arrays together
            result = new int[x.length + y.length];
            // Set up a two-dimensional array to capture the partials products
            int[][] partial = new int[x.length][x.length + y.length];
            // Variable to shift partial product one position to the left as we make our way
            // through
            int shiftLeft = 0;
            // Declare the loop variables. Usually, we declare them so that they exist only
            // within the for-loop scope. However we want access to, at least j, outside the
            // loop scope, hence the early declaration.
            int i, j;
            // Multiply every digit of one array with every digit of the other array, from
            // back to front.
            for (i = x.length - 1; i >= 0; i--) {
                int carry = 0;
                for (j = y.length - 1; j >= 0; j--) {
                    int product = carry + x[i] * y[j];
                    partial[i][j + y.length - shiftLeft] = product % base;
                    carry = product / base;
                }
                // If there at the end of this round, place it to the front of the corresponding
                // partial product. That's why we need variable j to be available outside the
                // scope of its loop.
                partial[i][j + y.length - shiftLeft] = carry;
                shiftLeft++;
            }
            // Add the partial products into the result array
            int carry = 0;
            for (j = x.length + y.length - 1; j >= 0; j--) {
                int sum = carry;
                for (i = x.length - 1; i >= 0; i--) {
                    sum += partial[i][j];
                }
                result[j] = sum % base;
                carry = sum / base;
            }
            // If result has a leading 0, remove it
            if (result[0] == 0) {
                int[] temp = new int[result.length - 1];
                for (i = 1; i < result.length; i++) {
                    temp[i - 1] = result[i];
                }
                result = temp;
            }
            // Done!
        }
        return result;
    } // method multiply

    public static int[] multiply(final int[] x, final int[] y) {
        return multiply(x, y, DEFAULT_BASE);
    } // method multiply

    public static void main(String[] args) {
        int[] x = { 1, 2, 3, 4 };
        int[] y = { 5, 6, 7, 8 };
        int[] z = multiply(x, y);
        System.out.println(Arrays.toString(z));
    } // method main
} // class GradeSchoolMultiplication_Solution