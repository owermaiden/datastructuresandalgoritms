package MyTree;

public class TreeApp {
    public static void main(String[] args) {
        MyTree tree=new MyTree();
        int[] numbers=new int[] {10, 5, 12, 3, 6, 11, 13, 2};
        for (int i = 0; i <8; i++) {
            tree.insert(numbers[i]);
        }
        VisualizeTree.printTree(tree.root, null,false);
        System.out.println(tree.findSumOfLeavesR(tree.root));
        tree.printLeaves(tree.root);
        System.out.println(tree.CalculateSumNodeDepths());
      /* System.out.println("Pre-Order Traversal");
        tree.preOrderTraversal(tree.root);
        System.out.println();
        System.out.println("In-Order Traversal");
        tree.inOrderTraversal(tree.root);
        System.out.println();
        System.out.println("Post-Order Traversal");
        tree.postOrderTraversal(tree.root);
        System.out.println();
       System.out.println("Level-Order Traversal");
        tree.levelOrderTraversal(tree.root);*/
    }
}