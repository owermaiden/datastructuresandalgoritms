import java.util.ArrayList;
import java.util.HashMap;

import static java.util.Comparator.comparing;

public class AlgoOn4 {
    public static void main(String[] args) {
        String str = "clementisacap";
        String str2 = "abcdefghıjklmnoprs";
        String str3 = "clementisacapertyuılkjhgfd";
        System.out.println(maxSubstringFinder(str));

    }

    public static String maxSubstringFinder(String str){
        StringBuilder result = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<String> subStrings = new ArrayList<>();

        if (str.isEmpty()) return "";

        for (int i=0; i < str.length(); i++){                 // ---------O(n)------------------------------------------

            if (map.containsKey(str.charAt(i))){              // if iteration finds any dublicate word at this index....

                subStrings.add(result.toString());            // Add fabricated String to ArrayList....................
                result.setLength(0);                          // Clear String Builder........
                i = map.get(str.charAt(i));                   // Move i to first occurance of dublicated character.....
                map.clear();                                  // Clear HashMap.......................

            } else {

                result.append(str.charAt(i));                 // Until a dublicate exist...move pointer rigth and append new character
                map.put(str.charAt(i), i);                    // Put Character with its index..........................

                if (i == str.length() - 1) subStrings.add(result.toString());  // edge case -> end of String and no dublicate character

            }

        }

        System.out.println(subStrings);
        return subStrings.stream().max(comparing(String::length)).get();
    }
}
