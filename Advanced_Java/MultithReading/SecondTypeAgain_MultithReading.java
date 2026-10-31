package MultithReading;

public class SecondTypeAgain_MultithReading implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println(i);
		}

	}

	public static void main(String[] args) {
		Thread thread1 = new Thread(new SecondTypeAgain_MultithReading());
		thread1.start();

		for (int i = 10; i >= 0; i--) {
			System.out.println(i);
		}
	}

}
