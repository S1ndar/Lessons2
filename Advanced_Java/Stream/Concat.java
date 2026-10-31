package Stream;

import java.util.stream.Stream;

public class Concat {// Делает конкатенацию - сложение двух потоков 
// concat() - статический метод, НО он не может использоваться в Chaining methods (он не terminal, но и не возвращает stream)
	public static void main(String[] args) {
        Stream<Integer> st1 = Stream.of(1,2,3);
        Stream<Integer> st2 = Stream.of(4,5,6);
        
        
        // concat() 
        Stream<Integer> st3 = Stream.concat(st1,st2);
        st3.forEach(System.out::print);
        
         
	}

}
