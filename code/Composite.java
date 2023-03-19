package code;

import java.util.ArrayList;
import java.util.List;

public class Composite {

    public static void main(String[] args) {
        Square square = new Square("red");
        Circle circle = new Circle("blue");
        System.out.println(square);
        System.out.println(circle);

        // set color for all shapes
        CompositeShape composite = new CompositeShape("green");
        composite.addShape(square);
        composite.addShape(circle);
        composite.changeColor("yellow");
        System.out.println(square);
        System.out.println(circle);
        System.out.println(composite);

    }

}

interface Shape {
    void changeColor(String color);
}

class CompositeShape implements Shape {
    private String color;
    private List<Shape> shapes = new ArrayList<>();

    public CompositeShape(String color) {
        this.color = color;
    }

    public void changeColor(String color) {
        this.color = color;
        for (Shape shape : shapes) {
            shape.changeColor(color);
        }
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public String toString() {
        return "{" +
                " color='" + color + "'" +
                "}";
    }

}

class Square implements Shape {
    private String color;

    public Square(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "{" +
                " color='" + color + "'" +
                "}";
    }

    public void changeColor(String color) {
        this.color = color;
    }
}

class Circle implements Shape {
    private String color;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "{" +
                " color='" + color + "'" +
                "}";
    }

    public void changeColor(String color) {
        this.color = color;
    }
}