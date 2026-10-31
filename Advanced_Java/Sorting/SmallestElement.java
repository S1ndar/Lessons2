package Sorting;

public class SmallestElement {
    
	// Находит самый минимальный элемент массива
	static int smallElement(int[] arr) {
		int smallest = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] < smallest) {
				smallest = arr[i];
			}
		}
		return smallest;
	}
	
	
	public static void main(String[] args) {
         int[] arr = {9,8,7,6,5,3,1,0};
         System.out.println(smallElement(arr));
		
	}

}
