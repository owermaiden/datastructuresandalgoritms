import java.util.*;

public class AlgoOn3 {
    public static void main(String[] args) {
        int[] nums = {  1, 2, 3, 4, 5, 6, 7, 8, 9, 10,9, 10 };
                   // p  c  n
                   //    p  c  n
        System.out.println(findMaxPeek(nums));

    }

    public static LinkedList<Integer> findMaxPeek(int[] nums){

        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();

        int i = 0;
        while(true){

            int prev = nums[i];
            int curr = nums[i + 1];
            int next = nums[i + 2];
            if (i == nums.length - 3) break;

            if (isBeginingOfPattern(prev,curr)){  //-------------------------Begining of a pattern---------------------

                LinkedList<Integer> linkedList = new LinkedList<>();

                if(isPeek(prev,curr,next)){      // ------------------------ Peek at the begining ---------------------

                    linkedList.add(prev);
                    linkedList.add(curr);


                    while (curr > next && i < nums.length - 3){ // ----------Go till the end of the pattern------------

                        prev = nums[++i];
                        curr = nums[i + 1];
                        next = nums[i + 2];
                        linkedList.add(curr);
                    }

                    map.put(linkedList.size(), linkedList);

                } else if (isIncrease(prev,curr,next)){  // -------------------Continue to reach a peek-----------------

                    while (isIncrease(prev,curr,next)){  // -------------------Continue to reach a peek-----------------

                        linkedList.add(prev);
                        prev = nums[++i];
                        curr = nums[i + 1];
                        next = nums[i + 2];

                        if (i == nums.length - 3) {     // -------------------End of Array need extra care--------------

                            linkedList.add(prev);
                            linkedList.add(curr);

                            if (next < curr) {
                                linkedList.add(next);
                                map.put(linkedList.size(), linkedList);
                            }
                            break;
                        }

                        if (isPeek(prev,curr,next)){    // -------------------If we reach peek--------------------------

                            linkedList.add(prev);
                            linkedList.add(curr);

                            while (curr > next){       // ----------------Go till the end of the pattern----------------

                                prev = nums[++i];
                                curr = nums[i + 1];
                                next = nums[i + 2];
                                linkedList.add(curr);

                                if (i == nums.length - 3) {  // -------------------End of Array need extra care---------

                                    if (next < curr) {
                                        linkedList.add(next);
                                    }
                                    map.put(linkedList.size(), linkedList);
                                    break;
                                }
                            }

                            map.put(linkedList.size(), linkedList);
                        }
                    }
                }

            } else {        //--------------------------if the pattern doesnt match, move pointer to shift right--------
                i++;
            }
        }
        var biggestKey = Optional.of(map.keySet().stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new)).get();
        System.out.println(map);
        return map.get(biggestKey);
    }

    public static boolean isPeek(int a, int b, int c){
        return a < b && b > c;
    }

    public static boolean isIncrease(int a, int b, int c){
        return a < b && b < c;
    }

    public static boolean isBeginingOfPattern(int a, int b){
        return a < b;
    }




}
