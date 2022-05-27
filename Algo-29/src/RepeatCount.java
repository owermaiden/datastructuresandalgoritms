public class RepeatCount {

    public static void main(String[] args) {

    }

    public static int repeatCount(String str) {

        int[] indexes = new int[100];
        int count = 0;
        for (char eachChar : str.toLowerCase().toCharArray()) {
            indexes[eachChar - 48]++;
            if (indexes[eachChar - 48] == 2) {
                count++;
            }
        }
        return count;
    }
}
