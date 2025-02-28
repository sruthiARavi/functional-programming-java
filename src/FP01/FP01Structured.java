package FP01;

import java.util.List;

public class FP01Structured {
    public static void main(String[] args) {
        printAllNumbersInListStructured(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
        printAllEvenNumbersInListStructured(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
    }

    private static void printAllNumbersInListStructured(List<Integer> nums) {
        //How to loop the numbers ?
        for(Integer num : nums) {
            System.out.println(num);
        }
    }

    private static void printAllEvenNumbersInListStructured(List<Integer> nums) {
        for (Integer num : nums) {
            if (num % 2 == 0)
                System.out.println(num);
        }
    }
}
