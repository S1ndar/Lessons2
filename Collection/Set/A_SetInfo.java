package Set;

import java.util.HashSet;

public class A_SetInfo { // Очень хорошая производительность
	
/* Set - коллекция, хранящая уникальные элементы (значения и константа-заглушка), методы очень быстры (В основе лежит урезанная коллекция Map, 
 * то есть значения HashSet, являются ключами HashMap)        
 * HashSet также как и HashMap не содержит порядок добавления элементов         
 *                 Set
 *    HashSet              SortedSet
 *  LinkedHashSet        NavigableSet
 *                         TreeSet
 *                         
 *                         
 *     Set              Map                      
 *    "Bob"           (3,"Bob")      
 *   HashSet           HashMap
 *   "Bob"     ->    "Bob", const          
 *                         
 *                         
 */
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<>();
		hs.add(6);
		hs.add(4);
		hs.add(2);
		hs.add(5);
		hs.add(3);
		
		System.out.println(hs);

	}

}
