package Proga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class Employee implements Comparable<Employee>, Workable {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.calculateSalary(), other.calculateSalary());
    }

    @Override
    public String toString() {
        return String.format("%s: %s (базовая: %.2f, итоговая: %.2f)",
                getClass().getSimpleName(), name, baseSalary, calculateSalary());
    }
}

interface Workable {
    void work();
}

class Manager extends Employee {
    public Manager(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary + 1000;
    }

    @Override
    public void work() {
        System.out.println("Менеджер " + name + " управляет командой и планирует задачи");
    }
}

class Developer extends Employee {
    public Developer(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary + 500;
    }

    @Override
    public void work() {
        System.out.println("Разработчик " + name + " пишет код и исправляет баги");
    }
}

class Intern extends Employee {
    public Intern(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary * 0.8;
    }

    @Override
    public void work() {
        System.out.println("Стажёр " + name + " учится и выполняет простые задачи");
    }
}

public class Task8 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Manager("Анна", 5000));
        employees.add(new Developer("Иван", 4000));
        employees.add(new Intern("Пётр", 2000));
        employees.add(new Manager("Ольга", 5500));
        employees.add(new Developer("Максим", 4200));
        employees.add(new Intern("Елена", 1800));

        System.out.println("Все сотрудники");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        System.out.println("\nРабочие процессы");
        for (Employee emp : employees) {
            emp.work();
        }

        Collections.sort(employees);

        System.out.println("\nСотрудники после сортировки по зарплате");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        System.out.println("\nСтатистика");
        double totalSalary = 0;
        Employee minSalary = employees.get(0);
        Employee maxSalary = employees.get(employees.size() - 1);

        for (Employee emp : employees) {
            totalSalary += emp.calculateSalary();
        }

        System.out.printf("Общая зарплата всех сотрудников: %.2f\n", totalSalary);
        System.out.printf("Средняя зарплата: %.2f\n", totalSalary / employees.size());
        System.out.println("Минимальная зарплата у: " + minSalary);
        System.out.println("Максимальная зарплата у: " + maxSalary);
    }
}