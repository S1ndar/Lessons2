package Parallel_Stream;

import java.util.ArrayList;
import java.util.List;

public class Parallel_Stream {
// Возможность использовать потоки параллельно 
// При этом никакую многопоточность создавать не нужно
// Данная функция АБСОЛЮТНО не подходит, когда нам нужен порядок действий 	
	public static void main(String[] args) {
        List<Double> l = new ArrayList<Double>();
		l.add(10.0);
		l.add(0.25);
		l.add(1.0);
		l.add(5.0);

		
       // Sum - здесь нет порядка элементов, поэтому все правильно работает
		// stream()
		double sum = l.stream().reduce((a,e)->a+e).get();
		System.out.println(sum);
       
		// parallelStream() - если элементов много то он справляется быстрее и точнее stream()
		double parallelSum = l.parallelStream().reduce((a,e)->a+e).get();
		System.out.println(parallelSum);
		
       // Average - здесь уже нужен порядок элементов, поэтому parallelStream() работает неправильно
		// stream()
		double average = l.stream().reduce((a,e)->e/a).get();
		System.out.println(average);
		// ((10/0.25)/1)/5.0 - правильно
		
		// parallelStream() 
		double parallelAverage = l.parallelStream().reduce((a,e)->e/a).get();
		System.out.println(parallelAverage);
		// (10/0.25)/(1.0/5.0) - НЕПРАВИЛЬНО
		
	}

}
