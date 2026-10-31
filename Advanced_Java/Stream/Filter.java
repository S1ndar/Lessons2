package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
// Intermediate method
public class Filter {
// Фильтрует данные из коллекции или массива
	public static void main(String[] args) {
		Student s1 = new Student("Bob",20,3,4.4); 
		Student s2 = new Student("Tom",20,5,3.4); 
		Student s3 = new Student("Ann",25,8,5.0); 
		Student s4 = new Student("Rick",18,2,5.0); 
		Student s5 = new Student("Wick",31,14,4.9); 
		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		System.out.println(list);
		
		// Первый вариант записи (через List и метод stream() 
		List<Student> list2 = list.stream().filter(e -> e.getAge() > 20 && e.getGrade() > 4 && e.getCourse() > 8).collect(Collectors.toList());
		System.out.println(list2);
		
		// Второй вариант записи(через интерфейс Stream, метод stream() и List уже не нужны) 
		Stream<Student> myStm = Stream.of(s1,s2,s3,s4,s5);
		List<Student> list3 = myStm.filter(e -> e.getAge() > 20 && e.getGrade() > 4 && e.getCourse() > 8).collect(Collectors.toList());
        System.out.println(list3);	
        
        // sorted() 
        list = list.stream().sorted().collect(Collectors.toList());
        System.out.println(list);
        
	}

}


class Student implements Comparable<Student>{
	private String name;
	private int age;
	private int course;
	private double grade;
	public Student(String n, int a, int c, double g) {
		name = n;
		age = a;
		course = c;
		grade = g;
	}
	
	@Override
	public String toString() {
         return "Student("+name+", "+age+", "+course+", "+grade+")";
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setCourse(int course) {
		this.course = course;
	}
	public int getCourse() {
		return course;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public double getGrade() {
		return grade;
	}

	@Override
	public int compareTo(Student o) {
		int res = this.age - o.age;
		if(res == 0) {
			res = this.course - o.course;
		}
		return res;
	}
	
}