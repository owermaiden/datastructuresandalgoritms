import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySumOthers {
    public static void main(String[] args) {
        int[] arr1 = { 1,2,3,4 };
        System.out.println(Arrays.toString(calculateProducts2(arr1)));
    }

    private static int[] calculateProducts(int[] arr1) {   // O (n2)
        int[] arr2 = new int[arr1.length];

        for (int i = 0; i < arr2.length; i++) {
            int finalI = i;
            arr2[i] = Arrays.stream(arr1)
                    .filter(n -> n!=arr1[finalI])
                    .reduce(1, (curr, prod) -> prod * curr);
        }
        return arr2;
    }

    private static int[] calculateProducts2(int[] given) {   // O(n)
        int[] result = new int[given.length];
        for (int i = 0; i < given.length; i++) result[i] = products(given, i);
        return result;
    }

    private static int products(int[] arr,int index){
        List<Integer> leftProducts = new ArrayList<>();
        List<Integer> rightProducts = new ArrayList<>();

        for (int i = 0; i < index ; i++) {   // O(n)
            leftProducts.add(arr[i]);
        }

        for (int i = index + 1; i < arr.length ; i++) {  // O(n)
            rightProducts.add(arr[i]);
        }

        return leftProducts.stream().reduce(1,(a,b) -> a * b) * rightProducts.stream().reduce(1,(a,b) -> a * b);
    }
}
