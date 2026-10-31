

/*
 * Интерфейс Collection происходит от интерфейса Iterable
 * Пример из жизни -  коллекция марок или коллекция листьев
 * 
 * Все коллекции работают с generic (то есть содержат в себе элементы определенного типа)
 *               Iterable
 *              Colection
 *       List     Queue      Set     |  Map (не наследуется от Colection (не имеет методов Collection, но также являются частью коллекций)   
 *                Deque                 ConcurrentHashMap
 *                       
 *                       
 *  интерфейс Collection != класс Collections   
 *  
 * Скорости в программировании :
 * o(1) - самый быстрый (константный )
 * o(logn)
 * o(n)
 * o(n^2)
 */

import java.util.ArrayList;
import java.util.List;

public class Collection_Interface{
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("HELLO GLIST");
		System.out.println(list);
	}
}


 