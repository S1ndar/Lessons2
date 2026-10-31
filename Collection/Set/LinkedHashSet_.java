package Set;

import java.util.LinkedHashSet;
// Используем тогда, когда нам нужен Hashset, и порядок добавления информации
public class LinkedHashSet_ { // Такой же как и HashSet, в основе лежит HashSet, НО он хранит информацию о порядке добавления элементов
// Ключи - элементы LinkedHashSet, значения - константа-заглушка  

	public static void main(String[] args) {
		LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
		lhs.add(1);
		lhs.add(9);
		lhs.add(4);
		lhs.add(6);
		lhs.add(2);
		lhs.add(3);
		
		System.out.println(lhs);
        lhs.remove(9);
        System.out.println(lhs);
        System.out.println(lhs.contains(9));
	}

}
