package Proga.task9;

class NumberPrinter extends Thread {
    private String threadName;

    public NumberPrinter(String name) {
        this.threadName = name;
        setName(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " выводит: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(threadName + " был прерван");
                e.printStackTrace();
            }
        }
        System.out.println(threadName + " завершил работу");
    }
}

public class t3{
    public static void main(String[] args) {
        NumberPrinter thread1 = new NumberPrinter("Поток 1");
        NumberPrinter thread2 = new NumberPrinter("Поток 2");
        NumberPrinter thread3 = new NumberPrinter("Поток 3");

        try {
            thread1.start();
            thread1.join();

            thread2.start();
            thread2.join();

            thread3.start();
            thread3.join();

        } catch (InterruptedException e) {
            System.out.println("Главный поток был прерван");
            e.printStackTrace();
        }

        System.out.println("Over");
    }
}