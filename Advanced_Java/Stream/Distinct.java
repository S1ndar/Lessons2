package Stream;

import java.util.stream.Stream;
// Intermediate method
public class Distinct { // Возвращает stream уникальных элементов 
// Проверяет их при помощи метода equals()
	
	
	public static void main(String[] args) {
		 Stream<Integer> st1 = Stream.of(1,2,3,1,2,3);
         st1.distinct().forEach(System.out::print);// Выводит тольно уникальные элементы 	        
	}

}
