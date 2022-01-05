public class Runner {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insertTree(10);
        tree.insertTree(8);
        tree.insertTree(12);
        tree.insertTree(9);
        tree.insertTree(7);

        System.out.println("tree.removeLeafs() = " + tree.getLeaves());

    }
}
