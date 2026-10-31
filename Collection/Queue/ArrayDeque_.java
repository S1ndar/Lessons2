package Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDeque_ {

	public static void main(String[] args) {
	    Deque<Integer> ard = new ArrayDeque<Integer>();
	    
	    // addLast() - добавление элементов в конец очереди 
	    ard.addLast(1);
	    ard.addLast(4);
	    
	    // addFirst() - добавление элементов в начало очереди
	    ard.addFirst(12);
	    ard.addFirst(20);
	    
	    // offerFirst() - добавление в начало без Exception
	    ard.offerFirst(2);
	    ard.offerFirst(19);
	    
	    // offerLast() - добавление в конец без Exception 
	    ard.offerLast(30);
	    ard.offerLast(80);
	    
	    System.out.println(ard);
	    
	    // removeFirst() - удаление первого элемента 
	    System.out.println(ard.removeFirst());
	    
	    // removeLast() - удаление последнего элемента 
	    System.out.println(ard.removeLast());
	    
	    // pollFirst() - удаление первого элемента без Exception
	    System.out.println(ard.pollFirst());
	    
	    // pollLast() - удаление последнего элемента без Exception
	    System.out.println(ard.pollLast());
	    
	    
	    
	    // getFirst() - вывод первого элемента 
	    System.out.println(ard.getFirst());
	    
	    // getLast() - вывод последнего элемента
	    System.out.println(ard.getLast());
	    
	    // peekFirst() - вывод первого элемента без Exception
	    System.out.println(ard.peekFirst());
	    
	    // peekLast() - вывод последнего элемента без Exception
	    System.out.println(ard.peekLast());
	    
	}

}
