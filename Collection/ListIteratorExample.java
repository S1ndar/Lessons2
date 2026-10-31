import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {

	public static void main(String[] args) {
		String s = "madam";
		List<Character> list = new LinkedList<Character>();
		for (char ch: s.toCharArray()) { // toCharArray() разбивает строку на элементы (Из String в Char)
			 list.add(ch);  // Каждый элемент строки s, добавляется в list
		}
		System.out.println(list);
		
		// ListIterator - повторитель для LinkedList
		ListIterator<Character> iter = list.listIterator(); // с начала list 
		ListIterator<Character> rIter = list.listIterator(list.size()); // с конца list
		boolean isPalindrome = true; // Палиндром это когда слово с конца и с начала читается одинаково(пример мадам, лол)
		while(iter.hasNext() && rIter.hasPrevious()) { // hasPreious() проверяет есть ли предыдущий символ
			if(iter.next() != rIter.previous()) {
				isPalindrome = false;
				break;
			}											
		}
		if(isPalindrome) {
			System.out.println("The word "+s+" is Palindrome");
		}
		else {
			System.out.println("The word "+s+" is not Palindrome");
		}
        
	}

}
