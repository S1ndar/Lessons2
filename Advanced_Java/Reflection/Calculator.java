package Reflection;

// Пример использования reflection (когда без reflection нельзя)
public class Calculator {
    
	 void sum(int a, int b) {
		int result = a + b;
		System.out.println("Сумма " + a + " и " + b + " = " + result);
	}

	 void subtraction(int a, int b) {
		int result = a - b;
		System.out.println("Разность " + a + " и " + b + " = " + result);
	}

	 void multiplication(int a, int b) {
		int result = a * b;
		System.out.println("Произведение " + a + " и " + b + " = " + result);
	}

	 void division(int a, int b) {
		int result = a / b;
		System.out.println("Деление " + a + " и " + b + " = " + result);
	}
	
}

