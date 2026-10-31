package Map;

import java.util.HashMap;
import java.util.Map;

public class A_MapInfo {
/* Map может содержать пары элементов (ключ и значение), не имплементит интрефейс Collection
 *                       Map
 *    HashMap          SortedMap         HashTable
 * LinkedHashMap      NavigableMap
 *                     TreeMap
 *                     
 * HashMap - лучший из лучших, среди несинхронизированных Map
 * TreeMap - использовать в редких случаях, когда нужно выводить объекты по возрастанию
 * ConcarableHashMap 
 */
	public static void main(String[] args) {
	   Map<Integer, String> map1 = new HashMap<Integer, String>();
	   map1.put(1,"Bob");
	   map1.put(2,"Tom");
	   map1.put(3,"Mike");
	   
	   System.out.println(map1);

	}

}
