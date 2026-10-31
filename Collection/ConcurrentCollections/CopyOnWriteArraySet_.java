package ConcurrentCollections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySet_ { // Работает по такому же принципу что и CopyOnWriteArrayList, только имплементирует интерфейс Set

	public static void main(String[] args) throws InterruptedException {
         CopyOnWriteArraySet<Integer> set = new CopyOnWriteArraySet<Integer>();
         set.add(1);
         set.add(2);
         set.add(3);
         set.add(4);
         set.add(5);
         
         System.out.println(set);
         
         Runnable r1 = () -> {
       	  Iterator<Integer> iter = set.iterator(); // Iterator передалась информация об элементах list НА МОМЕНТ ЕГО СОЗДАНИЯ
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
       	set.remove(4);// В этот момент создалась копия set 
       	set.add(10);  // А в этот еще одна копия set
         };
         
         Thread thread1 = new Thread(r1);
         Thread thread2 = new Thread(r2);
         
         thread1.start();
         thread2.start();
         thread1.join();
         thread2.join();
         
         System.out.println(set); // Здесь используется уже последняя копия 
   	}
}


