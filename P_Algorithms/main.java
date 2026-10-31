package P_Algorithms;

class Main {
    public static void main(String[] args) {
        Stas<String> stack = new Stas<>();

        stack.push("Первое");
        stack.push("Второе");
        stack.push("Третье");

        stack.print();

        System.out.println(stack.pop());

        stack.print();
    }
}
