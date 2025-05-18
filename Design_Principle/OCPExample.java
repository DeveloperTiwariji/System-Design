//<=============Open Closed Principle==================>
//         // The Open/Closed Principle (OCP) states that class should be open for extension but closed for modification.
import java.util.*;

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

interface PersistenceStrategy {
    void save(Order order);
}

class DatabasePersistence implements PersistenceStrategy {
    @Override
    public void save(Order order) {
        // Code to save order to a database
        System.out.println("Order saved to database.");
    }
}

class FilePersistence implements PersistenceStrategy {
    @Override
    public void save(Order order) {
        // Code to save order to a file
        System.out.println("Order saved to file.");
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

class OrderManager {
    private PersistenceStrategy persistenceStrategy;

    public OrderManager(PersistenceStrategy persistenceStrategy) {
        this.persistenceStrategy = persistenceStrategy;
    }

    public void saveOrder(Order order) {
        persistenceStrategy.save(order);
    }
}

public class OCPExample {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 1200.00);
        Product product2 = new Product("Smartphone", 800.00);

        Order order = new Order();
        order.addProduct(product1);
        order.addProduct(product2);

        OrderPrinter orderPrinter = new OrderPrinter();
        orderPrinter.printOrder(order);

        // Using Database Persistence
        OrderManager orderManager = new OrderManager(new DatabasePersistence());
        orderManager.saveOrder(order);

        // Using File Persistence
        orderManager = new OrderManager(new FilePersistence());
        orderManager.saveOrder(order);
    }
}

