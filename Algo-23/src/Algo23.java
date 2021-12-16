import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Algo23 {
    public static void main(String[] args) {
        String str = "676jh[f(+)']^^";
        System.out.println(isBalanced(str));
    }
    public static boolean isBalanced(String str){
        ArrayList<Character> openingParenthesis = new ArrayList<>(Arrays.asList('{', '(', '['));
        ArrayList<Character> closingParenthesis = new ArrayList<>(Arrays.asList('}', ')', ']'));
        Stack<Character> stack = new Stack<>();
        for(char ch : str.toCharArray()){
            if (openingParenthesis.contains(ch)) stack.push(ch);                                                // push to stack the opening parenthesis
            if (closingParenthesis.contains(ch)) {                                                              // pop from stack if it is closing parenthesis
                if (stack.empty()) return false;                                                                // then our string is unbalanced
                var top = stack.pop();
                if (openingParenthesis.indexOf(top) != closingParenthesis.indexOf(ch)) return false;            // control if the symbols match
            }
        }
        return stack.empty();
    }
}
