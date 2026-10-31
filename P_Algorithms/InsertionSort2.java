package P_Algorithms;

import java.util.Arrays;

public class InsertionSort2 {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 1};
        insertionSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void insertionSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];

            int sorted = i - 1;

            // Сдвигаем все большие элементы вправо
            while (sorted > -1 && arr[sorted] > key) {
                arr[sorted + 1] = arr[sorted];
                sorted--;
            }

            arr[sorted + 1] = key;
        }
    }
}
