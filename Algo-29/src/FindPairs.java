import java.util.HashMap;
import java.util.Map;

public class FindPairs {
    public static void main(String[] args) {

    }

    public static int findThePairs(int[] arr){
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i =0;i< arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        for(Integer each: map.values()){
            result += each/2;
        }

        return result;
    }
}
