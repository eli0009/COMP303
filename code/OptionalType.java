package code;

import java.util.Optional;

public class OptionalType {
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
