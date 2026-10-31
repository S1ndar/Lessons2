package Set;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class TreeSet_ { // Все точно также как и у HashSet, в основе TreeSet лежит TreeMap (ключи - элементы, значения - константы-заглушки) 
// Также, как и TreeMap хранит элементы в отсортированном по возрастанию порядке (КРАСНО-ЧЕРНОЕ ДЕРЕВО)  и не хранит null
	public static void main(String[] args) {
		Set<Integer> ts = new TreeSet<>();
		ts.add(5);
		ts.add(4);
		ts.add(1);
		ts.add(8);
		ts.add(7);
		
		System.out.println(ts);
		
		ts.remove(2);
		System.out.println(ts);
		
		System.out.println(ts.contains(2));
		
		Human h1 = new Human("Bob", 20);
		Human h2 = new Human("Ann", 25);
		Human h3 = new Human("Tom", 20);
		Human h4 = new Human("Felix", 48);
		Human h5 = new Human("Julio", 30);
		
		TreeSet<Human> ts2 = new TreeSet<>();
	    ts2.add(h1);	
	    ts2.add(h2);	
	    ts2.add(h3);	
	    ts2.add(h4);	
	    ts2.add(h5);
	    
	    System.out.println(ts2);
	    
	    System.out.println(ts2.first()); // Самый первый (младший по age)
	    
	    System.out.println(ts2.last());  // Самый последний (взрослый по age)
	    
	    Human h6 = new Human("Kevin", 30);
	    Human h7 = new Human("Kevin", 10);
	    
	    // headSet()
	    System.out.println(ts2.headSet(h6)); // Все, кто ниже h6.age ( h6.age > ts2.headSet(h6))
	    
	    // tailSet() 
	    System.out.println(ts2.tailSet(h6)); // Все, кто выше h6.age ( h6.age <= ts2.tailSet(h6))
	    
	    // subSet()
	    System.out.println(ts2.subSet(h7, h6)); // Все, кто входит в промежуток между h6.age и h7.age
	    
	    System.out.println(h1.equals(h3));
	    System.out.println(h1.hashCode() == h3.hashCode()); // В обеих случаях выведет true 
	    
	    
	}

}


class Human implements Comparable<Human>{
	private String name;
	private int age;
	public Human(String n, int a ) {
		name = n;
		age = a;
	}
	@Override
	public int compareTo(Human o) { // сортируем Human по age
		return this.age - o.age; // Не надо переопределять методы equals() и hashcode(), потому что это TreeSet
	}
	@Override
	public String toString() {
		return "\nHuman ("+age+" "+name+")";
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Human h = (Human) o;
		return age == h.age; // name не сравниваются, так как в методе compareTo() также 			
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(age); // name не сравниваются, так как в методе compareTo() также 	
	}
	
}