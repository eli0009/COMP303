package code;

public class Flyweight {
    public static void main(String[] args) {

        Scarlet flan = Scarlet.get(Scarlet.AGE.YOUNG);
        System.out.println(flan);
    }
}

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
