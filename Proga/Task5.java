package Proga;
import java.util.ArrayList;
import java.util.List;

public class Task5{
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Student student1 = new Student("Анна", 20, 4.8);
        Student student2 = new Student("Иван", 22, 4.2);
        Student student3 = new Student("Мария", 19, 4.9);
        Student student4 = new Student("Пётр", 21, 3.7);


        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        for (Student student : students) {
            System.out.println(student);
            System.out.println("Отличник: " + (student.isExcellent() ? "Да" : "Нет"));
            System.out.println("---");
        }

        System.out.println("\nПроверка возраста:");
        Student testStudent = new Student("ТестВозраста", 25, 4.0);

        System.out.println(testStudent.getAge());
        testStudent.setAge(30);
        System.out.println(testStudent.getAge());
        testStudent.setAge(-5);
        System.out.println(testStudent.getAge());
    }

    public static class Student {
        private String name;
        private int age;
        private double averageGrade;

        public Student(String name, int age, double averageGrade) {
            this.name = name;
            setAge(age);
            this.averageGrade = averageGrade;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            if (age > 0) {
                this.age = age;
            } else {
                System.out.println("Возраст должен быть положительным");
                this.age = 6767;
            }
        }

        public double getAverageGrade() {
            return averageGrade;
        }

        public void setAverageGrade(double averageGrade) {
            this.averageGrade = averageGrade;
        }

        public boolean isExcellent() {
            return averageGrade >= 4.5;
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', age=" + age + ", averageGrade=" + averageGrade +
                    ", excellent=" + isExcellent() + "}";
        }
    }
}