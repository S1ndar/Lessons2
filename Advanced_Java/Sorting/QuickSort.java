package Sorting;

import java.util.Arrays;
// Лучшая сортировка потому что :
// 1. Средний случай встречается гораздо реже худшего 
// 2. Скорость O(n * log(n))
public class QuickSort {
	
	// Определяют опорный элемент, ставят один элемент на свое место
	static int partition(int[] arr, int low, int high) {
		/* This function takes last element as pivot,
    places the pivot element at its correct
    position in sorted array, and places all
    smaller (smaller than pivot) to left of
    pivot and all greater elements to right
    of pivot */
		// pivot - опорный элемент 
		int pivot = arr[high]; // Самый последний элемент
		
		// index of smaller element
        int lowest = (low-1); 
        
        // Проходимся по всем элементам начиная с элемента с индексом -1
        for (int j=low; j<high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                lowest++;// Меняем индекс если число стоит на своем месте
                
                // Меняем самое минимальное число 
                // swap arr[lowest] and arr[j]
                int temp = arr[lowest];
                arr[lowest] = arr[j];
                arr[j] = temp;
            }
        }
 
        // swap arr[lowest+1] and arr[high] (or pivot)
        int temp = arr[lowest+1]; // +1 , Потому что тут возможен элемент с индексом 0 
        arr[lowest+1] = arr[high]; 
        arr[high] = temp;
 
        return lowest+1; // Возвращает индекс отсортированного числа 
    }
	
	// Сортировка по partition (по опорному элементу)
	static int[] qsort(int arr[], int low, int high)
    {    
		// Проверяем чтобы массив не состоял только из 1 элемента, иначе возвращаем arr
        if (low < high)
        {   
        	// pi - единственный отсортированный элемент - опорный элемент 
            // pi is partitioning index, arr[pi] is now at right place */
            int pi = partition(arr, low, high);
 
            // Recursively sort elements before
            // partition and after partition
            qsort(arr, low, pi-1); // -1 чтобы не считать pi дважды
            qsort(arr, pi+1, high); // +1 чтобы не считать pi дважды 
        }
        return arr;
    }
	
	public static void main(String[] args) {
        int[] arr = {32,1,23,4,5,2,11,0};
        int n = arr.length - 1; // -1 потому что массив начинается с 0 
        System.out.println(partition(arr, 0, n));
		System.out.println(Arrays.toString(qsort(arr,0,n)));
	}
	

}
