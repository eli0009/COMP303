# McGill COMP303 - Software Design Notes

My COMP303 course notes. Available in Markdown. A sample of my notes for [Lecture 7](l7.md) is available below.


---

# Object state

## Abstract state

An abstract state is a state that impact how an object would be used. For example appending to a linked list when it is empty vs when it has more than 1 element

## Optional type

Use `Optional.empty()` instead of `null` to help avoid nullpointer exceptions.
```java
// create null in optional
Optional<String> nullStr = Optional.empty();
// turn object into optional, works with null value
Optional<String> str = Optional.ofNullable("Hello");
// if-else
nullStr.ifPresentOrElse(t -> System.out.println(t), () -> System.out.println("String is empty"));
System.out.println(nullStr.isEmpty()); // True
System.out.println(str.isPresent()); // True
// Get the value, doesn't work with empty Optional
System.out.println(str.get());
```

## NULL OBJECT design pattern

Goal: avoid `null` and `Optional`, but still avoid nullpointer exceptions.

Create an implementation of an interface that represents a null class instead of directly passing `null` so that the code doesn't break when null isn't checked.


## FLYWEIGHT design pattern

Goal: Avoid redundancy when storing data

Create an array that contains the values, then newly created object simply need to keep track of the index of the value, saving memory. 4 steps to realize this:
1. private constructor
2. static initializing fields that creates the flyweight objects
3. static flyweight store (ex: array) that stores all the flyweight objects
4. static access method that returns the flyweigth objects according to a key
```java
class Scarlet {
    private String name;
    // static flyweight store
    private static final Scarlet[] s = new Scarlet[2];

    // private constructor
    private Scarlet(String name) {
        this.name = name + " Scarlet";
    }

    // static initializing field
    static {
        s[0] = new Scarlet("Flandre");
        s[1] = new Scarlet("Remilia");
    }

    // the key
    enum AGE {
        YOUNG, OLD
    }

    // static access method
    public static Scarlet get(AGE a) {
        assert a != null;
        return s[a.ordinal()];
    }

    public String toString() {
        return name;
    }
}

public class Main {

    public static void main(String[] args) {

        Scarlet flan = Scarlet.get(Scarlet.AGE.YOUNG);
        System.out.println(flan);
    }
}
```

## SINGLETON design pattern

Goal: ensure only 1 instance of class (ex: database access, aggregation of states)

This is similar to flyweight, but in this case we only want 1 instance, so no key, and the store is a variable that points to the instance. 3 steps to realize this:
1. private constructor
2. variable that points to the instance
3. static access method
```java
public class Main {

    public static void main(String[] args) {
        BasicSingleton bs1 = BasicSingleton.getInstance();
        BasicSingleton bs2 = BasicSingleton.getInstance();
        System.out.println(bs1 == bs2); // true, they are the same instance
    }
}

class BasicSingleton {
    private int value;

    // private constructor
    private BasicSingleton() {
        this.value = 0;
    }

    // variable that points to the instance
    private static final BasicSingleton instance = new BasicSingleton();

    // static access method
    public static BasicSingleton getInstance() {
        return instance;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
```

## Anonymous classes

Create an anonymous class from an interface (ex: using `Comparator<T>`)
```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Box b1 = new Box(3, 9);
        Box b2 = new Box(8, 3);
        Box b3 = new Box(2, 6);
        List<Box> nBox = new ArrayList<>();
        nBox.add(b1);
        nBox.add(b2);
        nBox.add(b3);
        nBox.sort(Box.createColorComparator(Box.Color.Blue));
        System.out.println(nBox);
        // [{Blue: 2, Red: 6}, {Blue: 3, Red: 9}, {Blue: 8, Red: 3}]
        nBox.sort(Box.createColorComparator(Box.Color.Red));
        System.out.println(nBox);
        // [{Blue: 8, Red: 3}, {Blue: 2, Red: 6}, {Blue: 3, Red: 9}]
    }
}

/**
 * A box that contains a certain number of red and blue balls
 */
class Box {
    enum Color {
        Blue, Red
    }

    private int[] colors = new int[2];

    public Box(int blue, int red) {
        colors[Color.Blue.ordinal()] = blue;
        colors[Color.Red.ordinal()] = red;
    }

    public int getByColor(Color c) {
        return colors[c.ordinal()];
    }

    public static Comparator<Box> createColorComparator(Color c) {
        return new Comparator<Box>() {
            public int compare(Box b1, Box b2) {
                return b1.getByColor(c) - b2.getByColor(c);
            }

        };
    }

    public String toString() {
        return String.format("{Blue: %d, Red: %d}", colors[0], colors[1]);
    }
}
```