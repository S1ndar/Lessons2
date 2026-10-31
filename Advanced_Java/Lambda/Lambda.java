package Lambda;

import java.util.ArrayList;
import java.util.Collections;

public class Lambda {
	static void testPeople(ArrayList<People> a1, PeopleCheck pc) { // testPeople в аргументы принимает ArrayList и класс имплементирующий интерфейс PeopleChech 
	   for (People p : a1) { // Пробирает все элементы ArrayList
		  if(pc.check(p)){ 
			 System.out.println(p);
		  }
	   }
    }
	public static void main(String[] args) {		
		People p1 = new People("Bob",20,1,4.5,'m');
		People p2 = new People("Ann",31,4,4.1,'f');
		People p3 = new People("Mike",45,6,5.0,'m');
		People p4 = new People("Tom",63,10,3.6,'m');
		People p5 = new People("Rick",19,1,3.3,'m');
			
		ArrayList<People> arl = new ArrayList<People>();
		arl.add(p1);
		arl.add(p2);
		arl.add(p3);
		arl.add(p4);
		arl.add(p5);
		/*
		// Anonymous class
		Collections.sort(arl, new Comparator<People>() {
			@Override
			public int compare(People o1, People o2) {
				return o1.course - o2.course;
			}			
		});
		*/
		// Lambda expression
		Collections.sort(arl, (o1,o2) -> o1.course - o2.course);
		System.out.println(arl);
		/*	
		// testPeople( ArrayList<People>, PeopleCheck sc)
		testPeople(arl, new PeopleCheck() { // PeopleCheck - анонимный класс имплементирующий интерфейс PeopleCheck 
			@Override 
			public boolean check(People p) { 
				return p.cource>4  && p.sex == 'm' && p.age > 20 && p.grade > 4.3;
			}			
		});
		System.out.println("---------------");
		*/
		
		// Lambda expressions - Функциональный стиль программировани
		// Lambda expressions - сокращенный вариант метода анонимного класса или метода обычного класса имплементирующих интерфейс PeopleCheck 
		// Lambda включает в себя только аргументы метода класса имплементирующего интерфейс PeopleCheck (check())
	    testPeople(arl, (People p) -> {return p.age > 39;}); // Идеальный способ как можно использовать фильтрацию,
	                                                         // без анонимных классов или обычных классов имплементирующий какой-либо интерфейс
	    // -> - разделяет параметры метода и тело метода 
		System.out.println("---------------");	    
		
		testPeople(arl, p -> p.course < 4);
		System.out.println("---------------");
		                     //statement 
        testPeople(arl, p -> p.name.length() > 3); // Самое короткое написание Lambda expression (только если в методе check() один параметр и если один statement)
		System.out.println("---------------");
        
		// Выборка с помощью Lambda Expressions ( Выбирает все элементы подходящие по данным параметрам )
		testPeople(arl, (p) -> {
        	return p.age > 40 && p.course >5 && p.name.length() >3 && p.grade > 4 && p.sex == 'm';
        	});
		
		System.out.println("---------------");
		
		// Еще один способ записи Lambda expressions
		PeopleCheck pc = p -> p.name.length() > 3; 
		testPeople(arl, pc);
  }
}

interface PeopleCheck{ // Функциональный интерфейс, содержащий 1 абстрактный метод 
	boolean check(People p); // Возвращает метод check(), который принимает в аргумент объект класса People
	// int check2(double p); // Второго абстрактного метода в данном интерфейсе быть не может 
}
