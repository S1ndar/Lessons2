package List;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArrayListMethods1 {

	public static void main(String[] args) {
		
	    List<String> arl1 = new ArrayList();
		arl1.add("Tom");     // 0
		arl1.add("Bob");     // 1
		arl1.add("John");    // 2
		arl1.add("Misha");   // 3
		//foreach
		for (String s1 : arl1) { 
			System.out.print(s1+" ");
		}
		//for, с помощью метода get(), выводит все элементы массива по индесу
		for (int i = 0; i < arl1.size(); i++) {
			System.out.println(arl1.get(i));
		}
		System.out.println(arl1.get(2)); // С помощью get() мы можем по индексу вывести определенный элемент массива
		
		
		List<String> arl2 = new ArrayList(3);
		arl2.add("Tom");     // 1
		arl2.add("Bob");     // 2
		arl2.add("John");    // 3
		arl2.add(0,"Misha"); // 0
		for (String s2 : arl2) {
			System.out.print(s2+" ");
		}
		
		List<String> arl3 = new ArrayList();
	    arl3.add("Hello");
	    arl3.add("World");
	    arl3.set(0,"Bye"); // Меняет элемент, выбранный нами по индексу 
	    arl3.remove("Bye");// Удаление по инициализации
	    arl3.remove(0);    // Удаление по индексу 
	    System.out.println(arl3);
	    
	    Student st1 = new Student("Tom", 20, 2);
	    Student st2 = new Student("Bob", 21, 3);
	    Student st3 = new Student("Tom", 20, 2);
	  
	    List<Student> stList = new ArrayList();
	    stList.add(st1);
	    stList.add(st2);
	  
	    stList.remove(st3); // st1 и st3 были удалены, так как мы за оверрайдили метод Equals, st3 == st1 (они ссылаются на одну и ту же ячейку в памяти)
	    System.out.println(stList); 
	    int index = stList.indexOf(st1); // Выводит индекс выбранного объекта либо же если индекса не будет, то выведет -1 (работает с методом equals)
	    System.out.println(index);
	}

}

class Student{
    private String name;
    private int age;
    private int course;
    public Student(String name, int age, int course) {
    	this.name = name;
    	this.age = age;
    	this.course = course;
    }
    @Override
    public String toString() {
    	return "\nStudent 1 - name "+name+", age "+age+", course "+course;
	
    }
   @Override
   public boolean equals(Object obj) {  // Мы переопределили метод equals (теперь он сравнивает ссылки)
	 if (this == obj) return true;
	 if (obj == null || getClass() != obj.getClass()) return false;
	 Student s = (Student) obj;
	 return name == s.name && 
			age == s.age  &&
			course == s.course &&
		 Objects.equals(name, s.name);
	 
   }
}
