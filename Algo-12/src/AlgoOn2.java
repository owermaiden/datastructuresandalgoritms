import java.util.*;

public class AlgoOn2 {

    public static void main(String[] args) {

        int[] arr1 = {-1,5,10,20,28,3};
        int[] arr2 = {26, 65, 76};

        System.out.println(findClosest(arr1, arr2));
    }

    public static ArrayList<Integer> findClosest(int[] arr1, int[] arr2){
        // Queue<Integer> queue = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        if (arr1.length == 0 || arr2.length == 0) return result;

        Arrays.sort(arr2);  //------------------------------------------ O(n)-------------------------------------------
        Arrays.sort(arr1);

        for ( int one : arr1 ){

                int prevDistance = Math.abs(one - arr2[0]);
                for (int i = 1; i < arr2.length - 1; i++) {

                    int currDistance = Math.abs(one - arr2[i]);

                    if (currDistance > prevDistance){

                        ArrayList<Integer> temp = new ArrayList<>();
                        //queue.add(prevDistance);
                        temp.add(one);
                        temp.add(arr2[i - 1]);
                        map.put(prevDistance, temp);
                        break;
                    }
                        prevDistance = currDistance;
                }
        }

        var smallestKey = Optional.of(map.keySet().stream().mapToInt(v -> v).min().orElseThrow(NoSuchElementException::new)).get();
        result = map.get(smallestKey);
        System.out.println(map);
        return result;
    }

}
