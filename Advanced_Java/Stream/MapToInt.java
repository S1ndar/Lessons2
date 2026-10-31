package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Intermediate method
public class MapToInt {

	public static void main(String[] args) {
		
	      Human h1 = new Human(20, "bob",'m');
	      Human h2 = new Human(24, "tom",'m');
	      Human h3 = new Human(33, "rick",'m');
	      Human h4 = new Human(32, "ann",'f');
	      Human h5 = new Human(51, "mike",'m');
         	
	      List<Human> list = new ArrayList<Human>();
	      list.add(h1);
	      list.add(h2);
	      list.add(h3);
	      list.add(h4);
	      list.add(h5);
	        
	      System.out.println(list);
	      
	      // mapToInt() - map, который возвращает intStream - stream из int
	      List<Integer> age = list.stream()
	    		  .mapToInt(e->e.getAge())
	    		  .boxed() // переводит int в Integer
	    		  .collect(Collectors.toList());
	      System.out.println(age);
	      // Методы mapToInt() :
	      
	      // sum() - сумма (возвращает intStream)
	      int sum = list.stream().mapToInt(e->e.getAge()).sum();
	      System.out.println(sum);

	      // average() - среднее арифметоческое (возвращает Stream<double>)
	      double average = list.stream().mapToInt(e->e.getAge()).average().getAsDouble();
	      System.out.println(average);
	      
	      // min() - минимальное значение (возвращает Stream<int>)
	      int min = list.stream().mapToInt(e->e.getAge()).min().getAsInt();
	      System.out.println(min);
	      
	      // min() - минимальное значение (возвращает Stream<int>)
	      int max = list.stream().mapToInt(e->e.getAge()).max().getAsInt();
	      System.out.println(max);
	      
	}

}
