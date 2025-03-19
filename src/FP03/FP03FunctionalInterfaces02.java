package FP03;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FP03FunctionalInterfaces02 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;

        Function<Integer, Integer> squaringFunction = x -> x * x;

        Function<Integer, String> stringOutputFunction = x -> x + " ";

        //Consumer<Integer> soutConsumer = x -> System.out.println(x);
        Consumer<Integer> soutConsumer = System.out::println;

        numbers.stream()
                .filter(isEvenPredicate)
                .map(squaringFunction)
                .forEach(soutConsumer);

        //Sum
        BinaryOperator<Integer> integerSum = Integer::sum;
        //BinaryOperator takes two inputs and gives an output;
        // all the inputs and outputs are of the SAME type unlike a function

        int sum = numbers.stream()
                .reduce(0, integerSum);

        //binary operator
        System.out.println("sum is : " + sum);

        /*
         ***************************
         * OTHER FUNCTIONAL INTERFACES
         ***************************
         */


        //No Input > Return something
        //Supplier
        //Supplier<Integer> randomIntegerSupplier = () -> 2;
        Supplier<Integer> randomIntegerSupplier = () -> {
            Random random = new Random();
            return random.nextInt(1000);
        }; //no input

        System.out.println(randomIntegerSupplier.get());

        //Unary Operator
        //Binary operator operates on 2 inputs of same type and returns output of same type
        //Unary operator takes 1 input and returns 1 output, both of same type
        UnaryOperator<Integer> timesThreeOperator = x -> 3 * x;

        System.out.println("3 times 15 is  : " +  timesThreeOperator.apply(15));

        //BiPredicate
        //2 inputs of different type of params and output type boolean
        BiPredicate<Integer, String> biPredicate = (x,y) -> x%2 == 0 && !y.isBlank();
        System.out.println(biPredicate.test(24, "test"));
        System.out.println(biPredicate.test(21, ""));

        //BiFunction
        //2 different type of inputs and one different type of output allowed
        BiFunction<Integer, String, Double> biFunction = (num, operationName) ->
                switch (operationName.toLowerCase()) {
                    case "square" -> num * num * 1d;
                    case "cube" -> num * num * num * 1d;
                    case "sqrt" -> Math.sqrt(num);
                    default -> num * 1d;
                };
        System.out.println("Square of 5 : " + biFunction.apply(5, "square"));
        System.out.println("Square root of 25 : " + biFunction.apply(25, "sqrt"));
        System.out.println("num - " + biFunction.apply(5, "random"));

        //BiConsumer
        //takes two inputs
        BiConsumer<Integer, String> biConsumer = (num, opName) -> {
            System.out.println("Operation (" + opName + ") of " + num + " is : ");
        };
        biConsumer.accept(81, "sqrt");
        System.out.println(biFunction.apply(81, "sqrt"));

        //Built in ops using primitives - to prevent unnecessary boxing / unboxing
        //IntBinaryOperator
        IntBinaryOperator intBinaryOperator = Integer::sum;
        IntBinaryOperator intBinaryOperator1 = (x, y) -> x * y;
        //IntConsumer
        //IntFunction
        //IntPredicate
        //IntSupplier
        //IntToDoubleFunction
        //IntToLongFunction
        //IntUnaryOperator
    }

}
