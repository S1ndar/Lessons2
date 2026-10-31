package Reflection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CalctulatorTestWithOutReflection {

	public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Test3"));
        String nameMethod = reader.readLine();
        String firstValue = reader.readLine();
        String secondValue = reader.readLine();
        Calculator calc = new Calculator();
        reader.close();// Закрываем поток
        
        switch(nameMethod){
        case"sum":
             calc.sum(Integer.parseInt(firstValue), Integer.parseInt(secondValue));
             break;
        
        case"subtraction":
        	 calc.subtraction(Integer.parseInt(firstValue), Integer.parseInt(secondValue));
             break;
             
        case"multiplication":
             calc.multiplication(Integer.parseInt(firstValue), Integer.parseInt(secondValue));
             break;
        
        case"division":
            calc.division(Integer.parseInt(firstValue), Integer.parseInt(secondValue));
            break;
        	
        }	
	}

}
