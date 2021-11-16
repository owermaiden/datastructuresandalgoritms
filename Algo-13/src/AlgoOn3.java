import java.util.*;

public class AlgoOn3 {
    public static void main(String[] args) {
        int[] nums = {  0, 10, 15, 5, 4, 2, 12, 10, 15, 20, 19 };
                   // p  c  n
                   //    p  c  n
        System.out.println(findMaxPeek(nums));

    }

    public static String findMaxPeek(int[] nums){
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        int i = 0;
        int peek = Integer.MAX_VALUE;

        while(true){

            int prev = nums[i];
            int curr = nums[i + 1];
            int next = nums[i + 2];
            if (i == nums.length - 3) break;

            if (isBeginingOfPattern(prev,curr)){

                LinkedList<Integer> linkedList = new LinkedList<>();

                if(isPeek(prev,curr,next)){

                    peek = curr;
                    linkedList.add(prev);
                    linkedList.add(curr);


                    while (curr > next && i < nums.length - 3){

                        prev = nums[++i];
                        curr = nums[i + 1];
                        next = nums[i + 2];
                        linkedList.add(curr);
                    }

                    map.put(linkedList.size(), linkedList);

                } else if (isIncrease(prev,curr,next)){

                    while (isIncrease(prev,curr,next)){

                        linkedList.add(prev);
                        prev = nums[++i];
                        curr = nums[i + 1];
                        next = nums[i + 2];

                        if (i == nums.length - 3) {

                            linkedList.add(prev);
                            linkedList.add(curr);
                            if (next < curr) {
                                linkedList.add(next);
                                map.put(linkedList.size(), linkedList);
                            }
                            break;
                        }

                        if (isPeek(prev,curr,next)){

                            peek = curr;
                            linkedList.add(prev);
                            linkedList.add(curr);

                            while (curr > next){

                                prev = nums[++i];
                                curr = nums[i + 1];
                                next = nums[i + 2];
                                linkedList.add(curr);

                                if (i == nums.length - 3) {
                                    linkedList.add(next);
                                    map.put(linkedList.size(), linkedList);
                                    break;
                                }
                            }

                            map.put(linkedList.size(), linkedList);
                            i++;
                        }
                    }
                }

            } else {
                i++;
            }
        }

        System.out.println(map);
        return "map.values()";
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




}
