import java.util.*;
import java.util.regex.Pattern;

public class Algo11 {
    public static void main(String[] args) {

        String pattern = "xxyxxy";
        String str = "gogopowerrangergogopowerranger";

        pattern = findPattern(pattern);  //--------------------------O(n)
        System.out.println(pattern);

        str = findPattern(str);
        System.out.println(str);

        System.out.println(findXY(pattern, str));    //--------------O(n)

    }

    public static String findPattern(String str) {      // find the pattern.......................
        Map<String, String> map = new LinkedHashMap<>();

        int i = 1;
        while (str.substring(i).contains(str.substring(0, i))) {

            map.put("pattern", str.substring(0,i++));

        }

        return map.get("pattern");
    }

    public static ArrayList<String> findXY(String pattern, String str){  //...........extract x and y from String

        ArrayList<String> exAndVay = new ArrayList<>();

        //
        String newStr = "";
        int i = 1;
        while (str.substring(i).contains(str.substring(0, i))){

            newStr = pattern.replace("x", str.substring(0,i++));

        }

        newStr = newStr.replace("y", "");

        Set<Character> set = new LinkedHashSet<>();
        for (char ch : newStr.toCharArray()){
            set.add(ch);
        }

        StringBuilder ex = new StringBuilder();
        for (Character ch : set) {
            ex.append(ch);
        }

        String vay = str.replace(ex,"");

        exAndVay.add(ex.toString());
        exAndVay.add(vay);

        return exAndVay;
    }





}
