package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class A_StreamInfo_Map { // Последовательность элементов, поддерживающих последовательные и параллельные операции над ними  
// Поток данных, которая содержит наша коллекция, а сам Stream - это интерфейс 
// Лучшее использование Lambda expressions именно в методах интерфейса Stream
// Методы интерфейса Stream не меняют лист или массив, на который были вызваны
	public static void main(String[] args) {
          List<String> arl = new ArrayList<String>();
          arl.add("hello");
          arl.add("wassup");
          arl.add("niga");
          arl.add("yep");
          arl.add("bye");
          
          /*
          // Старый способ
          for(int i = 0; i< arl.size(); i++) {
        	  arl.set(i, String.valueOf(arl.get(i).length())); // Мы заменили значения элементов arl, на их длину 
          }
          System.out.println(arl);
          */
          // Новый способ
      // stream() - методы интерфейса Stream работают не напрямую в массивом, а сначала преобразуют его в поток и работают уже с ним 
          // map() - Intermediate method
          // map() - берет каждый элемент по очереди нашего Stream и поставляет ему элемент, который мы преобразовали с помощью Lambda expression (тип элемента не меняется)       
          List<Integer> l = arl.stream().map(element -> element.length()).collect(Collectors.toList()); 
          // collect(Collectors.toList()) - преобразует поток в лист
          System.out.println(l);
          // List<Integer> l1 = arl.stream().map(element -> element.length()); // Мы не можем листу присвоить поток
          
          /* Method Chaining (stream().map().collect)
           * s.stream().map(e -> e.length()).collect(Collectors.toList)
           */ 
          
          
          // stream() on arrays
          int[] arr = {5,4,3,2,1};
          arr = Arrays.stream(arr).map(element ->{
        	  if( element%2 == 0) {
        	  element = element/2;
          }
          return element;
        }).toArray(); // toArray() - преобразует поток в массив
          System.out.println(Arrays.toString(arr));
          
           Set<String> s = new TreeSet<String>();
           s.add("hello");
           s.add("wassup");
           s.add("niga");
           s.add("ok");
           s.add("bye");
          System.out.println(s);
          
          // Мы можем любой поток преобразовать в любую коллекцию
          Set<Integer> set = s.stream().map(e -> e.length()).collect(Collectors.toSet()); // Вместо element можно писать просто e
          List<Integer> list = s.stream().map(e -> e.length()).collect(Collectors.toList());
          
          System.out.println(list);	
	}
	

}
