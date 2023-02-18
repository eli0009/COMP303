package code;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterPattern {

    public static void main(String[] args) {
        Cafetaria cafetaria = new Cafetaria();
        cafetaria.addMenuItem(new Pizza("Margherita", 5.50));
        cafetaria.addMenuItem(new Pizza("Hawaii", 6.50));
        cafetaria.addMenuItem(new Pizza("Pepperoni", 7.50));
        cafetaria.addMenuItem(new Salad("Caesar", 3.50));
        cafetaria.addMenuItem(new Salad("Greek", 4.50));

        for (MenuItem menuItem : cafetaria) {
            System.out.println(menuItem.getName() + " " + menuItem.getPrice());
        }
    }

}

class Cafetaria implements Iterable<MenuItem> {
    private List<MenuItem> menuItems = new ArrayList<>();

    public Iterator<MenuItem> iterator() {
        return menuItems.iterator();
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }
}

interface MenuItem {
    String getName();

    double getPrice();
}

class Pizza implements MenuItem {
    private String name;
    private double price;

    public Pizza(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Salad implements MenuItem {
    private String name;
    private double price;

    public Salad(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}