package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class A_QueueInfo {
/*	Queue - очередь, хранит последовательность элементов, соблюдается правило FIFO - first in, first out
 *  Добавляется элемент в конец очереди, используется из начала очереди 
 *  Queue не предназначен для того, чтобы этот элемент был удален с середины
 *  В качестве элементов можно использовать дупликаты, НО нельзя использовать null
 *  
 *  Deque - двунаправленная очередь, правило FIFO и LIFO 
 *  
 *                          Queue
 *           Deque                     AbstractQueue
 *  LinkedList  ArrayDeque             PriorityQueue
 *  
 *  
 *  
 *  
 *
 */
	public static void main(String[] args) {
	    Queue<Integer> pq = new PriorityQueue<Integer>();
	    pq.offer(5);
	    pq.offer(3);
	    pq.offer(4);
	    pq.offer(2);
	    pq.offer(1);
        
	    System.out.println(pq);
	    
	    Deque<Integer> ard = new ArrayDeque<Integer>();
	    ard.offerFirst(2);
	    ard.offerFirst(1);
        ard.offerLast(3);
        ard.offerLast(4);
        
        System.out.println(ard);
	}

}
