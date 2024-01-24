package optionalclass;

import java.util.List;
import java.util.Optional;

public class PlayingWithOptional {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "mango", "strawberry");

        Optional<String> optional = fruits.stream()
                .filter(fruit -> fruit.startsWith("b"))
                .findFirst();

        System.out.println(optional);
        System.out.println("Is the object empty: " + optional.isEmpty());
        System.out.println("Is any value present for the object: " + optional.isPresent());

        // Structured approach:
        // if (optional.isPresent()) {
        //     System.out.println(optional.get());
        // }

        // Functional approach:
        optional.ifPresent(System.out::println);

    }
}
