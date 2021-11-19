import java.util.ArrayList;
import java.util.Arrays;

public class AlgoOn5 {
    public static void main(String[] args) {
        int[] givenArray = {1,2,3,4,5,3};
        System.out.println(findSubArray(givenArray));

    }

    public static ArrayList<Integer> findSubArray(int[] givenArray){
        ArrayList<Integer> result = new ArrayList<>();
        boolean alreadySorted = false;

        int [] sortedArray = givenArray.clone();
        Arrays.sort(sortedArray);
        System.out.println(Arrays.toString(sortedArray));
        System.out.println(Arrays.toString(givenArray));

        int startIndex = 0;
        while (givenArray[startIndex] == sortedArray[startIndex]){
            startIndex++;
            if (startIndex == givenArray.length - 1) {
                alreadySorted = true;
                break;
            }
        }

        if (alreadySorted){
            result.add(-1);  result.add(-1);
            return result;
        }

        int endIndex = givenArray.length - 1;
        while (givenArray[endIndex] == sortedArray[endIndex]){
            endIndex--;
        }

        result.add(startIndex); result.add(endIndex);
        return result;

    }
}
