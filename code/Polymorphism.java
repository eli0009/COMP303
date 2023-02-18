package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Polymorphism {

    public static void main(String[] args) {
        Bird bird = new Bird();
        fly(bird);

        // A practical example with arraylist and linkedlist. Both classes are
        // implementation of the List interface.
        List<Integer> list = new ArrayList<>();
        list = new LinkedList<>();
    }

    public static void fly(Flyable flyable) {
        flyable.fly();
    }

}

interface Flyable {
    void fly();
}

class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Bird is flying");
    }
}
