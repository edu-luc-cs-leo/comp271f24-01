import java.util.Random;
import java.util.Arrays;

public class Sorting {

  
    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

 
    static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            sort(arr, 0, arr.length - 1);
        }
    }


    private static void sort(int[] arr, int leftEdge, int rightEdge) {
        if (leftEdge < rightEdge) {
            int middle = leftEdge + (rightEdge - leftEdge) / 2;
            sort(arr, leftEdge, middle);
            sort(arr, middle + 1, rightEdge);
            merge(arr, leftEdge, middle, rightEdge);
        }
    }


    private static void merge(int[] arr, int leftEdge, int middle, int rightEdge) {
        int sizeLeft = middle - leftEdge + 1;
        int sizeRight = rightEdge - middle;

        int[] tempLeft = new int[sizeLeft];
        int[] tempRight = new int[sizeRight];

        for (int i = 0; i < sizeLeft; i++) tempLeft[i] = arr[leftEdge + i];
        for (int j = 0; j < sizeRight; j++) tempRight[j] = arr[middle + 1 + j];

        int i = 0, j = 0, k = leftEdge;
        while (i < sizeLeft && j < sizeRight) {
            if (tempLeft[i] <= tempRight[j]) {
                arr[k++] = tempLeft[i++];
            } else {
                arr[k++] = tempRight[j++];
            }
        }

        while (i < sizeLeft) arr[k++] = tempLeft[i++];
        while (j < sizeRight) arr[k++] = tempRight[j++];
    }

    static int[] randomArray(int size, int minValue, int maxValue) {
        Random rand = new Random();
        int[] randArr = new int[size];
        for (int i = 0; i < randArr.length; i++) {
            randArr[i] = minValue + rand.nextInt(maxValue - minValue + 1);
        }
        return randArr;
    }

   
    static void experiment() {
        System.out.printf("%-10s %-20s %-20s\n", "Array Size", "InsertionSort (ns)", "MergeSort (ns)");

        for (int size = 2; size <= 1024; size *= 2) {
            int[] arr1 = randomArray(size, 0, 1000);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);

            long startTime = System.nanoTime();
            insertionSort(arr1);
            long insertionTime = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            mergeSort(arr2);
            long mergeTime = System.nanoTime() - startTime;

            System.out.printf("%-10d %-20d %-20d\n", size, insertionTime, mergeTime);
        }
    }

    public static void main(String[] args) {
        experiment();
    }
}
