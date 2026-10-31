package Proga.task9;
import java.io.*;
import java.util.concurrent.locks.ReentrantLock;

class FileWorker {
    private static final String FILE_NAME = "log.txt";
    private static final ReentrantLock lock = new ReentrantLock();

    public static synchronized void writeNumber(int number) throws IOException {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(String.valueOf(number));
            bw.newLine();
            System.out.println("Записано: " + number);
        }
    }

    public static synchronized void readFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void clearFile() throws IOException {
        try (FileWriter fw = new FileWriter(FILE_NAME, false)) {
        }
    }
}

class WriterThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                FileWorker.writeNumber(i);
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ReaderThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(2000);
                FileWorker.readFile();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class t1 {
    public static void main(String[] args) throws IOException {
        FileWorker.clearFile();

        WriterThread writer = new WriterThread();
        ReaderThread reader = new ReaderThread();

        writer.start();
        reader.start();

        try {
            writer.join();
            reader.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Over");
    }
}