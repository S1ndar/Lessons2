package sixseven;

import java.util.Arrays;
// Используем когда важно меньшее количество сравнений
public class InsertionSort { // Сортировка вставками

	public static void main(String[] args) {
		int[] arr = { 5, 3, 8, 4, 1};
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	static void insertionSort(int[] arr) {
		// Так как первый элемент уже отсортирован, то мы начинаем перебирать массив со второго элемента 
		for (int i = 1; i < arr.length; i++) {
			int sorted = i-1; // Допустим что первый элемент уже отсортирован
			

			while(sorted > -1 && arr[sorted] > arr[sorted + 1]) {
				int temp = arr[sorted];
				arr[sorted] = arr[sorted+1];
				arr[sorted+1] = temp;
				sorted--;
			}
			/* Это работает так :
			 * 5, 3, 8, 4, 1
			 * 5| 3, 8, 4, 1
			 * 3, 5| 8, 4, 1
			 * 3, 5, 8| 4, 1
			 * 3, 5, 4, 8| 1
			 * 3, 4, 5, 8| 1
			 * 3, 4, 5, 1, 8|
			 * 1, 3, 4, 5, 8
			 * 
			 */
		}
	}

}
