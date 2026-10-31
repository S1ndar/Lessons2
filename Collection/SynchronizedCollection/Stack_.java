package SynchronizedCollection;

public class Stack_ { // Такой же как и Vector, но использует принцип LIFO ( Последним зашел, первым выйдет) 
    
	
	// Принцип LIFO
	public static void main(String[] args) {
		System.out.println("Main starts");
		a3();
		System.out.println("Main ends");

	}
    static void a1() {
    	System.out.println("a1 starts");
    	System.out.println("a1 ends");
    }
    static void a2() {
    	System.out.println("a2 starts");
    	a1();
    	System.out.println("a2 ends");
    }
    static void a3() {
    	System.out.println("a3 starts");
    	a2();
    	System.out.println("a3 ends");
    }
}
