package List;

import java.util.LinkedList;

public class LinkedList_List {

	public static void main(String[] args) {
		Human st1 = new Human("Bob", 23);
		Human st2 = new Human("Tom", 27);
		Human st3 = new Human("John", 19);
		
		// LinkedList - знает длину массива, первый и последний элемент (Но не знает индекса каждого элемента)
		LinkedList<Human> lnl = new LinkedList<>(); // В основе LinkedList лежит цепочка, а не массив (то есть все звенья связаны, ссылкой на соседние элементы)
		lnl.add(st1);
		lnl.add(st2);
		lnl.add(st3);
		System.out.println(lnl);
		System.out.println(lnl.get(2));
		// Преимущество LinkedList перед ArrayList : при добавлении или удалении элементов затрагиваются только 2 соседних элемента 
		// То есть проводится меньше операций 
		// Сходства с ArrayList : LinkedList также имеет все методы интерфейса List
		
		Human st4= new Human("Mike", 31);
		Human st5 = new Human("Kevin", 16);
		lnl.add(st5);
		System.out.println(lnl);
		lnl.add(0,st4);
		System.out.println(lnl);
		lnl.remove(2);
		System.out.println(lnl);
		/* Виды LinkedList :
		 * Doubly - когда у элементов есть ссылки на предыдущий и на следующий элемент (базовый LinkedList)
		 * st1 <-> st2 <-> st3
		 * 
		 * Singly - когда у элементов есть ссылка только на следующий элемент
		 * st1 -> st2 -> st3 
		 */
		
	}

}

class Human{
	private String name;
	private int age;
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student("+name+" "+age+")";
	}
}
