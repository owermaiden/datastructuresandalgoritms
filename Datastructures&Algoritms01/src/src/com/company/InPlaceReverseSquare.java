package src.com.company;

import java.util.Arrays;
import java.util.Stack;

public class InPlaceReverseSquare {
    public static void main(String[] args) {
        int[][] square = {{1, 2, 3 ,4 }, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        System.out.println(Arrays.deepToString(square));

        for (int i = 0; i <= 3; i++){
            for (int j = i; j <= 3 ; j++){
                int dummy = square[i][j];
                square[i][j] = square[j][i];
                square[j][i] = dummy;
            }
            rowReverse(square[i]);
        }
        System.out.println(Arrays.deepToString(square));
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
