package MultithReading;

public class SecondType_MultithReading {

	public static void main(String[] args) {
		// 2 тип создания потока ( с помощью интерфейса Runnable)
		// Чаще всего используют второй вариант создания потока 
        Thread thread1 = new Thread(new myThread3());		
        Thread thread2 = new Thread(new myThread4());
        thread1.start();
        thread2.start();
	}

}

//2 тип создания потока            
class myThread3 implements Runnable { // extends мы можем использовать только 1 раз,
	public void run() { // и если наш класс уже наследуется от другого, то стоит выбрать 2 тип создания потока
						
		for (int i = 0; i <= 10; i++) {
			System.out.println(i);
		}
	}
}

class myThread4 implements Runnable {
	public void run() {
		for (int i = 10; i >= 0; i--) {
			System.out.println(i);
		}
	}
}