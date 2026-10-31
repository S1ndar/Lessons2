package List;

import java.util.ArrayList;
import java.util.List;

/* List может содержать дупликаты и null, каждый элемент имеет индекс
 *                 List
 *  ArrayList     Vector      LinkedList 
 *                Stack
 *          
 *            
 * List : 
 * ArrayList  когда много операций с методом get(), когда мало операций с методами add(), remove()
 * 
 * LinkedList когда часто add() или remove() элементы и когда мало операций с методом get() 
 * 
 * Stack и Vector в очень редких случаях 
 * 
 * НО в основном чаще всего используется ArrayList
 */

public class A_ListInfo {
	public static void main(String[] args) {
		List<String> cars = new ArrayList();  // List
		cars.add("BMW");
		cars.add("Mercedes");
		cars.add("Volkswagen");
		cars.add("Volvo");		
		
		for (String string : cars) {
			System.out.println(string);
		}	    		
	}
}


