package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedList_Deque { // Наследуется от интерфейса Deque (двунаправленная очередь)
	// Можно добавить следующий элемент в начало либо в конец очереди и также использовать элементы 
	

	public static void main(String[] args) {
		Queue<String> q = new LinkedList<String>();
		// Нельзя добавлять элементы за пределы очереди
		
		// add() - при добавлении за пределы очереди вылазит Exception 
		q.add("Bob"); 
		q.add("Tom");
		q.add("Ann");
		q.add("Mike");
		
		// offer() - при добавлении за пределы очереди нет Exception 
		q.offer("Rick"); 
		q.offer("Nick");
		System.out.println(q); // правило FIFO
		
		// remove() - удалится первый элемент
		System.out.println(q.remove());

		// poll() - удаляет элементы, НО, в отличие от remove(), не выбрасывает Exception
		System.out.println(q.poll());
		
		// element() - выводит первый элемент 
		System.out.println(q.element());
		
		// peek() - выводит первый элемент, НО, в отличие от remove(), не вцыбрасывает Exception
		System.out.println(q.peek());
	}

}
