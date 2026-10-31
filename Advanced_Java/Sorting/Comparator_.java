package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparator_ { // Интерефейс похожий на Comparable, 
// но в отличие от Comparable можно сколько угодно переопределять метод compare() 
// И сортировать сколько угодно 
// Использует НЕестественный порядок (сортировка между объектами в параметрах)
	
// Используем : 
// 1.Когда нам нужно несколько сортировок по разным параметрам
// 2.Когда нам нужно изменить логику сортировки ( Мы пишем свой Comparator ) 
	
	public static void main(String[] args) {
		  
		Employe e1 = new Employe(1199, "Bob", 2500);
		Employe e2 = new Employe(6710, "Ann", 3100);
		Employe e3 = new Employe(523, "Rick", 6000);
		Employe e4 = new Employe(236, "Mike", 6306);
		Employe e5 = new Employe(22, "Hugo", 16000);
		Employe e6 = new Employe(2236, "Mark", 1200);
		Employe e7 = new Employe(236, "Sherlock", 60200);
		Employe e8 = new Employe(236, "Lila", 6000);

		List<Employe> list = new ArrayList<Employe>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		list.add(e7);
		list.add(e8);

		System.out.println("\nBefore sorting " + list);
	    // sort(list, Comparator());
		Collections.sort(list, new IdComparator());	// После переопределения метода compare() сортировка будет происходить по id 
		System.out.println("\nAfter sorting Id" + list);
		Collections.sort(list, new NameComparator());
		System.out.println("\nAfter sorting Name" + list);
		Collections.sort(list, new SalaryComparator());
		System.out.println("\nAfter sorting Salary" + list);
        
	}
}

// Класс comparator 
class IdComparator implements Comparator<Employe>{

	// compare() - такой же по логике как и compareTo(), но сравнивает данные объектов в параметрах
	public int compare(Employe o1, Employe o2) { 
		return o1.getId()-o2.getId();
	}
}

class NameComparator implements Comparator<Employe>{

	@Override
	public int compare(Employe o1, Employe o2) {
        return o1.getName().compareTo(o2.getName());
	}
	
}

class SalaryComparator implements Comparator<Employe>{

	@Override
	public int compare(Employe o1, Employe o2) {
		return o1.getSalary()-o2.getSalary();
	}
	 
}

class Employe{
	private int id;
	private String name;
	private int salary;

	public Employe(int i, String n, int s) {
		id = i;
		name = n;
		salary = s;
	}

	@Override
	public String toString() {
		return "\nEmployee (" + id + ", " + name + ", " + salary + ")";
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getSalary() {
		return salary;
	}
	 

}
