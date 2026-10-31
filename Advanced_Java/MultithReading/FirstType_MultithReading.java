package MultithReading;

public class FirstType_MultithReading { // Многопоточность

	public static void main(String[] args) { // В методе main создается main ПОТОК
		/*
		 // Однопоточность - последовательное выполнение statement
         System.out.println("Hello");         
         for(int i = 0; i<10;i++) {
        	 System.out.println(i);
         }
         System.out.println("Bye");
         */
         // Многопоточность - параллельное выполнение statement
         // Цель многопоточности - параллельная работа всех функций, производительность
		
		 // 1 тип создания потока
         myThread1 mt1 = new myThread1(); // Потоки не синхронизированы
         myThread2 mt2 = new myThread2();
         mt1.start(); // Вызывается метод run()
         mt2.start();         
	}

}
// 1 тип создания потока            
class myThread1 extends Thread{ // extends мы можем использовать только 1 раз, 
	public void run() {         // и если наш класс уже наследуется от другого, то стоит выбрать 2 тип создания потока
		for(int i = 0; i<=10;i++) {
			System.out.println(i);
		}
	}
}                                                                  

class myThread2 extends Thread{
	public void run() {
		for(int i = 10; i>=0;i--) {
			System.out.println(i);
		}
	}
}