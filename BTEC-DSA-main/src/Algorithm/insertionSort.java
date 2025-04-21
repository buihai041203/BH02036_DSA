package Algorithm;

import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int[] arr = {5, 3, 8, 4, 2}; // test array giống bubbleSort
        insertionSort(arr);
        System.out.println("Final sorted array: " + Arrays.toString(arr));

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Time: " + estimatedTime + "ms");
    }

    public static void insertionSort(int[] arr) {
        for (int step = 1; step < arr.length; step++) {
            int key = arr[step];
            int j = step - 1;

            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = key;

            System.out.println("Step " + step + ": " + Arrays.toString(arr));
        }
    }
}
