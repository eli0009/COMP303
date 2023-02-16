import java.util.Iterator;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // create null in optional
        Optional<String> nullStr = Optional.empty();
        // turn object into optional, works with null value
        Optional<String> str = Optional.ofNullable("Hello");
        // if-else
        nullStr.ifPresentOrElse(t -> System.out.println(t), () -> System.out.println("String is empty"));
        System.out.println(nullStr.isEmpty()); // True
        System.out.println(str.isPresent()); // True
        // Get the value, doesn't work with empty Optional
        System.out.println(str.get());
    }
}

class Zoo implements Iterable<String> {
    String[] animals = { "Panda", "Rabbit" };

    public Iterator<String> iterator() {
        return new ZooIterator();
    }

    class ZooIterator implements Iterator<String> {

        int index = 0;

        public boolean hasNext() {
            return index < animals.length;
        }

        @Override
        public String next() {
            String animal = animals[index];
            index++;
            return animal;
        }
    }
}