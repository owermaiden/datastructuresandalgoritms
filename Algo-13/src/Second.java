import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Second {
    public static void main(String[] args) {

    }

    public static boolean isPeek(int a, int b, int c){
        return a < b && b > c;
    }

    public static boolean isIncrease(int a, int b, int c){
        return a < b && b < c;
    }

    public static boolean isDecrease(int a, int b, int c){
        return a > b && b > c;
    }

    public static boolean isEndOfPattern(int a, int b, int c){
        return a > b && b < c;
    }

    public static boolean isBeginingOfPattern(int a, int b){
        return a < b;
    }


    /*
    public static String findMaxPeek2(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();

        int i = 0;
        int peek = Integer.MAX_VALUE;

        while (true) {

            int prev = nums[i];
            int curr = nums[i + 1];
            int next = nums[i + 2];

            LinkedList<Integer> linkedList = new LinkedList<>();

            if (isBeginingOfPattern(prev,curr)){

                linkedList.add(prev);

                if (isIncrease(prev, curr, next)){

                    while (isIncrease(prev,curr,next)){

                        prev = nums[++i];
                        curr = nums[i + 1];
                        next = nums[i + 2];
                        linkedList.add(prev);

                    }

                } else if (isPeek(prev, curr, next)) {

                    peek = curr;
                    linkedList.add(curr);
                    linkedList.add(next);
                    i++;

                } else {

                    i++;
                    linkedList.clear();
                    continue;

                }





            }
            else if (isDecrease(prev, curr, next)){

                linkedList.add(prev);
                linkedList.add(curr);
                linkedList.add(next);

            } else if (isEndOfPattern(prev, curr, next)){

                linkedList.add(prev);
                linkedList.add(curr);
                map.put(peek, linkedList);
                linkedList.clear();

            }





            i++;


        }

        return " ";
    }

     */
}
