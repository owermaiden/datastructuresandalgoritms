import java.util.Arrays;

public class Algo3 {
    public static void main(String[] args) {
        int[][] givenArray = {{1,2, 3,4},{12,13,14,5},{11,16, 15, 6},{10,9,8,7}};
        System.out.println(Arrays.toString(flatAndSortArray(givenArray)));
    }

    public static int[] flatAndSortArray(int[][] givenArray){

        return  Arrays.stream(givenArray)
                .flatMapToInt(Arrays::stream)
                .sorted()
                .toArray();
    }
}
