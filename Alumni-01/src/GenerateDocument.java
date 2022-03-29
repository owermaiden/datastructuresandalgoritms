import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

    public static void main(String[] args) {
        String characters = "!veDJaCyd vaeo perelo xw";
        String document = "Cydeo Java Developer!";

        System.out.println("These documents are " + compareDocument(characters, document));

    }

    static boolean compareDocument(String characters, String document){

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : characters.toCharArray()){
            map.putIfAbsent(ch, 1);
            map.computeIfPresent(ch, (k , v) -> v++);
        }

        for (char ch : document.toCharArray()){
            if (!map.containsKey(ch) || map.get(ch) == 0) return false;
            map.computeIfPresent(ch, (k,v) -> v--);
        }
        return true;
    }
}
