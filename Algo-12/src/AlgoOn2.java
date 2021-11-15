import java.util.*;

public class AlgoOn2 {

    public static void main(String[] args) {

        int[] arr1 = {-1,5,10,20,28,3};
        int[] arr2 = {29, 15, 65, 76};

        System.out.println(findClosest(arr1, arr2));
    }

    public static ArrayList<Integer> findClosest(int[] firstArray, int[] seconArray){
        // Queue<Integer> queue = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> map = new LinkedHashMap<>();

        if (firstArray.length == 0 || seconArray.length == 0) return result;

        Arrays.sort(seconArray);  //------------------------------------------ O(n)-------------------------------------------
        //Arrays.sort(firstArray);

        for ( int firstArrayEl : firstArray ){

                int prevDistance = Math.abs(firstArrayEl - seconArray[0]);  // First element distance......
                for (int i = 1; i < seconArray.length - 1; i++) {

                    int currDistance = Math.abs(firstArrayEl - seconArray[i]);

                    if (currDistance == 0) {    // No need to look further.................................

                        result.add(firstArrayEl);
                        result.add(seconArray[i]);
                        return result;
                    }

                    if (currDistance > prevDistance){   //  No need to look further.......................

                        ArrayList<Integer> temp = new ArrayList<>();
                        //queue.add(prevDistance);
                        temp.add(firstArrayEl);
                        temp.add(seconArray[i - 1]);
                        map.put(prevDistance, temp);
                        break;
                    }
                        prevDistance = currDistance;   //   Transfer distance to next iterate.............
                }
        }

        var smallestKey = Optional.of(map.keySet().stream().mapToInt(v -> v).min().orElseThrow(NoSuchElementException::new)).get();
        result = map.get(smallestKey);
        System.out.println(map);
        return result;
    }

}
