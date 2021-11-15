import java.util.*;

public class AlgoOn3 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 2, 0, 10, 15, 5, 10, 15, 20, 14, 4};
                   // p  c  n
                   //    p  c  n
        System.out.println(findMaxPeek(nums));

    }

    public static LinkedList<Integer> findMaxPeek(int[] nums){
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;
        int peek = Integer.MAX_VALUE;


        while(true){

            int prev = nums[i];
            int curr = nums[i + 1];
            int next = nums[i + 2];
            if (i == nums.length - 3) break;
            i++;

            while (prev < curr && curr < next){

                LinkedList<Integer> linkedList = new LinkedList<>();

                linkedList.add(prev);
                prev = nums[i];
                curr = nums[i + 1];
                next = nums[i + 2];
                if (i == nums.length - 3) break;
                i++;

                if (prev < curr && curr > next){

                    peek = curr;
                    queue.add(peek);
                    linkedList.add(prev);
                    linkedList.add(curr);
                    linkedList.add(next);

                    while (curr > next && i < nums.length - 3){

                        prev = nums[++i];
                        curr = nums[i + 1];
                        next = nums[i + 2];
                        linkedList.add(curr);
                    }

                    map.put(peek, linkedList);
                }

            }


        }


        int x = queue.peek();

        System.out.println(map);

        return map.get(x);
    }
}
