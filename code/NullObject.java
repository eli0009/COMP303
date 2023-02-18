package code;

import java.util.ArrayList;
import java.util.List;

public class NullObject {

    public static void main(String[] args) {
        System.out.println("Normal logger:");
        Box b1 = new Box(new ConsoleLogger());
        b1.add("book");
        b1.add("pen");
        System.out.println("Null logger:");
        Box b2 = new Box(new NullLogger());
        b2.add("book");
        b2.add("pen");
    }
}

class Box {
    private List<String> things = new ArrayList<>();
    Logger logger;

    public Box(Logger logger) {
        this.logger = logger;
    }

    public void add(String thing) {
        things.add(thing);
        logger.log("Added " + thing);
    }
}

interface Logger {
    void log(String message);
}

class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}

class NullLogger implements Logger {
    @Override
    public void log(String message) {
    }
}