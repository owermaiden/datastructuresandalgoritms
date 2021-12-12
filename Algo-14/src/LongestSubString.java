import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    public static void main(String[] args) {
        String testStr="clementisacap";
        System.out.println(longestSubstringWithoutDuplication(testStr));
    }
    // O(n) time | O(min(n, a)) space
    public static String longestSubstringWithoutDuplication(String str) {
        Map<Character, Integer> lastSeen = new HashMap<Character, Integer>();
        int longestStart =0;
        int longestEnd =1;
        int currentStartIdx = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (lastSeen.containsKey(c)) {
                currentStartIdx = Math.max(currentStartIdx, lastSeen.get(c) + 1);
            }
            // if you find a longer substring update longest here!!!
            if (longestEnd - longestStart < i + 1 - currentStartIdx) {
                longestEnd = i + 1;
                longestStart=currentStartIdx;
            }
            lastSeen.put(c, i);
        }
        String result = str.substring(longestStart, longestEnd);
        return result;
    }
}