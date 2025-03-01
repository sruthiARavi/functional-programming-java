package FP02;

import java.util.List;

public class FP02Structured {
    public static void main(String[] args) {
        List<Integer> nums = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        int sum = addListStructured(nums);
    }

    private static int addListStructured(List<Integer> nums) {
       //How to loop
        //How to store sum
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        return sum;
    }
}
