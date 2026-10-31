package Proga;

public class Vehicle1 {
    protected String brand;
    protected int year;

    public Vehicle1(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public void startEngine() {
        System.out.println(brand + " " + year + " - двигатель запущен");
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vehicle1 vehicle1 = (Vehicle1) obj;
        return year == vehicle1.year && brand.equals(vehicle1.brand);
    }

    @Override
    public int hashCode() {
        return 31 * brand.hashCode() + year;
    }

    @Override
    public String toString() {
        return brand + " " + year;
    }
}
