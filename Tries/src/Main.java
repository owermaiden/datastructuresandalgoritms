public class Main {
    public static void main(String[] args) {
        Trie trie =  new Trie();
        trie.insert("hello");
        trie.insert("world");
        trie.printWords();
    }
}
