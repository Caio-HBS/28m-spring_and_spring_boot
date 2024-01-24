package programming;

import java.util.List;

public class FP01Structured {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 4, 5, 22, 0, 9, 39);

        System.out.println("---Printing all numbers---");
        printAllNumbersInListStructured(numbers);

        System.out.println("\n---Printing even numbers---");
        printEvenNumbersInListStructured(numbers);
    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    private static void printEvenNumbersInListStructured(List<Integer> numbers) {
        for (int number : numbers) {
            if (number % 2 == 0) {
                System.out.println(number);
            }
        }
    }
}
