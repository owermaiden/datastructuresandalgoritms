import java.util.*;
import java.util.function.Predicate;

public class Algo5 {
    public static void main(String[] args) {
        int[] defaultArray = {3,5,-4,8,11,1,-1,6};
        int totalSum = 10;
        System.out.println(Arrays.toString(findTwoSum(defaultArray, totalSum)));


        
    }

    private static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            } else {
                numMap.put(nums[i], i);
            }
        }
        return new int[] {};
    }
}
