package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListMethods3 {

	public static void main(String[] args) {
		
		StringBuilder sb1 = new StringBuilder("A");
		StringBuilder sb2 = new StringBuilder("B");
		StringBuilder sb3 = new StringBuilder("C");
		
		StringBuilder[] arrSB = {sb1,sb2,sb3};
		List<StringBuilder> list = Arrays.asList(arrSB); // Мы приравняли массив с листом, НО длина массива лист теперь не изменяется (она такая же как и в массиве arrSB)
		//System.out.println(list);
		//arrSB[0].append("!!!"); // Мы добавили элемент в массив
		arrSB[0] = new StringBuilder("F"); // Мы изменили элемент в массиве
		//System.out.println(list);
		
		List<String> arl1 = new ArrayList();
		arl1.add("Tom");     
		arl1.add("Bob");     
		arl1.add("John");    
		arl1.add("Misha");   
		
		List<String> arl2 = new ArrayList();
		arl2.add("!!!");     
		arl2.add("№№№");     		
		arl1.addAll(arl2);
		//System.out.println(arl1);
		
	    //arl1.removeAll(arl2);   // removeAll удаляет объекты выбранного нами массива из другого массива\
	    
        //arl1.retainAll(arl2);   // retainAll делает все наоборот (оставляет объекты выбранного нами массива, но удаляет другие)
        
		//containsAll()
        boolean result = arl1.containsAll(arl2); // Проверяет содержаться ли все элементы массива arl2 в массиве arl1 (выводит true или false)
        //System.out.println(result);
        
        // SubList() не существует на самом деле, а лишь является представлением другого массива
        List<String> myList = arl1.subList(0, 2); // Добавляет только определенные значение в другой массив, при помощи индексов [0,x)
        //System.out.println(myList);
        myList.add("Fedor");
        //System.out.println(myList);// Fedor добавился в этот массив с индексом 2 (последний индекс в этом массиве)
        //System.out.println(arl1);  // И здесь Fedor добавился уже в этот массив и на этот же индекс 2 (потому что subList является view arl1)
        arl1.add("Mike");
        //System.out.println(myList); // НО это не работает в обратную сторону (выведет ConcurrentModificationExceprion)
        // Sublist -> ArrayList
        
        //toArray()
        String[] arr = arl1.toArray(new String[0]); // Приравнивает ArrayList arl1 к массиву arr 
        for (String s : arr) {
        	//System.out.print(s+" ");			
		}
        
        //List.of()
        List<Integer> list1 = List.of(7,6,5); // Сокращенный способ создания list, но с неизменяемыми элементами (и не могут содержать null)
        List.of(1,2,3); // Статический метод, с кучей вариаций использования
        System.out.println(list1);
        
        //List.copyOf()
        List<String> list2 = List.copyOf(arl1); // Сокращенный способ копирования элементов другого list, но с неизменяемыми элементами (и не могут содержать null)
        List.copyOf(arl1); // Статический метод, с кучей вариаций использования
        System.out.println(list2);
	}

}
