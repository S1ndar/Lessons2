package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
// Intermediate method
public class Sorted { // Сортировка потока (stream) 

	public static void main(String[] args) {
       int [] arr = {12,4,123,96,2,5,10};
       arr = Arrays.stream(arr).sorted().toArray();
       System.out.println(Arrays.toString(arr));
       System.out.println("_______________________");
       
       
       Iphone i1 = new Iphone(11, "Pro");
       Iphone i2 = new Iphone(11, "Pro max");
       Iphone i3 = new Iphone(13, "Pro");
       Iphone i4 = new Iphone(13, "Pro max");
       Iphone i5 = new Iphone(15, "Pro");
       Iphone i6 = new Iphone(15, "Pro max");
       
       List<Iphone> list = new ArrayList<Iphone>();
       list.add(i6);
       list.add(i1);
       list.add(i3);
       list.add(i5);
       list.add(i2);
       list.add(i4);
       
       
       System.out.println("Before sorting "+list);
       System.out.println("_______________________");
       list = list.stream().sorted().collect(Collectors.toList());
       System.out.println("After sorting Comparator"+list);
       System.out.println("_______________________");
       
       // Lambda - разницы между Comparable и Comparator НЕТ 
       list = list.stream().sorted((x,y) -> { 
    	    int res = x.id()-y.id();
            if(res==0) {
               res = x.name().compareTo(y.name());
            }
            return res;
       }).collect(Collectors.toList());
       System.out.println("After sorting Lambda"+list);
	}

}
// Comparable
record Iphone (int id, String name) implements Comparable<Iphone>{
    
	@Override
	public int compareTo(Iphone o) {
		int res = this.id-o.id;
		if(res==0) {
			res = this.name.compareTo(o.name);
		}
		return res;
	}
	
    public String toString() {
    	return "\nIphone "+id+" "+name;
    }
	
}
