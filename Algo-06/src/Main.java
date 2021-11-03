import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int targetSum = 0;
        int[] draftArray = { 12, 3, 1,2,-6,5,-8,6};

        System.out.println(Arrays.deepToString(threeNumberSum(draftArray, targetSum)));
    }

    public static int[][] threeNumberSum(int[] draftArray, int targetSum ){
        int[] orderedArray = Arrays.stream(draftArray).sorted().toArray();
        int arrayLength = draftArray.length;
        int x = 0; int y = 0;
        int[][] resultArray = new int[arrayLength][3];

        for (int i = 0; i < arrayLength - 4; i++){
            for (int j = i; j < arrayLength -1; j++){
                for (int k = j; k < arrayLength - 1; k++){
                    if ((orderedArray[i] + orderedArray[j] + orderedArray[k]) == targetSum){
                        resultArray [x][y++] = orderedArray[i];
                        resultArray [x][y++] = orderedArray[j];
                        resultArray [x++][y] = orderedArray[k];
                        y = 0;
                    }
                }
            }
        }
       return resultArray;
    }
}
