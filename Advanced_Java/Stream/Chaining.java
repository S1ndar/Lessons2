package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chaining {// Использование методов друг за другом в цепочке 
// Пример : s.stream().map(e -> e.length()).collect(Collectors.toList) 
	// stream().map().collect()
    
	/* Как работает Method Chaining
     * 1.Source (Collecton or array)
     * 2.Создаем stream (поток) из source
     * 3.Используем элементы stream в Intermediate methods (lazy)
     * 4.В конечном итоге эти элементы поступают в Terminal method (eager)
     * 5.Eager возвращает stream()
     */
	
    // Intermediate method не работают пока не будет вызван Terminal method 
	// Terminal method завершает работу stream и возвращает void
	
	/* Intermediate methods : sorted(), filter(), map(), distinct(), peek(), flatMap(), limit(), skip(), mapToInt()
	 * 
	 * Terminal methods : ForEach(), reduce(), count(), collect(), findFirst(), min(), max()
     */
	
	public static void main(String[] args) {
           int[] arr = {1,2,3,4,5,6,7,8,9,};
           
           /* Method Chaining 
            * 1.Взять все элементы массива 
            * 2.Отфильтровать по всем нечетным числам
            * 3.Все числа делящиеся на 3 разделить на 3 
            * 4.Вычислить сумму всех чисел подходящих по условиям 2 и 3
            */
           
           int sum =  Arrays.stream(arr).filter((e -> e%2==1)).map(e -> {
               if(e%3==0) {
            	   e=e/3;
               }
               return e;
           }).reduce((a,e)-> a+e).getAsInt();
           
           // getAsInt() - преобразует Optional в int
           System.out.println(sum); 
           // 1,3,5,7,9
           // 1,1,5,7,3
           // sum = 1+1+5+7+3 
           // sum = 17
	
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
	      
	      
	      /* Method chaining
	         Выводит сортированные по возрасту элементы, у которых :
	         1. Имя в CAPS
	         2. Род мужской 
	         3. Возраст больше 30
	      */
	      list.stream().map(e->{
	    	  e.setName(e.getName().toUpperCase());
	    	  return e;
	      }).filter(e->e.getS()=='m').
	         filter(e->e.getAge()>30).
	         sorted((x,y)->x.getAge()-y.getAge()).
	         forEach(e->System.out.println(e));;
	         
	      
	         Stream<Integer> st1 = Stream.of(1,2,3,4,5,6);
	         // filter() не обработается пока не появится Terminal method
	         st1.filter(e-> {
	        	 System.out.println("!!!");
	        	 return e%2==0;
	         }).collect(Collectors.toList());
	
	}      

}

class Human{
	int age;
	String name;
	char s;
	public Human(int a,String n,char ss) {
		age=a;
		name=n;
		s=ss;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setS(char s) {
		this.s = s;
	}
	public char getS() {
		return s;
	}
	@Override
	public String toString() {
        return "Human("+age+", "+name+")";
	}
}