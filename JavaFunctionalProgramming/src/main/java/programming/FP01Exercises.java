package programming;

import java.util.List;

public class FP01Exercises {
    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker",
                "Kubernetes");

        System.out.println("---Printing all courses---");
        printAllCourses(courses);

        System.out.println("\n---Printing courses with word \"Spring\"---");
        printSpringCourses(courses);

        System.out.println("\n---Printing with more than 3 letters---");
        printAtLeast4LettersCourses(courses);

        System.out.println("\n---Printing number of characters in course's name---");
        printNumberOfCharactersInCourseName(courses);

    }

    public static void printAllCourses(List<String> courses) {
        courses
                .forEach(System.out::println);
    }

    public static void printSpringCourses(List<String> courses) {
        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);
    }

    public static void printAtLeast4LettersCourses(List<String> courses) {
        courses.stream()
                .filter(course -> course.length() > 3)
                .forEach(System.out::println);
    }

    public static void printNumberOfCharactersInCourseName(List<String> courses) {
        courses.stream()
                // Ignores the whitespaces.
                .map(course -> course.replaceAll("\\s", "") + ": " + course.replaceAll("\\s", "").length())
                .forEach(System.out::println);
    }
}
