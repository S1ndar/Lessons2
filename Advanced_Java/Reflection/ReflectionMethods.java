package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflectionMethods {
// Это механизм исследования данных о программе во время её выполнения
	// Данные - поля, методы, конструкторы и другие составляющие класса
	public static void main(String[] args)
			throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, SecurityException {
		// Создание объекта класса Class
		Class empClass1 = Class.forName("Reflection.Employee");

		// Class empClass2 = Employee.class;

		// Employee emp = new Employee();
		// Class empClass3 = emp.getClass();

		// getField() - выводит нужное нам поле объекта класса Class (возвращает объект
		// класса Field)
		Field someField = empClass1.getField("id");

		// getType() - выводит тип поля нужного нам
		System.out.println("Type of Id field: " + someField.getType());

		System.out.println("________________________________________________________________________");

		// getFields() - выводит все поля объекта класса Class (возвращает массив Field)
		Field[] fields = empClass1.getFields();
		for (Field field : fields) {
			System.out.println("Type of " + field.getName() + " = " + field.getType());
		} // getName() - выводит имя переменной

		System.out.println("________________________________________________________________________");

		// getDeclaredFields() - выводит ВСЕ поля, даже private (возвращает объект
		// класса Field)
		Field[] AllField = empClass1.getDeclaredFields();
		for (Field field : AllField) {
			System.out.println("Type of " + field.getName() + " = " + field.getType());
		}

		System.out.println("________________________________________________________________________");

		// getMethod() - выводит нужный нам метод объекта класса Class (возвращает
		// объект класса Method)
		// в этом методе нет параметра
		Method someMethod1 = empClass1.getMethod("increaseSalary");

		// getReturnType() - выводит тип метода объекта класса Class
		System.out.println("Return type of method increaseSalary: " + someMethod1.getReturnType()
				+ ", parameter types: " + Arrays.toString(someMethod1.getParameterTypes()));
		// getParameterTypes() - выводит тип параметра метода объекта класса Class
		System.out.println("________________________________________________________________________");

		// тип параметра метода
		Method someMethod2 = empClass1.getMethod("setSalary", double.class);
		System.out.println("Return type of method increaseSalary: " + someMethod2.getReturnType()
				+ ", parameter types: " + Arrays.toString(someMethod2.getParameterTypes()));

		// getMethods() - выводит почти все методы объекта классв Class, даже те методы,
		// унаследованные от Родителей, КРОМЕ private method
		Method[] methods = empClass1.getMethods();
		for (Method method : methods) {
			System.out.println("Name of methods: " + method.getName() + ", type of method: " + method.getReturnType()
					+ ", parameter of method: " + Arrays.toString(method.getParameterTypes()));
		}

		System.out.println("________________________________________________________________________");

		// getDeclaredMethods() - выводит абсолютно все методы, прописанные в классе
		// Employee, не выводя унаследованные методы
		Method[] AllMethods = empClass1.getDeclaredMethods();
		for (Method method : AllMethods) {
			System.out.println("Name of methods: " + method.getName() + ", type of method: " + method.getReturnType()
					+ ", parameter of method: " + Arrays.toString(method.getParameterTypes()));
		}

		System.out.println("________________________________________________________________________");

		// В этом примере выводятся ТОЛЬКО public методы декларированные в классе Employee, потому что мы сделали проверку
		Method[] AllMethods2 = empClass1.getDeclaredMethods();
		for (Method method : AllMethods2) {
			if (Modifier.isPublic(method.getModifiers()))
				System.out
						.println("Name of methods: " + method.getName() + ", type of method: " + method.getReturnType()
								+ ", parameter of method: " + Arrays.toString(method.getParameterTypes()));
		}

		System.out.println("________________________________________________________________________");

		// getConstructor() - выводит конструктор, в параметры принимает параметре конструктора (возвращает объект класса Constructor)
		Constructor c1 = empClass1.getConstructor();
		System.out.println("Constructor has: " + c1.getParameterCount() + ", constructors type: "
				+ Arrays.toString(c1.getParameterTypes()));

		System.out.println("________________________________________________________________________");

		Constructor c2 = empClass1.getConstructor(int.class, int.class, String.class, String.class);
		System.out.println("Constructor has: " + c2.getParameterCount() + ", constructors type: "
				+ Arrays.toString(c2.getParameterTypes()));

		System.out.println("________________________________________________________________________");

		// getConstructors() - выводит все конструкторы (возвращает массив Constructor)
		Constructor[] constructors = empClass1.getConstructors();
		for (Constructor constructor : constructors) {
			System.out.println("Constructor has: " + constructor.getParameterCount() + ", constructors type: "
					+ Arrays.toString(constructor.getParameterTypes()));
		}
		
		System.out.println("________________________________________________________________________");
    
		// getDeclareConstructors() - выводит все задекларированные конструкторы (возвращает массив Constructor)
		Constructor[] Allconstructors = empClass1.getDeclaredConstructors();
		for (Constructor constructor : Allconstructors) {
			System.out.println("Constructor has: " + constructor.getParameterCount() + ", constructors type: "
					+ Arrays.toString(constructor.getParameterTypes()));
		}

		System.out.println("________________________________________________________________________");
        
		// getPackage() - выводит пакет (возвращает объект класса Package)
		Package pkg = empClass1.getPackage();
		System.out.println("Package is: "+pkg);

		System.out.println("________________________________________________________________________");
		
		Class superClass = empClass1.getSuperclass();
		System.out.println("SuperClass is: "+superClass);

		System.out.println("________________________________________________________________________");
        
		Class[] Interface = empClass1.getInterfaces();
		System.err.println("Interfaces are: "+Arrays.toString(Interface));
		
		System.out.println("________________________________________________________________________");
		 
	    
	}

}
