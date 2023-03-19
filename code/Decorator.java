package code;

public class Decorator {
    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        System.out.println(coffee.info());

        SugaryDrink sugary_coffee = new SugaryDrink(coffee, 10);
        System.out.println(sugary_coffee.info());

        ColoredDrink colored_sugary_coffee = new ColoredDrink(sugary_coffee, "red");
        System.out.println(colored_sugary_coffee.info());

    }
}

interface Drink {
    String info();
}

class Coffee implements Drink {
    @Override
    public String info() {
        return "Coffee";
    }
}

class SugaryDrink implements Drink {
    private Drink drink;
    private int sugar;

    public SugaryDrink(Drink drink, int sugar) {
        this.drink = drink;
        this.sugar = sugar;
    }

    @Override
    public String info() {
        return drink.info() + " with " + sugar + "g of sugar";
    }
}

class ColoredDrink implements Drink {
    private Drink drink;
    private String color;

    public ColoredDrink(Drink drink, String color) {
        this.drink = drink;
        this.color = color;
    }

    @Override
    public String info() {
        return drink.info() + " with color " + color;
    }
}