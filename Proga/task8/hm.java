package Proga.task8;

import java.util.ArrayList;
import java.util.List;


class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) { super(message); }
}

class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) { super(message); }
}

class InvalidOrderException extends RuntimeException {
    public InvalidOrderException(String message) { super(message); }
}


class Product {
    String name;
    double price;
    int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void reduceStock(int quantity) {
        this.stock -= quantity;
    }
}


class Order {
    private List<Product> products = new ArrayList<>();
    private List<Integer> quantities = new ArrayList<>();

    public void addProduct(Product product, int quantity)
            throws ProductNotFoundException, InsufficientStockException {

        if (product == null) {
            throw new ProductNotFoundException("Продукт не найден");
        }
        if (quantity <= 0) {
            throw new InvalidOrderException("Количество должно быть больше 0");
        }
        if (product.stock < quantity) {
            throw new InsufficientStockException("Недостаточно товара на складе. Доступно: " + product.stock);
        }

        products.add(product);
        quantities.add(quantity);
        product.reduceStock(quantity);
        System.out.println("Добавлен продукт: " + product.name + ", кол-во: " + quantity);
    }

    public void printOrder() {
        System.out.println("Заказ");
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.println(p.name + " x" + quantities.get(i) + " = " + (p.price * quantities.get(i)) + " руб.");
        }
    }
}

public class hm {
    public static void main(String[] args) {
        Product apple = new Product("Яблоко", 50, 10);
        Product banana = new Product("Банан", 30, 5);
        Product orange = new Product("Апельсин", 70, 0);

        Order order = new Order();


        try {
            order.addProduct(apple, 3);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }


        try {
            order.addProduct(banana, 10);
        } catch (InsufficientStockException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Другая ошибка: " + e.getMessage());
        }

        try {
            order.addProduct(null, 1);
        } catch (ProductNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Другая ошибка: " + e.getMessage());
        }

        try {
            order.addProduct(banana, -2);
        } catch (InvalidOrderException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Другая ошибка: " + e.getMessage());
        }

        try {
            order.addProduct(orange, 1);
        } catch (InsufficientStockException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Другая ошибка: " + e.getMessage());
        }


        order.printOrder();
    }
}
