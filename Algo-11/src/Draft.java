import java.util.LinkedHashMap;
import java.util.Map;

public class Draft {


    public static Map<Character, String> findPattern(String pattern, String word) {

        Map<Character, String> map = new LinkedHashMap<>();
        String x;
        String y;

        for (int j = 0; j < 2;){

            int i = 1;
            if(word.substring(i).contains(word.substring(0, i))){

                while (word.substring(i).contains(word.substring(0, i))){

                    map.put(pattern.charAt(j), word.substring(0,i++));

                }

                x = map.get(pattern.charAt(j));
                word = word.replace(x, "");

            }
            map.put(pattern.charAt(++j), word);
        }

        return map;
    }
}
