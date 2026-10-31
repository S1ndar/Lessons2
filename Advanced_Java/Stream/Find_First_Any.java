package Stream;

import java.util.ArrayList;
import java.util.List;
// Terminal method
public class Find_First_Any {

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
	      
	      
	      // findFirst() - выводит первый нужный элемент ( выводит Optional, поэтому нужен get() )  
	      Human first1 = list.stream().map(e->{ 
	    	 e.setName(e.getName().toUpperCase());
  	    	 return e;
	      }).filter(e->e.getAge()>30)
	        .filter(e->e.getS()=='m')
            .findFirst().get();
	      System.out.println(first1);
	      
	      // findAny() - выводит любой нужный элемент  
	      Human first2 = list.stream().map(e->{ 
		    	 e.setName(e.getName().toUpperCase());
	  	    	 return e;
		      }).filter(e->e.getAge()>30)
		        .filter(e->e.getS()=='m')
	            .findAny().get();
		  System.out.println(first2);
	}

}
