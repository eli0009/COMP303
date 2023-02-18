package code;

import java.util.Iterator;

public class IterUse {
    public static void main(String[] args) {
        Zoo z = new Zoo();

        for (String animal : z) {
            System.out.println(animal);
        }
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