package Map;

import java.util.HashMap;
import java.util.Map;

public class HashMap_ { // Самый часто используемый класс от интерфэйса Map (он не сортирует ключи и значения, поэтому такой быстрый), не синхронизированный
// В HashMap каждый элемент имеет хэшкод, ключ, значение и ссылку на следующий элемент (если такой есть)
// А поиск происходит сначала по его хэшкоду, затем по ключу, значению, и ссылке на следующий элемент
	
// Ключи не могут повторяться, должны быть уникальными (могут быть классами)
	// Очень важно использовать константные значения ключей 
// Значения могут повторяться (могут быть классами)
	public static void main(String[] args) {
		// Integer и String являтся парой 
		Map<Integer, String> map1 = new HashMap(); 
		// Скорость поиска или вставки элементов в ХОРОШЕМ HashMap = o(1)
		// А в плохом HashMap ( где плохой метод hashcode() и куча кализий) = o(n) - Скорость LinkedList() 
		// Когда кализий слишком много, то HashCode() начинает хранить элементы в сбалансированных деревьях (TreeMap) и происходит бинарный поиск binarySearch = o(logn) 
		// put() - добавление элементов в HashMap
		map1.put(100,"Diego");
		map1.put(700,"Julio");
		map1.put(null,null);
		map1.put(200,"Tom");
		map1.put(300,"Mike");
		map1.put(2000,"Mike");
		
		// putIfAbsent - добавление элемента, если такого нет в HashMap
		map1.putIfAbsent(100,"Diego"); 

		System.out.println(map1); // HashMap не имеет порядка вывода 
		
		// get() - возвращает элемент по его ключу
		System.out.println(map1.get(200)); 
		
		// remove() - удаление элемента по его ключу 
		map1.remove(100);
		System.out.println(map1);
		
		// containsValue() - проверка элемента по его значению
		System.out.println(map1.containsValue("Mike"));
		
		// containsKey() - проверка элемента по его ключу
		System.out.println(map1.containsKey(500));
		
		// keySet() - возвращает ключи
		System.out.println(map1.keySet());
		
		// values() - возвращает значения
		System.out.println(map1.values());
	    
		// HashMap (initial capacity, load factor), дефолтные значения (16, 0.75f)
		Map<String, String> map2 = new HashMap(16, 0.75f);
		// initial capacity - это начальный размер массива (int), чем он больше, тем больше памяти он будет занимать, 
		// НО тем меньше наш массив будет перестравиваться и тем быстрее будет происходить поиск элемента 
		
		// load factor - коэффициент того, насколько массив должен быть заполнен, чтобы потом увеличить его вдвое (float), чем он больше 
		// тем больше памяти мы будем экономить, но тем медленне будет происходить поиск элементов 
		
		// 16 * 0.75f = 12 - как только будет заполнено 12 элементов, массив перестроиться и увеличиться вдвое
		map2.put("Bob", "Strong");
		map2.put("Mike", "Smart");
		
		
	    
	}

}
