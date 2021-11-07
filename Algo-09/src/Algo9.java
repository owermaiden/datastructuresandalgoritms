import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Algo9 {
    public static void main(String[] args) {
        int[] numbers = {1,11,4,0,15,5,2,4,10,1,12,6,9,0,13};
        System.out.println(findBiggestRange(numbers));

    }

    public static ArrayList<Integer> findBiggestRange(int[] numbers) {
        var resultArray = new ArrayList<Integer>(2);
        var map = new HashMap<Integer, LinkedList<Integer>>();
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));


        for (int i = 0; i < numbers.length - 2; i++) {

            if (isAdjacent(numbers[i], numbers[i + 1]) ) {

                LinkedList<Integer> linkedList = new LinkedList<>();

                while (isAdjacent(numbers[i], numbers[i + 1])){
                       linkedList.add(numbers[i++]);
                       if (i == numbers.length - 1){
                            break;
                       }
                }
                linkedList.add(numbers[i]);
                map.put(linkedList.size(), linkedList);
            }
        }

        System.out.println(map);

        resultArray.add(map.get(getBiggestKey(map)).getFirst());
        resultArray.add(map.get(getBiggestKey(map)).getLast());

        return resultArray;
    }



    public static boolean isAdjacent(int a, int b){
        return a == b - 1;
    }

    public static int getBiggestKey(Map<Integer, LinkedList<Integer>> map){

        Map.Entry<Integer, LinkedList<Integer>> entryWithMaxKey = null;

        for (Map.Entry<Integer, LinkedList<Integer>> pair : map.entrySet()) {

            if (entryWithMaxKey == null || pair.getKey().compareTo(entryWithMaxKey.getKey()) > 0) {
                entryWithMaxKey = pair;
            }
        }
        return entryWithMaxKey.getKey();

    }


}
