package Proga;

class Car1 extends Vehicle1 {
    private int numberOfDoors;

    public Car1(String brand, int year, int numberOfDoors) {
        super(brand, year);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void startEngine() {
        System.out.println("Автомобиль " + brand + " " + year + " года с " + numberOfDoors +
                " дверями: Двигатель запущен.");
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }
}

class Motorcycle1 extends Vehicle1 {
    private boolean hasSidecar;

    public Motorcycle1(String brand, int year, boolean hasSidecar) {
        super(brand, year);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void startEngine() {
        String sidecarInfo = hasSidecar ? "с коляской" : "без коляски";
        System.out.println("Мотоцикл " + brand + " " + year + " года " + sidecarInfo +
                ": Двигатель запущен.");
    }

    public boolean hasSidecar() {
        return hasSidecar;
    }
}

class Task6 {
    public static void main(String[] args) {
        Vehicle1[] vehicle1s = new Vehicle1[4];

        vehicle1s[0] = new Car1("Toyota", 2020, 4);
        vehicle1s[1] = new Motorcycle1("Harley-Davidson", 2019, false);
        vehicle1s[2] = new Car1("BMW", 2022, 2);
        vehicle1s[3] = new Motorcycle1("Ural", 2021, true);

        System.out.println("Запуск двигателей всех транспортных средств:");


        for (Vehicle1 vehicle1 : vehicle1s) {
            vehicle1.startEngine();
        }

        System.out.println("\nПроверка equals():");
        Vehicle1 v1 = new Vehicle1("Toyota", 2020);
        Vehicle1 v2 = new Vehicle1("Toyota", 2020);
        Vehicle1 v3 = new Vehicle1("Honda", 2020);

        System.out.println("v1 - v2: " + v1.equals(v2));
        System.out.println("v1 - v3: " + v1.equals(v3));

    }
}

