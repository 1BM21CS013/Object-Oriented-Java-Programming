import java.util.Scanner;

class InputScanner {
    Scanner s;
    InputScanner(){s = new Scanner(System.in);}
}

abstract class Shape extends InputScanner{
    double a;
    double b;
    abstract void getInput();
    abstract void displayArea();
}

class Rectangle extends Shape {

    void getInput() {
        System.out.println("Enter the dimensions of the rectangle (length and breadth):");
        a = s.nextDouble();
        b = s.nextDouble();        
    }
    void displayArea() {
        System.out.println("Area of Rectangle = " + (a*b));
    }
}
class Triangle extends Shape {
    
    void getInput() {
        System.out.println("Enter the dimensions of the triangle (base and height):");
        a = s.nextDouble();
        b = s.nextDouble();        
    }
    void displayArea() {
        System.out.println("Area of Triangle = " + (a*b*0.5));
    }
}
class Circle extends Shape {
    
    void getInput() {
        System.out.println("Enter the dimension of the circle (radius):");
        a = s.nextDouble();        
    }
    void displayArea() {
        System.out.println("Area of Circle = " + (3.14*a*a));
    }
}

class Main {
    public static void main (String args[])
    {
        Rectangle r = new Rectangle();
        Triangle t = new Triangle();
        Circle c = new Circle();
        r.getInput();
        t.getInput();
        c.getInput();
        r.displayArea();
        t.displayArea();
        c.displayArea();        
    }
}