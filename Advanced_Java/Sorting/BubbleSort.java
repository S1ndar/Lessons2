package Sorting;

import java.util.Arrays;
// Не рекомендуется к использованию
public class BubbleSort { // Сортировка пузырьком (наибольший элемент двигается в конец)
// Сравниваются соседние элементы 

	public static void main(String[] args) {
		int[] arr = { 5, 3, 8, 4, 1, 7, 10, 98, 2, 6, 12, 0 };
		bubblesort(arr);
		System.out.println(Arrays.toString(arr));

	}

	// Сортировка пузырьком
	static void bubblesort(int[] arr) {
		int length = arr.length;
		for (int j = 0; j < length - 1; j++) {
			// Одного цикла недостаточно, length-1 потому что мы нашли максимальный элемент
			for (int i = 1; i < length; i++) {
				if (arr[i - 1] > arr[i]) {
					// если arr[i-1] > arr[i], то мы меняем их местами :
					int temp = arr[i - 1];// значение arr[i-1] перезаписалось в temp
					arr[i - 1] = arr[i]; // значение arr[i] перезаписалось в arr[i-1]
					arr[i] = temp; // значение temp перезаписаловь в arr[i]
					// при помощи одного цикла for мы получили [3,5,4,1,8] - мы нашли максимальный элемент
				}
			}

		}

	}

}
