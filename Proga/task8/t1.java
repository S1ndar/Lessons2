package Proga.task8;

public class t1 {
    public static void main(String[] args) {
        int[][] testPairs = {{10, 2}, {5, 0}, {20, 4}, {7, 0}};

        int[] a = {1,0,2,3,4,5};
        try{
            int result = divide(a[0],a[1]);
            System.out.println(result);
        } catch (ArithmeticException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Operation is complete");
        }
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль невозможно");
        }
        return a / b;
    }
}