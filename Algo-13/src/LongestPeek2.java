import java.util.ArrayList;

public class LongestPeek2 {

    public static void main(String[] args) {

    }

    public static ArrayList<Integer> longestPeak(int[] arr) {
        boolean increasing = false;
        boolean decreasing = false;
        ArrayList<Integer> peak = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            peak.add(arr[i]);

            while (i + 1 < arr.length && arr[i] < arr[i + 1]) {
                increasing = true;
                peak.add(arr[i + 1]);
                i++;
            }

            while (i + 1 < arr.length && arr[i] > arr[i + 1]) {
                decreasing = true;
                peak.add(arr[i + 1]);
                i++;
            }

            if (increasing && decreasing) {
                if (peak.size() > result.size()) {
                    result = (ArrayList<Integer>) peak.clone();
                }
                i--;
            }

            peak.clear();
            increasing = false;
            decreasing = false;
        }
        return result;
    }
}
