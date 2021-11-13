import java.util.*;

public class AlgoOn2 {

    public static void main(String[] args) {

        int[] arr1 = {-1, 2, -5, 6, 10, 25};
        int[] arr2 = {42, 65, 7,66, 34, 55};

        System.out.println(findClosest(arr1, arr2));
    }

    public static ArrayList<Integer> findClosest(int[] arr1, int[] arr2){
        Queue<Integer> queue = new PriorityQueue<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> result;

        Arrays.sort(arr2);
        Arrays.sort(arr1);

        for ( int one : arr1 ){

                int prev = Math.abs(one - arr2[0]);
                for (int i = 0; i < arr2.length - 1; i++) {

                    int distance = Math.abs(one - arr2[i]);

                    if (distance > prev){

                        ArrayList<Integer> temp = new ArrayList<>();
                        queue.add(prev);
                        temp.add(one);
                        temp.add(arr2[i - 1]);
                        map.put(prev, temp);
                        break;
                    }
                        prev = distance;
                }
        }

        System.out.println(queue.poll());
        System.out.println(map);
        result = map.get(queue.poll());
        return result;
    }

}
