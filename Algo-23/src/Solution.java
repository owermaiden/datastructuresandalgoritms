import java.util.Stack;

public class Solution {

    public String decodeString(String string) {
        String decoded = "";
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> decodedStack = new Stack<>();
        int count = 0;

        while (count < string.length()) {
            if (Character.isDigit(string.charAt(count))) {
                int fullNum = 0;

                while (Character.isDigit(string.charAt(count))) {
                    fullNum = 10 * fullNum + (string.charAt(count) - '0');
                    count++;
                }

                numberStack.push(fullNum);

            } else if (string.charAt(count) == '[') {
                decodedStack.push(decoded);
                decoded = "";
                count++;

            } else if (string.charAt(count) == ']') {
                StringBuilder temp = new StringBuilder(decodedStack.pop());
                int repeatTimes = numberStack.pop();

                for (int iter = 0; iter < repeatTimes; iter++)
                    temp.append(decoded);

                decoded = temp.toString();
                count++;

            } else
                decoded += string.charAt(count++);
        }

        return decoded;
    }
}
