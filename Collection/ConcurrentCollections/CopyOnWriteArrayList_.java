package ConcurrentCollections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayList_ { // Имплементирует интрефейс List 
// Используем тогда, когда нужна потокобезопасность и 
// когда небольшое количество операций по изменению элементов и большое количество по их чтению
// CopyOnWrite - при каждом изменении элементов list, создается клон копии list нового вида 	
// Создание копий это очень затратный процесс 
	public static void main(String[] args) throws InterruptedException {
      CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.add(4);
      list.add(5);
      
      System.out.println(list);
      
      Runnable r1 = () -> {
    	  Iterator<Integer> iter = list.iterator(); // Iterator передалась информация об элементах list НА МОМЕНТ ЕГО СОЗДАНИЯ
    	  while(iter.hasNext()) {
    		  try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    		System.out.println(iter.next());
    	  }
      };
      
      Runnable r2 = () -> {
    	  try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	list.remove(4);// В этот момент создалась копия list 
    	list.add(10);  // А в этот еще одна копия list
      };
      
      Thread thread1 = new Thread(r1);
      Thread thread2 = new Thread(r2);
      
      thread1.start();
      thread2.start();
      thread1.join();
      thread2.join();
      
      System.out.println(list); // Здесь используется уже последняя копия 
	}

}
