package code;

import java.util.HashSet;
import java.util.Objects;

public class QualityEqual {
    public static void main(String[] args) {
        HashSet<Point> points = new HashSet<>();
        HashSet<ColoredPoint> coloredPoints = new HashSet<>();
        points.add(new Point(1, 2));
        coloredPoints.add(new ColoredPoint(1, 2, "red"));
        System.out.println(points.contains(new Point(1, 2)));
        System.out.println(coloredPoints.contains(new ColoredPoint(1, 2, "red")));
        System.out.println(coloredPoints.contains(null));
    }
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other) {
        // null always false
        if (other == null)
            return false;
        // check if same instance
        if (this == other)
            return true;
        // check if same type
        if (!(other instanceof Point))
            return false;
        // cast to Point
        Point otherPoint = (Point) other;
        // check fields
        return this.x == otherPoint.x && this.y == otherPoint.y;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }
}

class ColoredPoint {
    private String color;
    private Point point;

    public ColoredPoint(int x, int y, String color) {
        this.point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    @Override
    public boolean equals(Object other) {
        // null always false
        if (other == null)
            return false;
        // check if same instance
        if (this == other)
            return true;
        // check if same type
        if (!(other instanceof ColoredPoint))
            return false;
        // cast to ColoredPoint
        ColoredPoint otherColoredPoint = (ColoredPoint) other;
        // check fields
        return this.point.equals(otherColoredPoint.point) && this.color.equals(otherColoredPoint.color);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + point.hashCode();
        result = 31 * result + color.hashCode();
        return result;
    }
}