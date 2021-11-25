public class Runner {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insertTree(10);
        tree.insertTree(5);
        tree.insertTree(3);
        tree.insertTree(7);
        tree.insertTree(6);
        tree.insertTree(12);
        tree.insertTree(11);
        tree.insertTree(20);
        tree.traversePreOrder();
        //tree.traverseInOrder();
        System.out.println(tree);
    }
}
