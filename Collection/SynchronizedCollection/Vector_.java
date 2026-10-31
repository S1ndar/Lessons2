package SynchronizedCollection;

import java.util.Vector;

public class Vector_ { // В отличие от ArrayList и LinkedList работает многопоточно (устаревший класс)

	public static void main(String[] args) {
	    Vector<String> v = new Vector();
		v.add("Mike");
		v.add("Bob");
		v.add("Tom");
		System.out.println(v);
		System.out.println(v.firstElement()); // firstElement выводит первый элемент
		System.out.println(v.lastElement()); // lastElement выводит последний элемент
		v.remove(2);
		System.out.println(v);
		System.out.println(v.get(1));

	}

}
