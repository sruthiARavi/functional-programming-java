package FP03;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterfaces {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;

        Predicate<Integer> isEvenPredicateImpl = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x % 2 == 0;
            }
        };

        Function<Integer, Integer> squaringFunction = x -> x * x;

        Function<Integer, Integer> squaringFunctionImpl = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };

        //Consumer<Integer> soutConsumer = x -> System.out.println(x);
        Consumer<Integer> soutConsumer = System.out::println;

        Consumer<Integer> soutConsumerImpl = new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        };

        numbers.stream()
                .filter(isEvenPredicate)
                .map(squaringFunction)
                .forEach(soutConsumer);


        System.out.println("sum is : " + findIntegerSum(numbers));
    }

    private static int findIntegerSum(List<Integer> numbers) {

        BinaryOperator<Integer> integerSum = Integer::sum;

        BinaryOperator<Integer> integerSumImpl = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer x1, Integer x2) { //Function descriptor
                return x1 + x2;
            }
        }; //This is an anonymous inner class

        int sum = numbers.stream()
                .reduce(0, integerSum);
        return sum;
    }
}
