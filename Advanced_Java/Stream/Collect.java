package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Terminal method
public class Collect {
    
	public static void main(String[] args) {
		
	      Human h1 = new Human(20, "bob",'m');
	      Human h2 = new Human(20, "tom",'m');
	      Human h3 = new Human(33, "rick",'m');
	      Human h4 = new Human(33, "ann",'f');
	      Human h5 = new Human(51, "mike",'m');
         	
	      List<Human> list = new ArrayList<Human>();
	      list.add(h1);
	      list.add(h2);
	      list.add(h3);
	      list.add(h4);
	      list.add(h5);
	        
	      //System.out.println(list);
	      
	      // groupingBy() - группирует элементы в разные source по параметрам  
	      Map<Integer, List<Human>> map1 = list.stream().map(e->{
	    	  e.setName(e.getName().toUpperCase());
	          return e;
	      }).                        
	      collect(Collectors.groupingBy(e->e.getAge()));
	      // В коллекции Map ключи - getAge(), а значения - List<Human>
	       
	      // foreach loop for Map
	      for(Map.Entry<Integer,List<Human>> entry : map1.entrySet()) {
	    	  System.out.println(entry.getKey()+": "+ entry.getValue().toString());	    	  
	      }
	      
	      
	      // partitioningBy - группирует элементы в разные source по сравнению 
	      Map<Boolean,List<Human>> map2 = list.stream().map(e->{
	    	  e.setName(e.getName().toUpperCase());
	          return e;
	      }).                        
	      collect(Collectors.partitioningBy(e->e.getS()=='f'));
	      // В коллекции Map ключи - getAge(), а значения - List<Human>
	       
	      // foreach loop for Map
	      for(Map.Entry<Boolean,List<Human>> entry : map2.entrySet()) {
	    	  System.out.println(entry.getKey()+": "+ entry.getValue().toString());	    	  
	      }
	      
	      
	      
	}

}
