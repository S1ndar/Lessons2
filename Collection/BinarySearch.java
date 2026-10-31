import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch { // Выборка пополам

	public static void main(String[] args) {
	     
		  List<Integer> arl = new ArrayList<Integer>();
	      arl.add(-12);
	      arl.add(777);
	      arl.add(82);
	      arl.add(0);
	      arl.add(-1);
	      arl.add(-566);
	      arl.add(47);
	      arl.add(12);
	      arl.add(2);
	      arl.add(100);
	      
	      Collections.sort(arl); // sort() сортирует по порядку выбранный нами list
	      System.out.println(arl);
	      
	      Collections.reverse(arl); // reverse() переварачивает list
	      System.out.println(arl);
	      
	      Collections.shuffle(arl); // shuffle() перемешивает list
	      System.out.println(arl);
	      
	      // BinarySearch работает быстрее чем обычная выборка
	      int index = Collections.binarySearch(arl, 12); // Выборка пополам (делит list пополам и сравнивает с срединым значением)
	      System.out.println(index);
	      
          	
	      Person p1 = new Person("Tom ",19,4000);
	      Person p2 = new Person("Bob ",22,10000);
	      Person p3 = new Person("John",25,20000);
	      Person p4 = new Person("Zein",29,7000);
	      Person p5 = new Person("Mike",17,5000);
	      Person p6 = new Person("Kai ",20,5000);
	      
	      // Для binarySearch, в качестве элемента должен быть элемент имплементируещий интерфейс Comparable 
	      List<Person> pList = new ArrayList<Person>();
	      pList.add(p1);
	      pList.add(p2);
	      pList.add(p3);
	      pList.add(p4);
	      pList.add(p5);
	      pList.add(p6);
	      System.out.println(pList);
	      Collections.sort(pList);
	      System.out.println(pList);
	      
	      int index2 = Collections.binarySearch(pList, new Person("Kai",20,5000)); // Мы ищем под каким индексом будет наш объект с такими полями
	      System.out.println(index2);
	      
	      
		  // Arrays.sort() -  Сортировка массива
	      int[] arr = {1,2,-9,7,3,85,90};
	      System.out.println(Arrays.toString(arr)); 
	      Arrays.sort(arr);
	      System.out.println(Arrays.toString(arr));
	      int indexArr = Arrays.binarySearch(arr,7);
	      System.out.println(indexArr);
	      
	}

}

class Person implements Comparable<Person>{ // Компаратор
	private String name;
	private int age;
	private int salary;
	public Person(String n, int a,int s) {
		name = n;
		age = a;
		salary = s;
	}
	
	@Override
	public String toString() {
       return "\nPerson( name : "+name+", age : "+age+", salary :"+salary+")";	
	}
	
	@Override
	public int compareTo(Person o) { // Задаем методу sort() по какому порядку сортировать 
	   int result = this.salary - o.salary;
	   if(result == 0) {
		   result = this.age - o.age;
		   if(result == 0) {
			   // compareTo() - сравнение по хэшкоду
			   result = this.name.compareTo(o.name);
		   }
	   }
	   return result;
	}
	
}