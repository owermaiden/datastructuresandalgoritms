import java.util.Arrays;
import java.util.Queue;

public class Algo8 {
    public static void main(String[] args) {

        int[][] intervals = {{1,3},{1,4},{1,5},{6,8},{9,10}};
        mergeOverlapping(intervals);
        System.out.println(Arrays.deepToString(mergeOverlapping(intervals)));
    }

    public static int[][] mergeOverlapping(int[][] firstArray){

        int[] flatArray = Arrays.stream(firstArray)
                .flatMapToInt(Arrays::stream)
                .toArray();

        System.out.println(Arrays.toString(flatArray));

        int[] removedOverlap = new int[flatArray.length];
        int i = 0;int j = 0;
        do {
            removedOverlap[i++] = flatArray[j++];
            if (j == flatArray.length - 2) {
                removedOverlap[i++] = flatArray[j++];
                removedOverlap[i] = flatArray[j];
                break;
            }
            while (flatArray[j] > flatArray[j + 1]){
                j+=2;
            }
        } while (j < flatArray.length - 2);


        int[][] newArray = new int[firstArray.length][2];
        int count = 0;
        for (int x = 0; x < 5; x++){
            for (int y = 0; y < 2; y++){
                newArray[x][y] = removedOverlap[count++];
            }
        }
        return newArray;
    }
}
