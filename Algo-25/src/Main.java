import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String exp = "322+48/2*2";
        System.out.println(calculate(exp));
        int x = 322 + 48 / 2 * 2;
        System.out.println(x);
    }

    public static int calculate(String exp){
        Stack<Integer> intStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();                           // stack for calculating more than one digit integers
        boolean flag = true;                                                // if we encounter * or / then do this operation at once "flag = false"

        for (char ch : exp.toCharArray()){

            if (Character.isDigit(ch) && flag){
                int current = Integer.parseInt(String.valueOf(ch));

                if (!tempStack.isEmpty()){                                  // calculate more than one digit integers
                    tempStack.push(intStack.pop() * 10 + current);
                    intStack.push(tempStack.peek());
                    continue;
                }
                tempStack.push(current);
                intStack.push(current);

            } else if (ch == '+' || ch == '-'){

                operatorStack.push(ch);
                tempStack.clear();

            } else if (ch == '*' || ch == '/'){

                operatorStack.push(ch);
                flag = false;
                tempStack.clear();

            } else if (!flag) {                                             // if we encounter "*" or "/" then iteration goes into this if statement

                char operant = operatorStack.pop();
                int current = Integer.parseInt(String.valueOf(ch));

                if (operant == '*') intStack.push(intStack.pop() * current);
                if (operant == '/') intStack.push(intStack.pop() / current);
                flag = true;
            }
        }

        while (!operatorStack.isEmpty()){

            int pre = intStack.remove(0);
            char operant = operatorStack.remove(0);
            int post = intStack.remove(0);
            intStack.push((operant == '+') ? pre + post : pre - post);
        }
        return intStack.pop();
    }
}
