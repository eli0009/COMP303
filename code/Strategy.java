package code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Strategy {

    public static void main(String[] args) {
        Item item1 = new Item("item1", 300);
        Item item2 = new Item("item3", 200);
        Item item3 = new Item("item2", 100);
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);

        // [Item{name='item1', price=300},
        // Item{name='item2', price=100},
        // Item{name='item3', price=200}]
        items.sort(Item.createByNameComparator());
        System.out.println(items);

        // [Item{name='item2', price=100},
        // Item{name='item3', price=200},
        // Item{name='item1', price=300}]
        items.sort(Item.createByPriceComparator());
        System.out.println(items);
    }
}

class Item {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static Comparator<Item> createByNameComparator() {
        return new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
    }

    public static Comparator<Item> createByPriceComparator() {
        return new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getPrice() - o2.getPrice();
            }
        };
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}