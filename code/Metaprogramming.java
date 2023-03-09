package code;

import java.lang.reflect.Field;

public class Metaprogramming {
    public static void main(String[] args) {
        Flandre flan = new Flandre();
        System.out.println(flan);
        try {
            Class c = Class.forName("code.Flandre");
            Field f = c.getDeclaredField("name");
            f.setAccessible(true);
            f.set(flan, "Flandre");

        } catch (
                NoSuchFieldException | IllegalAccessException | // field exceptions
                ClassNotFoundException e // class exception
        ) {
            e.printStackTrace();
        }

        System.out.println(flan);
    }
}

class Flandre {
    private String name = "Scarlet";

    @Override
    public String toString() {
        return name;
    }
}