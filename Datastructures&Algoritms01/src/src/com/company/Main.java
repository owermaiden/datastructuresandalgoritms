package src.com.company;

import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] square = {1, 2, 3 ,4};

        System.out.println(Arrays.toString(rowReverse(square)));
    }

    public static int[] rowReverse(int[] numbers){

        Stack<Integer> myStack = new Stack<>();
        for (int j : numbers) { myStack.push(j);}
        var reversedSquare = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++){
            reversedSquare[i] = myStack.pop();
        }

        return reversedSquare;
    }
}
