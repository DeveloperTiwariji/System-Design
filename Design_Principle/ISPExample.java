//<======================Interface Segregation Principle=======================>
// <=======================Clients should not be forced to depend on interfaces they do not use===================>

interface twoDimensionalShape {
    void area();
}

interface threeDimensionalShape {
    void area();
    void volume();
}

class Circle implements twoDimensionalShape {
    @Override
    public void area() {
        System.out.println("Area of Circle");
    }
}

class Square implements twoDimensionalShape {
    @Override
    public void area() {
        System.out.println("Area of Square");
    }
}

class Cube implements threeDimensionalShape {
    @Override
    public void area() {
        System.out.println("Area of Cube");
    }

    @Override
    public void volume() {
        System.out.println("Volume of Cube");
    }
}

class Sphere implements threeDimensionalShape {
    @Override
    public void area() {
        System.out.println("Area of Sphere");
    }

    @Override
    public void volume() {
        System.out.println("Volume of Sphere");
    }
}

public class ISPExample {
    public static void main(String[] args) {
        twoDimensionalShape circle = new Circle();
        circle.area();

        twoDimensionalShape square = new Square();
        square.area();

        threeDimensionalShape cube = new Cube();
        cube.area();
        cube.volume();

        threeDimensionalShape sphere = new Sphere();
        sphere.area();
        sphere.volume();
    }
}