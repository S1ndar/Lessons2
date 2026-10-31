package Proga.task8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class t2 {
    public static void main(String[] args) {
        int[] array = new int[5];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }

        while (true) {
            System.out.print("Индекс (0-4) и значение через пробел: ");
            try {
                int index = scanner.nextInt();
                int value = scanner.nextInt();
                array[index] = value;
                System.out.println("Текущий массив:");
                for (int num : array) {
                    System.out.print(num + " ");
                }
                System.out.println("\n");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Ошибка: индекс должен быть от 0 до 4.");
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: нужно ввести два целых числа.");
                scanner.nextLine();
            }
        }
    }
}
