package List;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMethods2 {

	public static void main(String[] args) {
		List<String> arl1 = new ArrayList();
		arl1.add("John");
		arl1.add("Tom");
		arl1.add("Bob");
		arl1.add("John");
		System.out.println(arl1);
		
		List<String> arl2 = new ArrayList();
        arl2.add("!!!");
        arl2.add("???");
        arl1.addAll(1,arl2); // Добавляет все элементы другого массива 
        System.out.println(arl1);
        
        arl1.clear(); // Очищает массив
        System.out.println(arl1);
        
		
		System.out.println(arl1.indexOf("John")); // indexOf выводит индекс выбранного объекта, если будут дубликаты, то в таком случае выводится первый из них
		
		System.out.println(arl1.lastIndexOf("John")); // Работает так же как и indexOf, только начинает с конца
		
		System.out.println(arl1.size()); // Выводит size массива
		
		System.out.println(arl1.isEmpty()); // Если массив пуст то выводит true, если нет то false
		
		System.out.println(arl1.contains("Mike")); // Ищет элемент в массиве, если находит выводит true, если нет то false (работает с помощью метода equals)
		
		
	
	}

}
