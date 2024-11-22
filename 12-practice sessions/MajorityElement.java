import java.util.Arrays;

/*
  Offers two ways to determine the majority element in an int[]. 
  The input array is guaranteed to have a majority element
*/
public class MajorityElement {

    /**
     * An instance of the majority element will always occupy the middle element of
     * a sorted array.
     */
    public static int majorityElementBySorting(int[] array) {
        Arrays.sort(array);
        return array[array.length / 2];
    } // method majorityElementBySorting

    /**
     * Start with an arbritrary number as a candidate for the majority element; then
     * traverse the array incrementing a counter when an element matches the
     * candidate and decreasing when an element does not match the candidate. Every
     * time the counter is 0, update the candidate to the current element. The
     * majority element will be the last value of the candidate after the loop.
     */
    public static int majorityElementByCounting(int[] array) {
        // This is basically a timing signal telling us that the current element of the
        // array is a candidate majority element.
        int counter = 0;
        // Arbitrary value for candidate
        int candidate = array[0];
        // Traverse the array
        for (int i = 0; i < array.length; i++) {
            // When counter is 0, current element becomes candidate
            if (counter == 0) {
                candidate = array[i];
            }
            // If current element matches candidate increase counter, otherwise descrease.
            // As minority elements are encountered, counter will return to 0, enabling
            // another element to become candidate.
            if (candidate == array[i]) {
                counter++;
            } else {
                counter--;
            }
        }
        // Done!
        return candidate;
    } // method majorityElementByCounting

    /** Driver code */
    public static void main(String[] args) {
        int[] test = { 1, 2, 3, 2, 4, 2, 5, 2, 6, 2, 2 };
        System.out.println(majorityElementByCounting(test));
        System.out.println(majorityElementBySorting(test));
    } // method main
}
