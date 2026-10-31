package Sorting;

import java.util.Arrays;
// Используем когда важно меньшее количество перестановок
public class SelectionSort { // Сортировка выбором ( наименьший элемент двигается в начало)
// Сравниваются соседние элементы
	
	public static void main(String[] args) {
		int[] arr = { 5, 3, 8, 4, 1};
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	static void selectionSort(int[] arr) {
		// Первым циклом мы запоминаем самый первый элемент массив - minIndex
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i; // Самый первый элемент (5)
			
			// Вторым циклом мы проходим по всем оставшимся элементам, но уже с новым minIndex, который мы переопределили на следующее число 
			for (int j = i+1; j < arr.length; j++) {
				if(arr[minIndex]>arr[j]) {
				  // Если следующий элемент(3) меньше (5) 
			      // То мы меняем самый минимальный элемент на (3) и продолжаем цикл
					minIndex=j;
				}
			}
			
			if(minIndex != i) { // Меняем самый минимальный элемент на следующий и оставляем в покое первый элемент (минимальный)
				// если arr[minIndex] != arr[i], то мы меняем их местами :
				int temp = arr[minIndex];// значение arr[minIndex] перезаписалось в temp
				arr[minIndex] = arr[i]; // значение arr[i] перезаписалось в arr[minIndex]
				arr[i] = temp; // значение temp перезаписаловь в arr[i]
			}
			/* Это работает так :
			 * 5, 3, 8, 4, 1
			 * 1, 3, 8, 4, 5
			 *(1) 3, 8, 4, 5
			 *(1, 3) 8, 4, 5
			 *(1, 3) 4, 8, 5
			 *(1, 3, 4) 8, 5
			 *(1, 3, 4, 5) 8
			 */
			
			
		}
	}

}
