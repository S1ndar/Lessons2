package Stream;

import java.util.ArrayList;
import java.util.List;
// Terminal methods
public class Min_Max {
// В аргументы принимают Comparator 
	public static void main(String[] args) {
	      Human h1 = new Human(20, "bob",'m');
	      Human h2 = new Human(24, "tom",'m');
	      Human h3 = new Human(33, "rick",'m');
	      Human h4 = new Human(32, "ann",'f');
	      Human h5 = new Human(51, "mike",'m');
       	
	      List<Human> list = new ArrayList<Human>();
	      list.add(h1);
	      list.add(h2);
	      list.add(h3);
	      list.add(h4);
	      list.add(h5);
	        
	      System.out.println(list);
	      
	      // min 
	      Human min = list.stream().min((x,y)->x.getAge()-y.getAge()).get();
	      System.out.println(min);
	      
	      // max
	      Human max = list.stream().max((x,y)->x.getAge()-y.getAge()).get();
	      System.out.println(max);

	}

}
