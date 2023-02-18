package code;

public class Singleton {
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