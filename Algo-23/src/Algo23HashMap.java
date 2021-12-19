import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Algo23HashMap {
    public static void main(String[] args) {

    }

    static boolean isBalanced(String str){

        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();

        for(Character ch:str.toCharArray()){
            if(map.containsKey(ch)){
                if(stack.empty() || stack.pop()!=map.get(ch)) return false;
            }else if(ch.equals('(') || ch.equals('[') || ch.equals('{')) stack.push(ch);
        }

        return stack.size()==0;
    }
}
