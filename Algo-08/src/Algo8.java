import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Algo8 {
    public static void main(String[] args) {

        int[][] intervals = {{1,3},{1,4},{1,5},{6,8},{9,10}};
        System.out.println(Arrays.deepToString(mergeOverlapping(intervals)));
    }

    public static int[][] mergeOverlapping(int[][] intervals){
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        // Sort intervals by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0].clone();

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start <= current[1]) {
                // overlapping -> extend the current interval's end if needed
                current[1] = Math.max(current[1], end);
            } else {
                // no overlap -> push current and move to next
                merged.add(current);
                current = intervals[i].clone();
            }
        }

        // add the last interval
        merged.add(current);

        return merged.toArray(new int[merged.size()][]);
    }
}
