package ConcurrentCollections;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueue_ {// Имплементирует интерфейс Queue
// Cuncurrent Collection с ограниченным размером ( capacity restricted )
// Обычно один или несколько потоков добавляют элементы в конец очереди, 
// А другой или другие потоки забирают элементы из начала очереди	
// Producer - добавляет элементы в начало очереди ( каждую секунду )
// Consumer - забирает элементы с конца очереди ( каждые 3 секунды )
// Правило FIFO
	
	public static void main(String[] args) {
          ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(4);// Нужно обязательно указывать размер очереди
          // Добавлять элементы нужно всегда с помощью метода offer()
          // Чтобы избежать Exception
          // q.offer(1);
          // q.offer(2);
          // q.offer(3);
          // q.offer(4);
          
          // Producer
          new Thread(() -> {
        	 int i = 0;
        	 while(true) {
        		 try {
        			// put() - добавляет элементы, если очередь заполнена, то он будет ждать пока она освободится  
					q.put(++i);
					System.out.println("Producer put "+i+" "+q);
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        	 }
          }).start();
          
          // Consumer
          new Thread(() -> {
        	  while(true) {
        		  try {
					int j = q.take();
					System.out.println("Consumer take "+j+" "+q);
					Thread.sleep(9000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        	  }
          }).start();
          
          /* Когда очередь переполнена Producer останавливается и спит, пока Consumer не заберет элемент, 
           * затем Prosucer сразу же доавляет новый 
           */
	}
}
