import java.util.Arrays;

public class ArraySumOthers {
    public static void main(String[] args) {
        int[] arr1 = { 1,2,3,4 };
        System.out.println(Arrays.toString(calculateProducts(arr1)));
    }

    private static int[] calculateProducts(int[] arr1) {
        int[] arr2 = new int[arr1.length];

        for (int i = 0; i < arr2.length; i++) {
            int finalI = i;
            arr2[i] = Arrays.stream(arr1)
                    .filter(n -> n!=arr1[finalI])
                    .reduce(1, (curr, prod) -> prod * curr);
        }
        return arr2;
    }
}
