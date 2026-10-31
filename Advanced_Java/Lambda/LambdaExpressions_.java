package Lambda;

public class LambdaExpressions_ {
    static void def(I i) { // Принимает в аргументы объект интерфейса I
    	System.out.println(i.abc("Hello")); // Мы используем абстрактный метод abc() у объекта интерфейса I 
    }
    
    public static void main(String[] args) {
    	final int i = 10; // Эта переменная прекрасно видна внутри выражения, НО она должна быть final
    	
	    // Lambda expression
    	def((String str) -> {
            System.out.println(i);    		
    		return str.length() + i;
    	});
    	//System.out.println(str); Вот так делать нельзя str виден только в пределах lambda expression
	}
}

interface I{ // Функциональный интерфейс
	int abc(String s);
}
