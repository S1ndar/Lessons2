package SynchronizedCollection;

import java.util.Hashtable;

public class HashTable_ { // Копия HashMap, устаревший класс
// НО он синрхонизированный, может работать с многопоточностью
 // Ключи b значения не могут быть null
// Поэтому он такой медленный 
	public static void main(String[] args) {
		
		Hashtable<Double, String> ht = new Hashtable<>();
        ht.put(9.9,"A");
        ht.put(5.5,"G");
        ht.put(2.2,"F");
        
        System.out.println(ht);
	}

}
