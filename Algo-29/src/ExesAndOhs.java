public class ExesAndOhs {
    public static void main(String[] args) {
        String word = "xooxx";
        System.out.println(isBalanced(word));

    }

    public static boolean isBalanced(String word){

        int xCount = 0;
        int oCount = 0;
        // bütün karakterleri say

        for (Character ch : word.toCharArray()) {
            if (ch == 'x' || ch == 'X'){
                xCount++;
            } else if(ch == 'o' || ch == 'O'){
                oCount++;
            }
        }
        return xCount == oCount;
    }
}
