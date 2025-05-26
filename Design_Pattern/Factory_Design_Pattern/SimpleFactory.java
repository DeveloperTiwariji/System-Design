//<==========================Simple Factory==========================>
//<==========================A Simple Factory is a class that creates objects based on the input parameter.==========================>

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

class BurgerFactory {
    public static Burger createBurger(String type) {
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

public class SimpleFactory {
    public static void main(String[] args) {
        Burger basicBurger = BurgerFactory.createBurger("basic");
        basicBurger.prepare();

        Burger standardBurger = BurgerFactory.createBurger("standard");
        standardBurger.prepare();

        Burger premiumBurger = BurgerFactory.createBurger("premium");
        premiumBurger.prepare();
        
        // Uncommenting the following line will throw an exception
        // Burger unknownBurger = BurgerFactory.createBurger("unknown");
    }
}
