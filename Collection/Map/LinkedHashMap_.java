package Map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMap_ { // Наследник HashMap, НО хранит информацию о порядке добавления элементов или порядке их использования 
// Скорость меньше чем у HashMap
	public static void main(String[] args) {
		Divan d1 = new Divan(12, "Wood");
        Divan d2 = new Divan(30, "Red wood");
        Divan d3 = new Divan(50, "Iron wood");
                                                                
        Map<Divan, Double> map1 = new LinkedHashMap<Divan, Double>(16,0.75f,true);
        map1.put(d1, 5.1);                                     // false - элементы будут выводится в порядке их добавления 
        map1.put(d3, 6.0);                                     // true - элементы будут выволится в порядке их использования (если используются методы put() и get())
        map1.put(d2, 9.5); 
        System.out.println(map1);
        
        System.out.println(map1.get(d1)); // Как только мы использовали данный элемент, он стал последним в списке 
        System.out.println(map1); 
        
	}

}
