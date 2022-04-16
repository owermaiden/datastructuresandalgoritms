public class Runner {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(10);
        tree.insert(6);
        tree.insert(8);
        tree.insert(12);
        tree.insert(24);
        tree.insert(7);
        tree.insert(9);
        tree.insert(3);
        tree.insert(1);

        tree.printTree();
    }
}
