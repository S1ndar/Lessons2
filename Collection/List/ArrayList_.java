package List;
import java.util.ArrayList;
import java.util.List;

public class ArrayList_ {
	public static void main(String[] args) {
		Object g = new Object();
		int f = 0;   
		
		//ArrayList - динамический массив, который содержит в себе только объекты класса Object (без примитивных данных)
		List<String> arl1 = new ArrayList();
		arl1.add("Tom");
		arl1.add("Bob");
		arl1.add("John");
		System.out.println(arl1);
		
		//ArrayList без generic (В массив  можно добавить любые типы, объекты переменных)
		ArrayList arl2 = new ArrayList(200); // Максимум 200 объектов
		arl2.add("Ivan");
		arl2.add(f);
		arl2.add(g);
		
	    List<Object> arl3 = new ArrayList(arl1); // arl3 ссылается на arl1
	    System.out.println(arl3);
	}

}
