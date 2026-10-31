package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// Если мы переопределяем метод equals(), то мы обязаны переопределить метод hashCode()
public class HashCode_ { // Мы обязаны переопределять эти методы, если используем собственные классы или методы
	// В дефолтном методе hashCode() используется адресное значение класса (ссылка на этот класс), поэтому у ВСЕХ объектов будут уникальные хэшкоды       
	
	public static void main(String[] args) {
		Divan d1 = new Divan(12, "Wood");
        Divan d2 = new Divan(30, "Red wood");
        Divan d3 = new Divan(50, "Iron wood");
        
        Map<Divan, Double> map1 = new HashMap<Divan, Double>();
        map1.put(d1, 5.1);
        map1.put(d2, 9.5);
        map1.put(d3, 6.0);
        
        System.out.println(map1);
        Divan d4 = new Divan(12,"Wood");
        
        boolean result = map1.containsKey(d4);
        System.out.println("result = "+result);
        System.out.println(d1.equals(d4)); // equals() сравнивает ссылки
        
        // hashCode() - хэширует, у каждого элемента должны быть уникальные хэшкоды
        System.out.println(d1.hashCode()); // НО у одиннаковых объектов должен быть одинаков hashCode()
        System.out.println(d4.hashCode());
        
        // Кализия - ситуация когда хэшкод одного объекта, равен хэшкоду другого объекта, хотя сами эти объекты не равны друг другу
        Divan d5 = new Divan(114, "Dark wood");
        
        // entrySet() - с помощью этого метода выводится HashMap
        for(Map.Entry<Divan,Double> entry: map1.entrySet()) {
        	System.out.println(entry.getKey()+ ": "+ entry.getValue());
        }
        //Entry - внутренний интерфейс Map
        //Node (ключ, значение и ссылка на следующий элемент) имплементируется от интерфейса Entry
	}

}
class Divan implements Comparable<Divan>{
	// Очень важно использовать константные ключи 
	private final int id;
    private final String material;
	
	public Divan(int i, String m) {
		id = i;
		material = m;
	}
	@Override
	public String toString() {
		return "\nDivan (id - "+id+", material - "+material+")\n";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Divan d = (Divan) obj;
		return id == d.id &&
			Objects.equals(material, d.material);		
	}
	
	// hashCode() - хэширует (преобразует любой объект в int)
	public int hashCode() { // Без переопредленного hashCode() метода result выдает false 
		return Objects.hash(material, id);
	}
	
	// Реализация интерфейса Comparable
	public int compareTo(Divan o) {
		return this.material.compareTo(o.material);
	}
    
}