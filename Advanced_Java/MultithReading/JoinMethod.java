package MultithReading;

public class JoinMethod {

	public static void main(String[] args) throws InterruptedException {
           System.out.println("Main begins");
           Thread thread1 = new Thread(new Worker());
           
           
           // getState() - выводит состояние Thread (нужно быть осторожным с этим методом. так как скорость thread может быть выше скорости getState())
           System.out.println(thread1.getState());
           thread1.start();
           System.out.println(thread1.getState());           
           thread1.join(); // main ждет пока поток thread1 завершит свое действие ИЛИ пока не пройдет 1.5 секунды
           System.out.println(thread1.getState());
           System.out.println("Main ends");
           
	}

}

class Worker implements Runnable{

	@Override
	public void run() {
        System.out.println("Work begins");
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println("Work ends");
	}
	
}
