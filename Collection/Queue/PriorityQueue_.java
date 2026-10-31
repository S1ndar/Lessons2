package Collection.Queue;

import java.util.Objects;
import java.util.PriorityQueue;

public class PriorityQueue_ {// Сортированная очередь, в основе которой лежит Comparable или Comparator
// Натуральная сортировка - наибольший авторитет имеет наименьший элемент (сортировка по возрастанию)
// Когда мы вводим элементы, сортировка не работает
// НО когда мы используем элементы, сортировка работает на ура
	public static void main(String[] args) {
		/*
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(1);
		pq.add(2);
		pq.add(3);
		pq.add(4);
		pq.add(5);
        
		System.out.println(pq.peek());
		System.out.println(pq.remove());
		*/
		
		Person p1 = new Person("Bob",20);
		Person p2 = new Person("Ann",30);
		Person p3 = new Person("Kid",40);
		Person p4 = new Person("Mike",50);
		Person p5 = new Person("Tom",10);
		
		PriorityQueue<Person> pq2 = new PriorityQueue<Person>();
		pq2.offer(p1);
		pq2.offer(p2);
		pq2.offer(p3);
		pq2.offer(p4);
		pq2.offer(p5);
		System.out.println(pq2);
		
		Person p6 = new Person("Bob",20);
		System.out.println(p1.equals(p6));

		System.out.println(pq2.poll());
		System.out.println(pq2.poll());
		System.out.println(pq2.poll());
		System.out.println(pq2.poll());
		System.out.println(pq2.poll());
		
	}

}


class Person implements Comparable<Person>{
	private String name;
	private int age;
	public Person(String n,int a) {
		name = n;
		age = a;
	}
	@Override
	public String toString() {
		return "Person ("+name+", "+age+")";
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person p = (Person)o;
		return age == p.age;			
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(age);
	}
	
	public int compareTo(Person o) {
		return this.age - o.age;
	}
	
}