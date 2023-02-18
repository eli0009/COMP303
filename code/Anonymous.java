package code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Anonymous {

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