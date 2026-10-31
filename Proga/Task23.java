package Proga;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Task23 {
    public static void main(String[] args) {
//        chetNechet();
//        quadraticD();
//        multiplicationTable();
//        arrayTasks();
        KrestikiNoliki();
        linearAndBinarySearch();
    }

    public static void chetNechet() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = scanner.nextInt();
        if (number % 2 == 0) {
            System.out.println("Чётное");
        } else {
            System.out.println("Нечётное");
        }
    }

    public static void quadraticD() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите a: ");
        double a = scanner.nextDouble();
        System.out.print("Введите b: ");
        double b = scanner.nextDouble();
        System.out.print("Введите c: ");
        double c = scanner.nextDouble();

        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Корни: x1 = " + x1 + ", x2 = " + x2);
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            System.out.println("Корень: x = " + x);
        } else {
            System.out.println("Нет действительных корней");
        }
    }

    public static void multiplicationTable() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }

    public static void arrayTasks() {
        Random random = new Random();
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println("Исходный массив: " + Arrays.toString(array));

        int max = array[0];
        int min = array[0];
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }

        System.out.println("Максимальный элемент: " + max + ", индекс: " + maxIndex);
        System.out.println("Минимальный элемент: " + min + ", индекс: " + minIndex);

        int[] bubbleArray = array.clone();
        for (int i = 0; i < bubbleArray.length - 1; i++) {
            for (int j = 0; j < bubbleArray.length - 1 - i; j++) {
                if (bubbleArray[j] > bubbleArray[j + 1]) {
                    int temp = bubbleArray[j];
                    bubbleArray[j] = bubbleArray[j + 1];
                    bubbleArray[j + 1] = temp;
                }
            }
        }
        System.out.println("Сортировка пузырьком: " + Arrays.toString(bubbleArray));

        int[] sortedArray = array.clone();
        Arrays.sort(sortedArray);
        System.out.println("Arrays.sort(): " + Arrays.toString(sortedArray));
    }

    public static void KrestikiNoliki() {
        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameOver = false;

        while (!gameOver) {
            printBoard(board);
            System.out.println("Игрок " + currentPlayer + ", введите строку (0-2) и столбец (0-2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer;

                if (checkWin(board, currentPlayer)) {
                    printBoard(board);
                    System.out.println("Игрок " + currentPlayer + " победил!");
                    gameOver = true;
                } else if (isBoardFull(board)) {
                    printBoard(board);
                    System.out.println("Ничья!");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Неверный ход!");
            }
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }

    public static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }

    public static void linearAndBinarySearch() {
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число для поиска: ");
        int target = scanner.nextInt();
        System.out.println(linearSearch(array, target));
        System.out.println(binarySearch(array, target));

    }

    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                System.out.println("Индекс " + i);
                return i;
            }
        }
        System.out.println("Число не найдено");
        return -1;
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                System.out.println("Индекс " + mid);
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Число не найдено");
        return -1;
    }

}