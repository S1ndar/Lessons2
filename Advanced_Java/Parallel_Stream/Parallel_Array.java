package Parallel_Stream;

import java.util.Arrays;

public class Parallel_Array {

	public static void main(String[] args) {
          int[] arr = initializeArray(10);
          for (int i : arr) {
			System.out.println(i);
		  }
          
          
	}
	public static int[] initializeArray(int size) {
		int[] values = new int[size];
		Arrays.parallelSetAll(values, i -> i*10);
        return values;
	}

}
