package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
// Terminal method
public class Reduce { // Уменьшить
// Когда применяем этот метод в Stream, то получаем на выходе всегда один элемент
// Удоюно выполнять методы класса Math

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		
		// Первый вариант записи метода reduce() (без начального значения accumulator)
 		int result = l.stream().reduce((accumulator,element) -> 
            accumulator*element).get(); // get() здесь нужен, чтобы получить из Optional значение
 		// Optional - контейнер для значения (может содержать null или not null значение, лучше проверять при помощи метода isPresent())
 	    System.out.println(result);
 		// 1, 2, 3, 4, 5
 		// accumulator = 1  2  6  24  120 
 		// element     = 2  3  4  5
 		// accumulator - это то, что что-то накапливает, то же самое, что и 
 		/* int sum = 0;
 		 * for(int x : numbers){
 		 *    sum+=x;
 		 * } 
 		 */       
 	    
 	    // Второй вариант записи метода reduce() (с начальным значением accumulator)
 		int result2 = l.stream().reduce(10,(accumulator,e) ->
 		accumulator*e); // Когда дано начальное значение accumulator, то метод get() нам уже не нужен, потому что null значения уже не будет
 		System.out.println(result2);
 		// 1, 2, 3, 4, 5
 		// accumulator = 10  10  20  60  240  1200       
 		// element     = 1   2   3   4   5    
 		
 		List<Integer> l2 = new ArrayList<Integer>();
 		Optional<Integer> op = l2.stream().reduce((accumulator,e) ->
 		accumulator+e);
 		if(op.isPresent()) { // isPresent() - присутствует ли какое-либо значение, очень полезный метод для дебага
 			System.out.println(op.get());
 		}
 		else {
 			System.out.println("Not present");
 		}
 		
 		List<String> l3 = new ArrayList<String>();
 	    l3.add("hello");
        l3.add("wassup");
        l3.add("niga");
        l3.add("yep");
        l3.add("bye");
 		
        String result3 = l3.stream().reduce((a,e)-> // Объединил все значения l3 типа String в одно значение типа String и 
        a+" "+e).get();                             // Затем с помощью Lambda Expression разделил это значение на пробелы  
        System.out.println(result3);

 		
 		

	}

}
