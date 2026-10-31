package MultithReading;

public class Thread_ {
	/* Состояния Thread 
	 * 1. New (до вызова метода start())
	 * 
	 * 2. Runnable (после вызова метода start())
	 *   2.1) Ready (готовый к выполнению, ждет операционную систему (в очереди ))
	 *   2.2) Running (когда поток на самом деле выполняется)
	 *    
	 * 3. Terminated (работа потока завершена)
	 */

	public static void main(String[] args) { // main поток
		
		// 3 тип создания потока (с помощью анонимного класса Runnable, имплементирующего интерфейс Runnable)
		new Thread(new Runnable() {
			
			@Override
			public void run() {
	         System.out.println("hello");   
			}
		}).start();
		
		// 4 тип создания потока ( с помощью lambda, так как Runnable - функциональный интерфейс)
		new Thread(() -> System.out.println("bye")).start();
	    
		// Особенности : эти два потока работают в потоке main 
        
		
	}

}
