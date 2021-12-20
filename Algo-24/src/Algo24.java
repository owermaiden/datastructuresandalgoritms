import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Algo24 {
    public static void main(String[] args) {
        String str = "3[ab]2[cb]";
        System.out.println(decodeIt(str));

    }
    public static String decodeItNested(String str) {

        Stack<Integer> integerStack = new Stack<>();
        Stack<String> wordStack = new Stack<>();
        String result = "";

        for (char ch : str.toCharArray()) {

            if (Character.isDigit(ch)) {
                integerStack.push(Integer.parseInt(String.valueOf(ch)));
            } else if (ch == '['){
                continue;
            } else if (ch == ']'){
                wordStack.push(result);
            } else {
                StringBuilder temp = new StringBuilder(result);
                temp.append(ch);
                result += temp;
            }

        }

            return "";
    }

    public static String decodeIt(String str){

        Stack<Integer> stack = new Stack<>();
        Stack<Character> parenthesisStack = new Stack<>();
        Map<Integer,String> map = new HashMap<>();

        StringBuilder temp = new StringBuilder();
        for (char ch : str.toCharArray()){

            if (Character.isDigit(ch)){

                stack.push(Integer.parseInt(String.valueOf(ch)));

            } else if (ch == '['){

                parenthesisStack.push(ch);

            } else if (ch == ']'){

                parenthesisStack.pop();

                if (parenthesisStack.isEmpty()){
                    map.put(stack.peek(), temp.toString());
                    temp.delete(0,temp.length());
                }
            } else {
                temp.append(ch);
            }

        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()){
            result.insert(0, map.get(stack.peek()).repeat(stack.pop()));
        }

        return result.toString();
    }



    public static String decodeRecursive(String str, int times){
        if (!str.contains("[")) {
            return str;
        }

        String inside = "";
        for ( char ch : str.toCharArray()){

            if (Character.isDigit(ch)) {

                times = Integer.parseInt(String.valueOf(ch));
                inside = getInsideParenthesis(str);
                decodeRecursive(inside, times);
                break;

            }
        }
        System.out.println(inside.repeat(times));
        return inside.repeat(times);
    }

    public static String getInsideParenthesis(String str){

        Pattern pattern = Pattern.compile("\\[(.*)\\]");
        Matcher matcher = pattern.matcher(str);

        return matcher.find() ? matcher.group(1) : "";
    }
}
