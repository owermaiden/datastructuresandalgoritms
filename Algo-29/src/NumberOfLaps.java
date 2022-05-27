import java.util.Arrays;

public class NumberOfLaps {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nbrOfLaps(4,6)));
    }
    public static int[] nbrOfLaps(int x, int y){
        int j=1,k=1;
        while (j*x!=y*k){
            if(j*x>y*k) k++;
            else j++;
        }
        return new int[]{j,k};
    }
}
