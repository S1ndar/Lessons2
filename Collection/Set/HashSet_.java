package Set;

import java.util.HashSet;
import java.util.Set;

public class HashSet_ { // HashSet похож на HashMap, НО у него нету метода get()
// Set - множество 
	public static void main(String[] args) {
		
		Set<String> hs = new HashSet<>();
		hs.add("Bob"); // В этом случае метод add() внутренне вызывает метод put()
		hs.add("Tom");
		hs.add("Ann");
		hs.add("Ann"); // HashSet не может содержать дубликат
		System.out.println(hs);
		
		for (String string : hs) {
			System.out.println(string);
		}
		// remove()
        hs.remove("Tom");
        System.out.println(hs);
        
        // size()
        System.out.println(hs.size());
        
        // isEmpty()
        System.out.println(hs.isEmpty());
        
        // contains()
        System.err.println(hs.contains("Ann"));
        
        HashSet<Integer> hs2 = new HashSet<>();
        hs2.add(1);
        hs2.add(2);
        hs2.add(3);
   
        
        HashSet<Integer> hs3 = new HashSet<>();
        hs3.add(1);
        hs3.add(5);
        hs3.add(6);
        
        // union - объединение двух множеств
        HashSet<Integer> union = new HashSet<>(hs2);
        union.addAll(hs3); 
        System.out.println(union);
        
        // intersect - вывод пересечения (общих элементов) двух множеств 
        HashSet<Integer> intersect = new HashSet<>(hs2);
        intersect.retainAll(hs3);
        System.out.println(intersect);
        
        // substact - разность двух множеств (множество элементов, которые есть в одном set, но нет в другом)
        HashSet<Integer> subtract = new HashSet<>(hs2);
        subtract.removeAll(hs3); // Удали все элементы hs3, в hs2
        System.out.println(subtract);


        String I = "Утро было тихое утро над рекой туман медленно полз вдаль";
        //String[] t = I.split();
        HashSet <String> hst = new HashSet<>();

	} 

}
