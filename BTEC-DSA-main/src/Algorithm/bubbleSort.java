package Algorithm;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int[] arr = {5, 3, 8, 4, 2}; // test array giống insertionSort
        bubbleSort(arr);
        System.out.println("Final sorted array: " + Arrays.toString(arr));

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Time: " + estimatedTime + "ms");
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
            System.out.println("Step " + (i + 1) + ": " + Arrays.toString(arr));
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
