package FP03;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03BehaviorParametrization {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        //Predicate<Integer> isEvenPredicateImp = x -> x % 2 == 0;
        filterAndPrint(numbers, x1 -> x1 % 2 == 0);

        filterAndPrint(numbers, x -> x % 2 != 0);

        System.out.println("Printing 3 multiples");
        filterAndPrint(numbers, x -> x % 3 == 0); //Behavior parametrization

        //List squaredNumbers = numbers.stream() .map(x -> x*x) .collect(Collectors.toList());
        //Function<Integer, Integer> squareFunction = x -> x * x;
        List<Integer> squaredNumbers = mapAndCreateNewList(numbers, x -> x * x);

        List<Integer> cubedNumbers = mapAndCreateNewList(numbers, x -> x * x * x);

        List<Integer> doubledNumbers = mapAndCreateNewList(numbers, x -> x + x);

    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> squareFunction) {
        return numbers.stream()
                .map(squareFunction)
                .toList();
    }


    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}
