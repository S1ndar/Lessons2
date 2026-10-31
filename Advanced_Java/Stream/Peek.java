package Stream;

import java.util.stream.Stream;

// Intermediate method
public class Peek {// Похож на forEach, НО возвращает String
// Нужен чтобы посмотреть как проходит по этапно метод chaining
// Очень нужный метод
	public static void main(String[] args) {
		 Stream<Integer> st1 = Stream.of(1,2,3,1,2,3,1,2,4);
         System.out.println(st1.distinct().peek(System.out::println).count());	
         // peek() вывел все элементы
         
	}

}
