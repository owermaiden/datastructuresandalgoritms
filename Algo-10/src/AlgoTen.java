import java.util.*;

public class AlgoTen {

    public static void main(String[] args) {
        String word = "Cydeo is the best!";
        String edgeCase = "    - hello%&/>   world...   Ower   ";
        System.out.println(reverseWords(word));
        System.out.println(reverseWords(edgeCase));
    }

    public static String reverseWords(String sentence){
        StringBuilder newWord = new StringBuilder();
        Stack<String> wordStack = new Stack<>();
        Stack<Integer> spaceStack = new Stack<>();

        // Edge case -> What is given String doesnt have any empty space...
        if (!sentence.contains(" ")) return sentence;

        String remainer = sentence;

        // Extract each word and push the in a stack<String>
        // Extract each empty spaces, count them and push to stack<Integer>...
        do {

            int index = remainer.indexOf(" ");
            String word = remainer.substring(0, index);
            remainer = remainer.substring(index);

            int counter = 0;
            for (char ch : remainer.toCharArray()) {
                if (ch == ' ') {
                    counter++;
                } else {
                    break;
                }
            }

            spaceStack.push(counter);
            wordStack.push(word);

            remainer = remainer.substring(counter);
        } while (remainer.contains(" "));

        // Edge case -> What if there is no " " at the end of the given String...
        wordStack.push(remainer);
        spaceStack.push(0);

        // Append stacked words and spaces one after another
        while (!wordStack.isEmpty()){

            newWord.append(String.join("", Collections.nCopies(spaceStack.pop(), " ")));
            newWord.append(wordStack.pop());

        }

        return newWord.toString();

    }
}
