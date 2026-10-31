package Reflection;

import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionMethods2 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
	                       NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
        Class empClass = Class.forName("Reflection.Employee");
        
        // Устаревший метод создания объекта 
        // Employee o = (Employee)empClass.newInstance();
	    // System.out.println(o);
	    
        Constructor<Employee> constructor = empClass.getConstructor();
        
        // newInstance() - позволяет создавать объект, возвращает Object
	    Object o1 = constructor.newInstance();
	    
	    Constructor constructor2 = empClass.getConstructor(int.class, int.class, String.class, String.class);
	    Object o2 = constructor2.newInstance(5,25,"Mike","KFC");
	    System.out.println(o2);
	    
	    Method method = empClass.getMethod("setSalary", double.class);
	    // Вызов метода на классе o2, в аргументы принимает класс на котором вызываем метод и параметр поля
	    method.invoke(o2,8888.8);
	    System.out.println(o2);
	    
	    // ОБХОД ПРИНЦИПА ИНКАПСУЛЯЦИИ
	    // Вывод приватного поля
	    PrivateEmp emp = new PrivateEmp(2134,25,"Rick","MIT");
        Class empClass2 = emp.getClass();
        Field field = empClass2.getDeclaredField("salary");
        
        // setAccessible() - дает доступ к выводу private field
        field.setAccessible(true);
      
        // get() - вывод, возвращает Object 
        double salaryValue = (Double) field.get(emp);
        System.out.println(salaryValue);
	    
        // set() - задает новое значение классу emp
        field.set(emp,3000);
        
        	
	
	 
	}

}
