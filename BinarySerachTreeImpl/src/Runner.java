public class Runner {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insertTree(10);
        tree.insertTree(8);
        tree.insertTree(7);
        tree.insertTree(9);
        tree.insertTree(13);
        tree.insertTree(14);
        tree.insertTree(12);
        tree.insertTree(11);
        tree.insertTree(16);
        tree.printTree();
        System.out.println("tree.findLeastCommonAncestor = " + tree.findLeastCommonAncestor(7, 9));

    }
}
