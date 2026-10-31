package Reflection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CalculatorTest {

	public static void main(String[] args) throws IOException, NumberFormatException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	      BufferedReader reader = new BufferedReader(new FileReader("Test3"));
		   // Имя метода : sum, subtraction, multiplication, devision
		   String methodName = reader.readLine();
		   
		   String firstArg = reader.readLine();
		   String secondArg = reader.readLine();
		   
		   Calculator calc = new Calculator();
		   Class c  = calc.getClass();
		   reader.close();// Закрываем поток
		   // Метод к которому мы потом присвоим значение нужного метода 
		   Method method = null;
		   
		   // Получаем все методы 
		   Method[] methods = c.getDeclaredMethods();
           for(Method m :methods) {
        	   // если Имя введенного метода совпадает с нужным методом, то они равны 
        	   if(m.getName().equals(methodName)) {
        		   method = m;
        	   }
           }
           // Вызов метода
           method.invoke(calc, Integer.parseInt(firstArg),Integer.parseInt(secondArg));
	   
	   
			   
	}
}
