package Map;

import java.util.Hashtable;

public class HashTable_ { // Копия HashMap, устаревший класс
// НО он синрхонизированный, может работать с многопоточностью
 // Ключи b значения не могут быть null
// Поэтому он такой медленный 
	public static void main(String[] args) {
		Divan d1 = new Divan(12, "Wood");
		Divan d2 = new Divan(30, "Red wood");
		Divan d3 = new Divan(50, "Iron wood");
		
		Hashtable<Double, Divan> ht = new Hashtable<>();
        ht.put(9.9,d1);
        ht.put(5.5,d2);
        ht.put(2.2,d3);
        
        System.out.println(ht);
	}

}
