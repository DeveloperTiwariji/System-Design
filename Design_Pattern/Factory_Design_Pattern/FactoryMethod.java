//<=========================Factory Method==========================>
//<=========================A Factory Method is an interface that defines a method for creating objects, but allows subclasses to alter the type of objects that will be created.==========================>

interface Burger {
    void prepare();
}

class BasicBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing a Basic Burger.");
    }
}

class StandardBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing a Standard Burger with lettuce and tomato.");
    }
}

class PremiumBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing a Premium Burger with cheese, bacon, and avocado.");
    }
}

class BasicWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing a Basic Wheat Burger.");
    }
}

class StandardWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing a Standard Wheat Burger with lettuce and tomato.");
    }
}

class PremiumWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing a Premium Wheat Burger with cheese, bacon, and avocado.");
    }
}

abstract class BurgerFactory {
    public abstract Burger createBurger();
}

class SinghBurgerFactory extends BurgerFactory {
    private String type;

    public SinghBurgerFactory(String type) {
        this.type = type;
    }

    @Override
    public Burger createBurger() {
        switch (type.toLowerCase()) {
            case "basic":
                return new BasicBurger();
            case "standard":
                return new StandardBurger();
            case "premium":
                return new PremiumBurger();
            default:
                throw new IllegalArgumentException("Unknown burger type: " + type);
        }
    }
}

class KingBurgerFactory extends BurgerFactory {
    private String type;

    public KingBurgerFactory(String type) {
        this.type = type;
    }

    @Override
    public Burger createBurger() {
        switch (type.toLowerCase()) {
            case "basic":
                return new BasicWheatBurger();
            case "standard":
                return new StandardWheatBurger();
            case "premium":
                return new PremiumWheatBurger();
            default:
                throw new IllegalArgumentException("Unknown burger type: " + type);
        }
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        BurgerFactory singhFactory = new SinghBurgerFactory("premium");
        Burger singhBurger = singhFactory.createBurger();
        singhBurger.prepare();

        BurgerFactory kingFactory = new KingBurgerFactory("standard");
        Burger kingBurger = kingFactory.createBurger();
        kingBurger.prepare();
        
        // Uncommenting the following line will throw an exception
        // Burger unknownBurger = singhFactory.createBurger("unknown");
    }
}

