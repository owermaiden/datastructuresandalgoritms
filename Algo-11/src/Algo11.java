import java.util.*;
import java.util.regex.Pattern;

public class Algo11 {
    public static void main(String[] args) {

        Triea pattern = new Triea();

        String str1 = "yxx";
        String str2 = "merhabamerhabayalan";
        pattern.insert(str1);

        System.out.println(findPattern(str1, str2));

    }

    public static List<String> findPattern(String pattern, String word) {

        List<String> result = new ArrayList<>();
        Map<Character, String> map = new LinkedHashMap<>();

        int i = 1;
        while (word.substring(i).contains(word.substring(0, i))){

            map.put(pattern.charAt(0), word.substring(0,i++));

        }
        String x = map.get(pattern.charAt(0));
        String y = word.replace(x, "");

        result.add(x);
        result.add(y);
        return result;


    }
}
