package Reflection;

public class Employee {
	public int id;
	public int age;
    String name;
	private double salary;
	public String department;

	public Employee() {
	}

	public Employee(int i, int a, String n, String d) {
		id = i;
		age = a;
		name = n;
		department = d;
	}

	public Employee(int i, int a, String n, String d, double s) {
		id = i;
		age = a;
		name = n;
		department = d;
		salary = s;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}
	
	private void changeDepartment(String newDepartment) {
		department=newDepartment;
		System.out.println("New department is : "+department);
	}
	
	@Override
	public String toString() {
        return "\nEmployee ("+id+", "+age+", "+name+", "+department+", "+salary+")";
	}
    
	public void increaseSalary() {
		salary*=2;
	}
	
}
