package Proga;

import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
    protected String brand;
    protected int year;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public abstract void startEngine();
    public abstract void stopEngine();

    public void honk() {
        System.out.println(brand + ": Сигнал!");
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }
}

class Car extends Vehicle {
    public Car(String brand, int year) {
        super(brand, year);
    }

    @Override
    public void startEngine() {
        System.out.println("Автомобиль " + brand + " " + year + ": Двигатель запущен.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Автомобиль " + brand + " " + year + ": Двигатель остановлен.");
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String brand, int year) {
        super(brand, year);
    }

    @Override
    public void startEngine() {
        System.out.println("Мотоцикл " + brand + " " + year + ": Двигатель запущен. Др-др-др!");
    }

    @Override
    public void stopEngine() {
        System.out.println("Мотоцикл " + brand + " " + year + ": Двигатель остановлен.");
    }
}

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

interface Runnable {
    void run();
}

class Duck implements Flyable, Swimmable, Runnable {
    private String name;

    public Duck(String name) {
        this.name = name;
    }

    @Override
    public void fly() {
        System.out.println("Утка " + name + " летит");
    }

    @Override
    public void swim() {
        System.out.println("Утка " + name + " плывёт");
    }

    @Override
    public void run() {
        System.out.println("Утка " + name + " бежит");
    }
}

class Fish implements Swimmable {
    private String name;

    public Fish(String name) {
        this.name = name;
    }

    @Override
    public void swim() {
        System.out.println("Рыба " + name + " плывёт");
    }
}

class Eagle implements Flyable {
    private String name;

    public Eagle(String name) {
        this.name = name;
    }

    @Override
    public void fly() {
        System.out.println("Орёл " + name + " летит высоко в небе");
    }
}

class Dog implements Runnable, Swimmable {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Собака " + name + " бежит");
    }

    @Override
    public void swim() {
        System.out.println("Собака " + name + " плывёт");
    }
}

public class Task7 {
    public static void main(String[] args) {
        System.out.println("Транспорт");
        Vehicle[] vehicles = {
                new Car("Toyota", 2022),
                new Motorcycle("Harley-Davidson", 2021),
                new Car("BMW", 2023),
                new Motorcycle("Yamaha", 2020)
        };

        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
            vehicle.honk();
            vehicle.stopEngine();
            System.out.println();
        }

        System.out.println("Животные");
        List<Object> animals = new ArrayList<>();
        animals.add(new Duck("Дональд"));
        animals.add(new Fish("Немо"));
        animals.add(new Eagle("Скай"));
        animals.add(new Dog("Газан"));


        for (Object animal : animals) {
            System.out.println("Объект: " + animal.getClass().getSimpleName());

            if (animal instanceof Flyable) {
                ((Flyable) animal).fly();
            }
            if (animal instanceof Swimmable) {
                ((Swimmable) animal).swim();
            }
            if (animal instanceof Runnable) {
                ((Runnable) animal).run();
            }
        }
    }
}
