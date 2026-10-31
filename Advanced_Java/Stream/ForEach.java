package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
// Terminal method
public class ForEach {// Для каждого элемента 

	public static void main(String[] args) {
		/*
		Student s1 = new Student("Bob",20,3,4.4); 
		Student s2 = new Student("Tom",22,5,3.4); 
		Student s3 = new Student("Ann",25,8,5.0); 
		Student s4 = new Student("Rick",18,2,5.0); 
		Student s5 = new Student("Wick",31,14,4.9); 
		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		System.out.println(list);
		
		List<Student> l = list.stream().forEach(e-> 
		    
		);
       */
       
		
		
		int[] arr = {1,2,3,4,5};
		
		// forEach() - не надо преобразовывать в array, работает также как и foreach
		Arrays.stream(arr).forEach(e -> {
			e*= 2;
			System.out.println(e);
		});
		
		// Супер короткая запись Lambda expression (метод референс - ссылка на метод)
		Arrays.stream(arr).forEach(System.out::println); 
		                     // class Utilss :: myMethod() 
		Arrays.stream(arr).forEach(Utilss::myMethod);
		// Каждый элемент массива arr поместить в метод myMethod(), который находится в классе Utilss
	}

}

class Utilss{
	public static void myMethod(int a) {
		a=a+5;
		System.out.println("Element = "+a);
	}
}