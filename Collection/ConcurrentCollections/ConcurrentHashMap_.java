package ConcurrentCollections;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMap_ { // Имплементирует интерфейс ConcurrentHashMap, который имплементирует интерфейс Map
	// Делит множество элементов на сегменты
	
	// Сегмент - каждый элемент массива, который лежит в основе ConcurrentHashMap
	
	// Мы не можем одновременно выполнять действия в ОДНОМ сегменте (бакете)
    
	// ЗАТО мы можем параллельно работать в ДРУГИХ сегментах, без ограничения на их количество 
	
	// ConcurrentHashMap можно рассматривать как группу HashMap
	
	// В ConcurrentHashMap НИ key НИ value НЕ могут быть null
	
	// Больше HashMap и ConcurrentHashMap ничем не отличаются  
	
	public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();
        map.put(1,"Bob");
        map.put(2,"Rick");
        map.put(3,"Nick");
        map.put(4,"Mike");
        map.put(5,"Tom");
        
        System.out.println(map);
        
        // 1 Поток, который выводит все элементы 
        Runnable r1 = () -> {
        	Iterator<Integer> iter = map.keySet().iterator(); // У Map нет Iterator, зато у keySet(), он есть 
        	while(iter.hasNext()) {
        		try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        		Integer i =iter.next();
        		System.out.println(i+": "+map.get(i));
        	}
        };
        
        // 2 Поток, который добавляет элемент
        Runnable r2 = () -> {
        	try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	map.put(6,"Ann");       	
        };
        
	    Thread thread1 = new Thread(r1);
	    Thread thread2 = new Thread(r2);
		
	    thread1.start();
	    thread2.start();
	   
	    thread1.join();
	    thread2.join();
	    
	    System.out.println("Main done");
        
        System.err.println("JJJ");
	}

}
