import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String exp = "322+4*2";
        System.out.println(calculate(exp));
    }

    public static int calculate(String exp){
        Stack<Integer> intStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();
        boolean flag = true;

        for (char ch : exp.toCharArray()){

            if (Character.isDigit(ch) && flag){
                int current = Integer.parseInt(String.valueOf(ch));

                if (!tempStack.isEmpty()){
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

            } else if (!flag) {

                char operant = operatorStack.pop();
                int currentInt = Integer.parseInt(String.valueOf(ch));

                if (operant == '*') intStack.push(intStack.pop() * currentInt);
                if (operant == '/') intStack.push(intStack.pop() / currentInt);
                flag = true;

            }
        }

        while (!operatorStack.isEmpty()){

            int post = intStack.pop();
            char operant = operatorStack.pop();
            int pre = intStack.pop();
            intStack.push((operant == '+') ? pre + post : pre - post);
        }

        return intStack.pop();
    }
}
