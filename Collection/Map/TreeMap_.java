package Map;

import java.util.Comparator;
import java.util.TreeMap;
// Основная цель использования TreeMap() - это нахождение отрезков ( например найти студентов у кого средний балл выше или ниже такого-то числа )
public class TreeMap_ { // Такой же как и HashMap, НО хранит элементы в отсортированном по ВОЗРАСТАНИЮ порядке
//  В основе TreeMap лежит КРАСНО-ЧЕРНОЕ дерево, скорость о(log(n)), не быстрее HashMap (бинарный поиск)
// Также как и в HashMap ключи уникальные, а значения нет
	public static void main(String[] args) {
		TreeMap<Double, Divan> treeMap1 = new TreeMap<>();
		Divan d1 = new Divan(12,"Blue Wood");
		Divan d2 = new Divan(1231,"Red Wood");
		Divan d3 = new Divan(5542,"Dark Wood");
		Divan d4 = new Divan(876,"Iron Wood");
		Divan d5 = new Divan(9441,"Yellow Wood");
       
		treeMap1.put(9.8,d1);
		treeMap1.put(3.4,d2);
		treeMap1.put(1.8,d3);
		treeMap1.put(7.9,d4);
		treeMap1.put(9.9,d5);
		
		System.out.println(treeMap1); // Выводит в порядке возрастания
		
		// get()
		System.out.println(treeMap1.get(9.9));
		
		// remove
		treeMap1.remove(3.4);
		System.out.println(treeMap1);
		
		// descendingMap() - выводит элементы массива в другом порядке
		System.out.println(treeMap1.descendingMap());

		// tailMap() - выводит все элементы у кого ключ БОЛЬШЕ данного числа 
		System.out.println(treeMap1.tailMap(8.0));
		
		// headMap() - выводит все элементы у кого ключ МЕНЬШЕ данного числа 
		System.out.println(treeMap1.headMap(4.0));
		
		// lastEntry() - выводит самый последний элемент
		System.out.println(treeMap1.lastEntry());
		
		// firstEntry() - выводит самый первый элемент 
		System.out.println(treeMap1.firstEntry());
		
		
		// Мы не можем в качестве ключа использовать класс не имплементируещий интерфейс Comparable
		TreeMap<Divan, Double> treeMap2 = new TreeMap<>();
		
		treeMap2.put(d1,9.8);
		treeMap2.put(d2,3.4);
		treeMap2.put(d3,1.8);
		treeMap2.put(d4,7.8);
		treeMap2.put(d5,9.9);
		
		System.out.println(treeMap2);
		
		/*
		// Еще одна реализация интерфейса Comparable 
		TreeMap<Divan, Double> treeMap3 = new TreeMap<>(new Comparator<Divan>() {
			@Override
			public int compare(Divan o1, Divan o2) {
				return o1.material - o2.material;
			}
			
		});
		*/
		
		Divan d6= new Divan(9441,"Yellow Wood");
		System.out.println(treeMap2.containsKey(d6)); 
		// Выведет true, потому что в TreeMap не нужно переопределять equals() и hashcode() для ключа,
		// Потому что TreeMap работает с методом containsTo(), НО это правило не распространяется на значения
		
		System.out.println(treeMap2.containsValue("")); // equals() будет использоваться, даже без hashcode()
	}

}
