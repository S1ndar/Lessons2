package Stream;

import java.util.stream.Stream;

public class Count {// Считает количество элементов в stream, возвращает long
// Terminal method
	public static void main(String[] args) {
		 Stream<Integer> st1 = Stream.of(1,2,3);
	     // System.out.println(st1.count());
	     
	     // После использования stream, его нельзя использовать повторно (stream нельзя переиспользовать)
	     System.out.println(st1.distinct().count());
	}

}
