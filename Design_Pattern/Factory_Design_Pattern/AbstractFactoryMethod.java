//<===================================Abstract Factory Method==================================>
//<===================================An Abstract Factory Method is an interface that defines a method for creating families of related or dependent objects without specifying their concrete classes.==========================>

interface Burger {
    void prepareBurger();
}

class BasicBurger implements Burger {
    public void prepareBurger() {
        System.out.println("Preparing a Basic Burger.");
    }
}

class StandardBurger implements Burger {
    public void prepareBurger() {
        System.out.println("Preparing a Standard Burger with lettuce and tomato.");
    }
}

class PremiumBurger implements Burger {
    public void prepareBurger() {
        System.out.println("Preparing a Premium Burger with cheese, bacon, and avocado.");
    }
}

class BasicWheatBurger implements Burger {
    public void prepareBurger() {
        System.out.println("Preparing a Basic Wheat Burger.");
    }
}

class StandardWheatBurger implements Burger {
    public void prepareBurger() {
        System.out.println("Preparing a Standard Wheat Burger with lettuce and tomato.");
    }
}

class PremiumWheatBurger implements Burger {
    public void prepareBurger() {
        System.out.println("Preparing a Premium Wheat Burger with cheese, bacon, and avocado.");
    }
}

interface GarlicBurger {
    void prepareGarlicBurger();
}

class BasicGarlicBurger implements GarlicBurger {
    public void prepareGarlicBurger() {
        System.out.println("Preparing a Basic Garlic Burger.");
    }
}

class StandardGarlicBurger implements GarlicBurger {
    public void prepareGarlicBurger() {
        System.out.println("Preparing a Standard Garlic Burger with garlic sauce.");
    }
}

class PremiumGarlicBurger implements GarlicBurger {
    public void prepareGarlicBurger() {
        System.out.println("Preparing a Premium Garlic Burger with garlic sauce and cheese.");
    }
}

// Abstract Factory
abstract class BurgerFactory {
    public abstract Burger createBurger();
    public abstract GarlicBurger createGarlicBurger();
}

// Concrete Factory: Singh
class SinghBurgerFactory extends BurgerFactory {
    private String burgerType;
    private String garlicBurgerType;

    public SinghBurgerFactory(String burgerType, String garlicBurgerType) {
        this.burgerType = burgerType;
        this.garlicBurgerType = garlicBurgerType;
    }

    public Burger createBurger() {
        switch (burgerType.toLowerCase()) {
            case "basic":
                return new BasicBurger();
            case "standard":
                return new StandardBurger();
            case "premium":
                return new PremiumBurger();
            case "basicwheat":
                return new BasicWheatBurger();
            case "standardwheat":
                return new StandardWheatBurger();
            case "premiumwheat":
                return new PremiumWheatBurger();
            default:
                throw new IllegalArgumentException("Unknown burger type: " + burgerType);
        }
    }

    public GarlicBurger createGarlicBurger() {
        switch (garlicBurgerType.toLowerCase()) {
            case "basicgarlic":
                return new BasicGarlicBurger();
            case "standardgarlic":
                return new StandardGarlicBurger();
            case "premiumgarlic":
                return new PremiumGarlicBurger();
            default:
                throw new IllegalArgumentException("Unknown garlic burger type: " + garlicBurgerType);
        }
    }
}

// Concrete Factory: King
class KingBurgerFactory extends BurgerFactory {
    private String burgerType;
    private String garlicBurgerType;

    public KingBurgerFactory(String burgerType, String garlicBurgerType) {
        this.burgerType = burgerType;
        this.garlicBurgerType = garlicBurgerType;
    }

    public Burger createBurger() {
        switch (burgerType.toLowerCase()) {
            case "basic":
                return new BasicBurger();
            case "standard":
                return new StandardBurger();
            case "premium":
                return new PremiumBurger();
            case "basicwheat":
                return new BasicWheatBurger();
            case "standardwheat":
                return new StandardWheatBurger();
            case "premiumwheat":
                return new PremiumWheatBurger();
            default:
                throw new IllegalArgumentException("Unknown burger type: " + burgerType);
        }
    }

    public GarlicBurger createGarlicBurger() {
        switch (garlicBurgerType.toLowerCase()) {
            case "basicgarlic":
                return new BasicGarlicBurger();
            case "standardgarlic":
                return new StandardGarlicBurger();
            case "premiumgarlic":
                return new PremiumGarlicBurger();
            default:
                throw new IllegalArgumentException("Unknown garlic burger type: " + garlicBurgerType);
        }
    }
}

// Client
public class AbstractFactoryMethod {
    public static void main(String[] args) {
        // Singh Factory - Premium Burger + Premium Garlic
        BurgerFactory singhFactory = new SinghBurgerFactory("premium", "premiumgarlic");
        Burger singhBurger = singhFactory.createBurger();
        singhBurger.prepareBurger();
        GarlicBurger singhGarlicBurger = singhFactory.createGarlicBurger();
        singhGarlicBurger.prepareGarlicBurger();

        // King Factory - Standard Burger + Standard Garlic
        BurgerFactory kingFactory = new KingBurgerFactory("standard", "standardgarlic");
        Burger kingBurger = kingFactory.createBurger();
        kingBurger.prepareBurger();
        GarlicBurger kingGarlicBurger = kingFactory.createGarlicBurger();
        kingGarlicBurger.prepareGarlicBurger();
    }
}

