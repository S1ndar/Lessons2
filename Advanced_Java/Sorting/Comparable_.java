package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// Сортировка при помощи метода Comparable 
public class Comparable_ {
// Интерфейс Comparable используется для сравнения объектов, используя естественный порядок 
// Естественный порядок - когда мы сравниваем this.object и o.object (объект который находится в параметрах) 

// Минусы :
//	1.Сортировать можно только 1 раз 
//  2.Нельзя как-то изменить логику сортировки ( Всегда от меньшего к большему)

	public static void main(String[] args) {
	   /*
	   List<String> list = new ArrayList<String>();
	   list.add("Tom");
	   list.add("Bob");
	   list.add("Ann");
	   
	   // Перед сортировкой 
	   System.out.println(list);
        	   
	   Collections.sort(list); // Естественная сортировка (для String - лексиграфическая сортировка)
	   
	   // После сортировки 
	   System.out.println(list);
	   */   
	    Employee e1 = new Employee(1199, "Bob", 2500);
	    Employee e2 = new Employee(67, "Ann", 3100);
	    Employee e3 = new Employee(523, "Rick", 6000);
	    Employee e4 = new Employee(236, "Rick", 6000);
	    		
		List<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
 		list.add(e3);
        list.add(e4);	    
		
		System.out.println("\nBefore sorting "+list);
		// Java не понимает по какому принципу сортировать (так как в Employee куча переменных)
		// Нам нужно переназначить метод compareTo()
		Collections.sort(list);
		System.out.println("\nAfter sorting "+list);
		
		
		
		
    }             	
}

class Employee implements Comparable<Employee>{
	private int id;
	private String name;
	private int salary;
	public Employee(int i, String n,int s) {
	    id=i;
		name=n;
	    salary=s;
	}
	
	@Override
	public String toString() {
       return "Employee ("+id+", "+name+", "+salary+")";
    }
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
	// compareTo() - сравнивает данные текущего объекта и объекта в параметрах
	public int compareTo(Employee o) {
		/*
		if(this.id==o.id) {
			return 0;
		}
		else if(this.id<o.id) {
			return -1;
		}
		else {
			return 1;
		}
		*/
		
		// Самый лучший способ реализации метода compareTo()
		//return this.id-o.id;
		
		// Этот способ работает только с классами имплементирующие интерфейс Comparable
		int res = this.name.compareTo(o.name);
		if(res == 0) {
			res = this.id-o.id;
		}
		return res;
	    
	}
}
