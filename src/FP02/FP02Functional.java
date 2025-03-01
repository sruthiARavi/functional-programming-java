package FP02;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {
    public static void main(String[] args) {
        List<Integer> nums = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        int sum = addListFunctional(nums);
        System.out.println(sum);
        addListFunctionalUsingLambdaExpression(nums);
        System.out.println(findSquareSum(nums));
        System.out.println("cube : " + findCubeSum(nums));
        System.out.println("odd sum : " + findOddSum(nums));
        printDistinctNums(nums);
        printSortedNums(nums);
        printDistinctSortedNums(nums);

        List<Integer> squaredNums = squareList(nums);
        System.out.println(squaredNums);
        List<Integer> evenList = evenOnlyList(nums);
        System.out.println("even list : " + evenList);
        List<Integer> oddList = oddOnlyList(nums);
        System.out.println("odd list : " + oddList);

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes", "AWS");
        printDistinctCourses(courses);
        System.out.println("======");
        printSortedCourses(courses);
        printDistinctSortedCourses(courses);
        printDistinctReverseSortedCourses(courses);
        printDistinctLengthSortedCourses(courses);
        List<Integer> courseLengthList = courseLengthList(courses);
        System.out.println("course len list : " + courseLengthList);
    }

    private static List<Integer> squareList(List<Integer> nums) {
        return nums.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
    }

    private static List<Integer> evenOnlyList(List<Integer> nums) {
        return nums.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
    }

    private static List<Integer> oddOnlyList(List<Integer> nums) {
        return nums.stream()
                .filter(x -> x % 2 == 1)
                .collect(Collectors.toList());
    }

    private static int sum(int aggregate, int nextNumber) {
        return aggregate + nextNumber;
    }

    private static int addListFunctional(List<Integer> nums) {
        return nums.stream()
                //Combine them into one result -> One value
                //0 and (a,b) -> a + b
                //Stream of number -> One result value
                .reduce(0, FP02Functional::sum); // 0 : initial value of the sum
    }

    private static int addListFunctionalUsingLambdaExpression(List<Integer> nums) {
        return nums.stream()
                .reduce(0, (x, y) -> x + y);
        //.reduce(0, Integer::sum); //use pre-defined function
    }

    private static int findSquareSum(List<Integer> nums) {
        return nums.stream()
                //.reduce(0, (x, y) -> x + (y * y));
                .map(num -> num * num)
                .reduce(0, Integer::sum);
    }

    private static int findCubeSum(List<Integer> nums) {
        return nums.stream()
                // .reduce(0, (x, y) -> x + (y * y * y));
                .map(num -> num * num * num) //Intermediate operation as it returns a stream 
                .reduce(0, Integer::sum); //Terminal operation as it returns an int (not a stream) 
    }

    private static int findOddSum(List<Integer> nums) {
        return nums.stream()
                .filter(num -> num % 2 != 0)
                .reduce(0, Integer::sum);
    }

    private static int findEvenSum(List<Integer> nums) {
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum);
    }

    private static void printDistinctNums(List<Integer> nums) {
        nums.stream().distinct().forEach(System.out::println);
    }

    private static void printSortedNums(List<Integer> nums) {
        nums.stream().sorted().forEach(System.out::println);
    }

    private static void printDistinctSortedNums(List<Integer> nums) {
        System.out.println("_----_");
        nums.stream().distinct().sorted().forEach(System.out::println);
    }

    private static void printDistinctCourses(List<String> courses) {
        courses.stream().distinct().forEach(System.out::println);
    }

    private static void printSortedCourses(List<String> courses) {
        courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
    }

    private static void printDistinctSortedCourses(List<String> courses) {
        System.out.println("_----_");
        courses.stream().distinct().sorted(Comparator.naturalOrder()).forEach(System.out::println);
    }

    private static void printDistinctReverseSortedCourses(List<String> courses) {
        System.out.println("_----_");
        courses.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    private static void printDistinctLengthSortedCourses(List<String> courses) {
        System.out.println("_----_");
        //        courses.stream().distinct().sorted(Comparator.comparing(str ->str.length())).forEach(System.out::println);
        courses.stream().distinct().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
    }

    private static List<Integer> courseLengthList(List<String> courses) {
        return courses.stream()
                .map(String::length)
                .distinct() //optional
                .sorted() //optional
                .collect(Collectors.toList());
    }
}
