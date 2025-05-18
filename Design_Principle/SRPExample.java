import java.util.ArrayList;
import java.util.List;

//<==========Single Responsibility Principle==========>
// The Single Responsibility Principle (SRP) states that a class should have only one reason to change.
// In other words, a class should have only one job or responsibility.

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private List<Product> products;
    private double totalPrice;

    public Order() {
        this.products = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public void addProduct(Product product) {
        products.add(product);
        totalPrice += product.getPrice();
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

class OrderPrinter {
    public void printOrder(Order order) {
        System.out.println("Order Summary:");
        for (Product product : order.getProducts()) {
            System.out.println("- " + product.getName() + ": $" + product.getPrice());
        }
        System.out.println("Total Price: $" + order.getTotalPrice());
    }
}

public class SRPExample {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 1200.00);
        Product product2 = new Product("Smartphone", 800.00);

        Order order = new Order();
        order.addProduct(product1);
        order.addProduct(product2);

        OrderPrinter orderPrinter = new OrderPrinter();
        orderPrinter.printOrder(order);
    }
}
