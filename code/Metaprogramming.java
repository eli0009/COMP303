package code;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Metaprogramming {
    public static void main(String[] args) {
        Flandre flan = new Flandre();
        System.out.println(flan);
        try {
            // option 1
            Class c = Class.forName("code.Flandre");
            // option 2
            // Class c = flan.getClass();
            // option 3
            // Class c = Flandre.class;
            Method[] m = c.getDeclaredMethods();
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