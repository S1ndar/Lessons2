package MultithReading;

public class ThreadMethods extends Thread{
    @Override
    public void run() {
    	for (int i = 0; i <= 10; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "  " + i );
		}
    }
	
	public static void main(String[] args) throws InterruptedException {
        
		Thread thread1 = new Thread(new Thread1());
		thread1.setName("A");
        Thread thread2 = new Thread(new ThreadMethods());
        thread2.setName("B");
        
        // Запуск потоков, они отпачковались от основного потока main
        thread1.start();
        thread2.start(); 
        
        // join() - поток, В котором был вызван этот метод, будет ждать окончания потока НА котором стоит этот метод
        thread1.join(); // Выбрасывает InterruptedException
        thread2.join(); // В аргументы принимает миллисекунды
        // В данной ситации поток main будет ждать окончания потоков thread1 и thread2

        // Поток main продолжает свое действие 
        System.out.println("Done");
        
        // Пока все потоки не прекратят работу программа не прекратит свое действие 
        
        /*
         // setName() - назначает имя потоку 
         thread1.setName("bye"); 
         
         // getName() - выводит имя потока
         System.out.println(thread1.getName());
         
         // Эффективен только в ThreadGroup (работа в команде или работа над крупным приложением)
         // setPriority() - задает порядок приоритета потоков ( в случае если ЦП окажется перегружен, 
                                                             // он отдаст приоритет тому потоку у кого приоритет выше) 
         thread1.setPriority(3);
         thread2.setPriority();
         
         //  getPriority() - выводит порядок приоритета потоков 
         System.out.println(thread1.getPriority());
         System.out.println(thread2.getPriority());
         
		 
	     // sleep() - дает нашему потоку поспать (отключает поток на заданное время) 
		 for(int i = 0; i<10;i++) {
			 System.out.println(i);
		     Thread.sleep(1000);
		 }
		 System.out.println("GO");
		 */ 
	}


}

class Thread1 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			try {
				Thread.sleep(500); 
			} catch (InterruptedException e) { // InterruptedException - пока ваш поток спал, другой поток попросил его остановиться
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "  " + i );
		}
	}
}