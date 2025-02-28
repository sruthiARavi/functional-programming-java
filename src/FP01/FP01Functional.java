package FP01;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {
        List<Integer> nums = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        printAllNumbersInListFunctional(nums);
        printAllEvenNumbersInListFunctional(nums);
        printSquaresOfEvenNumbersInListFunctional(nums);
        printAllOddNumbersInListFunctional(nums);
        printCubesOfOddNumbersInListFunctional(nums);

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        printAllCourses(courses);
        printSpecificCourse("Spring", courses);
        printCourseWithCriteria(4, courses);
        printCharCountForEachCourse(courses);
    }

    private static void numPrint(int num) {
        System.out.println(num);
    }

    private static void printAllNumbersInListFunctional(List<Integer> nums) {
        //What to do ?
        nums.stream() //stream not really needed
                //.forEach(FP01.FP01Functional::numPrint); //classname :: methodname //method reference
                .forEach(System.out::println);
    }

    private static boolean isEven(int num) {
        return (num % 2 == 0);
    }

    private static void printAllEvenNumbersInListFunctional(List<Integer> nums) {
        nums.stream() //Stream is a sequence of elements
                //.filter(FP01.FP01Functional::isEven) //Add a filter to get only even nums
                .filter(num -> num % 2 == 0)
                .forEach(System.out::println);
    }

    private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> nums) {
        nums.stream()
                .filter(num -> num % 2 == 0)
                //mapping
                .map(num -> num * num)
                .forEach(System.out::println);
    }

    private static void printAllOddNumbersInListFunctional(List<Integer> nums) {
        nums.stream()
                .filter(num -> num % 2 != 0)
                .forEach(System.out::println);
    }

    private static void printCubesOfOddNumbersInListFunctional(List<Integer> nums) {
        nums.stream()
                .filter(num -> num % 2 != 0)
                .map(num -> num * num * num)
                .forEach(System.out::println);
    }

    private static void printAllCourses(List<String> courses) {
        courses.forEach(System.out::println);
    }

    private static void printSpecificCourse(String filterString, List<String> courses) {
        courses.stream()
                .filter(course -> course.contains(filterString))
                .forEach(System.out::println);
    }

    private static void printCourseWithCriteria(int minLetterCount, List<String> courses) {
        courses.stream()
                .filter(course -> course.length() >= minLetterCount)
                .forEach(System.out::println);
    }

    private static void printCharCountForEachCourse(List<String> courses) {
        courses.stream()
                //.map(course -> course.length())
                .map(String::length)
                .forEach(System.out::println);
    }
}
