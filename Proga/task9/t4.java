package Proga.task9;

class Counter {
    private int count = 0;

//    public void increment() {
//        count++; // Тут 3 операции ( прочитать, увеличить на 1 и заменить ), несколько потоков могут перезаписывать метод
//    }


     public synchronized void increment() {
         count++; // Ток один поток может выполнять этот метод
     }

    public int getCount() {
        return count;
    }
}

class IncrementThread extends Thread {
    private Counter counter;
    private int iterations;

    public IncrementThread(Counter counter, int iterations) {
        this.counter = counter;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterations; i++) {
            counter.increment();
        }
    }
}

public class t4 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        int numThreads = 10;
        int incrementsPerThread = 1000;
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new IncrementThread(counter, incrementsPerThread);
            threads[i].start();
        }

        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Ожидаемое значение: " + (numThreads * incrementsPerThread));
        System.out.println("Фактическое значение: " + counter.getCount());
    }
}