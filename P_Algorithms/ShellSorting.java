package P_Algorithms;

import java.util.Arrays;
/*
 Сортировка Шелла - "улучшенная" сортировка вставками, где сравниваются не только соседние элементы,
  но и соседи соседей и так до n/2
 gap - шаг между сравниваемыми элементов (сначало берем n/2 а потом постепенно уменьшаем)

 */

public class ShellSorting {
    static void main() {
        int[] arr = {1,5,45,9,4,2,3};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void shellSort(int[] array) {
        int n = array.length;
        int gap = n / 2;
        while (gap > 0) {
            // Проход по массиву слева направо (gap нельзя сравнивать с элементами слева, потому что их нет)
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j = i; // Указатель, который двигается по массиву влево с шагом gap

                while (j >= gap && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }

                array[j] = temp;
            }
            gap /= 2;
        }
    }
}
