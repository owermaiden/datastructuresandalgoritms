import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int targetSum = 0;
        int[] draftArray = { 12, 3, 1, 2, -6, 5, -8, 6 };
        int[] edgeCases = { -4, -3, -2, -1, 3, 4, 5, 6 };

        System.out.println(Arrays.deepToString(threeNumberSum(draftArray, targetSum)));
        System.out.println(Arrays.deepToString(threeNumberSum(edgeCases, 0)));
    }

    public static int[][] threeNumberSum(int[] draftArray, int targetSum) {
        Arrays.sort(draftArray);
        int n = draftArray.length;
        List<int[]> results = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = draftArray[i] + draftArray[left] + draftArray[right];
                if (sum == targetSum) {
                    results.add(new int[] { draftArray[i], draftArray[left], draftArray[right] });
                    left++;
                    right--;
                } else if (sum < targetSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return results.toArray(new int[results.size()][]);
    }
}
