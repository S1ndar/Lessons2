package SynchronizedCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class A_SynchronizedCollection_ {

	public static void main(String[] args) throws InterruptedException {
		/*
		List<Integer> source = new ArrayList<Integer>();
	    for (int i = 0; i < 5; i++) {
			source.add(i);			
		}
		
	    // sunchronizedList() - обертка для работы с многопоточностью, только после того как один поток отработает, запустится следующий
	    // Обертка работает на логах (из-за этого такая низкая скорость)
	    List<Integer> synchList = 
	           Collections.synchronizedList(new ArrayList<>());    		
	    		
	    Runnable runnable = () -> {synchList.addAll(source);};
	    
	    // Два потока 
	    Thread thread1 = new Thread(runnable);
	    Thread thread2 = new Thread(runnable);
		
	    thread1.start();
	    thread2.start();
	   
	    thread1.join();
	    thread2.join();
	    
	    System.out.println(synchList); // Результаты меняются (НО после того как мы синхронизировали arl, такого больше нет)
	    */
	    
	    ArrayList<Integer> arl  = new ArrayList<Integer>();
	    for(int i = 0; i < 400; i++) {
	    	arl.add(i);
	    }
	    List<Integer> synchList = Collections.synchronizedList(arl);
	    
	    // Два пототка (Проблема обертки в том, что мы не назначаем какой поток будет стартовать первым)
	    Runnable runnable1 = () -> { // один проходится по всем элементам и выводит их
	    	synchronized (synchList) { // synchronized() значит что до тех пор пока этот поток не закончит свое действие, другой не начинает 
	    		// Работу итератора в данном случае нужно заключать в synchronized(){} блок 
	    		Iterator<Integer> iter = synchList.iterator();
	    		while(iter.hasNext()){
	    			System.out.println(iter.next());
	    		}	    		
	    	}
	    };
	    Runnable runnable2 = () -> { // второй удаляет все элементы с индексом 10 (без обертки работает только 1 поток и выводится Ecxeption)
	    	synchList.remove(10); // ставиться лог и iter.next() на время действия лога не работает (НО после synchronized() все работает по другому и все ОК)
	    };
	    Thread thread1 = new Thread(runnable1);
	    Thread thread2 = new Thread(runnable2);
	    
	    thread1.start();
	    thread2.start();
	    thread1.join();
	    thread2.join();
	    
	    System.out.println(synchList);
	}
}
