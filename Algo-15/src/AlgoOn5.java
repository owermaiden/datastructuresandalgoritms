import java.util.ArrayList;
import java.util.Arrays;

public class AlgoOn5 {
    public static void main(String[] args) {
        int[] givenArray = {1,2,4,7,10,11,7,12,6,7,16,18,19};
        int[] edgeCaseArray = {1,2,3,4,5,6,7,8,9};
        System.out.println(findSubArray(givenArray));
        System.out.println(findSubArray(edgeCaseArray));

    }

    public static ArrayList<Integer> findSubArray(int[] givenArray){
        ArrayList<Integer> result = new ArrayList<>();
        boolean alreadySorted = false;

        int [] sortedArray = givenArray.clone();                  // first clone the array...
        Arrays.sort(sortedArray);                                 // then sort it...
        System.out.println(Arrays.toString(sortedArray));
        System.out.println(Arrays.toString(givenArray));

        int startIndex = 0;
        while (givenArray[startIndex] == sortedArray[startIndex]){   // if two indexes are equal...continue to look up..
            startIndex++;
            if (startIndex == givenArray.length - 1) {               // if we reach the end and still not find any difference
                alreadySorted = true;                                // then it means our array is already sorted..
                break;
            }
        }

        if (alreadySorted){                                         // if already sorted..return -1,-1
            result.add(-1);  result.add(-1);
            return result;
        }

        int endIndex = givenArray.length - 1;                       // Do the same from reverse traversal...
        while (givenArray[endIndex] == sortedArray[endIndex]){      // We only need index...
            endIndex--;
        }

        result.add(startIndex); result.add(endIndex);               // Add results in an arraylist...
        return result;

    }
}
