//<==========================Strategy Design Pattern==========================>
// Strategy Design Pattern Example in Java

interface Talkable {
    void talk();
}

interface Walkable {
    void walk();
}

interface Flyable {
    void fly();
}

// Concrete implementation of Talkable
class Dog implements Talkable {
    @Override
    public void talk() {
        System.out.println("Woof! Woof!");
    }
}

// Concrete implementation of Walkable
class Cat implements Walkable {
    @Override
    public void walk() {
        System.out.println("The cat walks gracefully.");
    }
}

// Concrete implementation of Flyable
class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("The bird soars through the sky.");
    }
}
// Context class that uses the strategies
class Animal {
    private Talkable talkable;
    private Walkable walkable;
    private Flyable flyable;

    public Animal(Talkable talkable, Walkable walkable, Flyable flyable) {
        this.talkable = talkable;
        this.walkable = walkable;
        this.flyable = flyable;
    }

    public void performTalk() {
        talkable.talk();
    }

    public void performWalk() {
        walkable.walk();
    }

    public void performFly() {
        flyable.fly();
    }
}

// Main class to demonstrate the Strategy Design Pattern
public class StrategyDesignPattern {
    public static void main(String[] args) {
        // Create instances of concrete strategies
        Talkable dog = new Dog();
        Walkable cat = new Cat();
        Flyable bird = new Bird();

        // Create an Animal context with the strategies
        Animal animal = new Animal(dog, cat, bird);

        // Perform actions using the strategies
        animal.performTalk(); // Output: Woof! Woof!
        animal.performWalk(); // Output: The cat walks gracefully.
        animal.performFly();  // Output: The bird soars through the sky.
    }
}
