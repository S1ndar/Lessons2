package SynchronizedCollection;

import java.util.Stack;

public class StackMethods {

	public static void main(String[] args) {
		Stack<String> st = new Stack();
		st.push("Tom"); // push() добавляет элемент 
		st.push("Bob");
		st.push("Mike");
		System.out.println(st);
		
		while(!st.isEmpty()) { // isEmpty() пока в stack есть элемент 
			System.out.println(st.pop()); // pop() возвращает последний (верхний) элемент и сразу его удаляет
			System.out.println(st);		
		}
		
		System.out.println(st.peek()); // peek() возвращает последний элемент, но не удаляет его
		System.out.println(st);
		
	}

}
