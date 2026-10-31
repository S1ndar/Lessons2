import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class IteratorExample {

	public static void main(String[] args) {
		List<String> arl1 = new ArrayList();
		arl1.add("Tom");
		arl1.add("Bob");
		arl1.add("John");
		
		// Iterator - повторитель (для всех классов интерфейса Collection)
		Iterator<String> iterator = arl1.iterator(); // Мы выводим все элементы этого list (похож на foreach)
		while(iterator.hasNext()) {
		   iterator.next(); // Нельзя удалить элемент, без метода next()
		   iterator.remove();		   
		}
		System.out.println(iterator);
        // Отличается от foreach тем что мы можем изменять элементы list
	}

}
