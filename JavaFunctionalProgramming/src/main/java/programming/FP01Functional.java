package programming;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 4, 5, 22, 0, 9, 39);

        System.out.println("---Printing all numbers---");
        printAllNumbersInListFunctional(List.of(12, 9, 4, 5, 22, 0, 9, 39));

        System.out.println("\n---Printing even numbers---");
        printEvenNumbersInListFunctional(numbers);

        System.out.println("\n---Printing odd numbers---");
        printOddNumbersInListFunctional(numbers);

        System.out.println("\n---Printing squares of even numbers---");
        printSquaresOfEvenNumbersInListFunctional(numbers);

        System.out.println("\n---Printing cubes of odd numbers---");
        printCubeOfOddNumbersInListFunctional(numbers);
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        // Sends each of the numbers in the list to be printed.
        numbers
                .forEach(System.out::println); // Method reference.
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        // Sends each of the numbers in the list to be printed.
        numbers.stream()
                .filter(number -> number % 2 == 0) // Lambda expression.
                .forEach(System.out::println); // Method reference.
    }

    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        // Sends each of the numbers in the list to be printed.
        numbers.stream()
                .filter(number -> number % 2 != 0) // Lambda expression.
                .forEach(System.out::println); // Method reference.
    }

    private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
        // Sends each of the numbers in the list to be printed.
        numbers.stream()
                .filter(number -> number % 2 == 0) // Lambda expression.
                .map(number -> number * number) // Mapping.
                .forEach(System.out::println); // Method reference.
    }

    private static void printCubeOfOddNumbersInListFunctional(List<Integer> numbers) {
        // Sends each of the numbers in the list to be printed.
        numbers.stream()
                .filter(number -> number % 2 != 0) // Lambda expression.
                .map(number -> (int) Math.pow(number, 3)) // Mapping.
                .forEach(System.out::println); // Method reference.
    }
}
