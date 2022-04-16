package MyTree;

import java.util.LinkedList;
import java.util.Queue;

public class MyTree {
    public Node root;

    public MyTree() {
    }

    public MyTree(Node root) {
        this.root = root;
    }
    public void insert(int value){
        Node newNode=new Node(value);
        if(root==null) {
            root=newNode;
            return;
        }
        Node current=root;
        while(true){
            if(value<=current.value) {
                if (current.leftChild==null) {
                    current.leftChild=newNode;
                    break;
                }
                current=current.leftChild;
            }
            else  {
                if (current.rightChild==null) {
                    current.rightChild=newNode;
                    break;
                }
                current=current.rightChild;
            }

        }
    }// end insert

    // PreOrder Traversal of Tree  Root-Left-Right

    public void preOrderTraversal(Node root){
        if (root==null) return;
        System.out.print(root.value+", ");
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
    }
    // In-Order Traversal of Tree  Root-Left-Right
    public void inOrderTraversal(Node root){
        if (root==null) return;
        inOrderTraversal(root.leftChild);
        System.out.print(root.value+", ");
        inOrderTraversal(root.rightChild);
    }
    // Post-Order traversal  Left-Right-Root
    public void postOrderTraversal(Node root){
        if (root==null) return;
        postOrderTraversal(root.leftChild);
        postOrderTraversal(root.rightChild);
        System.out.print(root.value+", ");

    }
    public void levelOrderTraversal(Node root){
        if (root==null) return;
        Queue<Node> queue= new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node toVisit= queue.poll();
            System.out.print(toVisit.value+", ");
            if(toVisit.leftChild!=null) {
                queue.add(toVisit.leftChild);
            }
            if(toVisit.rightChild!=null) {
                queue.add(toVisit.rightChild);
            }
        }// end while
    }// end levelorder
    // Task 1 : find an integer value
    public boolean find(int value){
        if (root==null) return false;
        Node current=root;
        while(current!=null){
            if (value<current.value) current=current.leftChild;
            else if(value>current.value) current=current.rightChild;
            else return true;
        }
        return false;
    }
    // Task 2 : isLeaf
    public boolean isLeaf(Node node) {
        return (node.leftChild==null && node.rightChild==null);
    }
    // Task 3 : Print Leaves of BST
    public void printLeaves(Node root) {
        if (root==null) return;
        if (isLeaf(root)) {System.out.print(root.value+", ");}
        printLeaves(root.leftChild);
        printLeaves(root.rightChild);

    }
    // Task 4 : Count Leaves of BST
    public int countLeaves(Node root) {
        if (root == null)
            return 0;

        if (isLeaf(root))
            return 1;

        return countLeaves(root.leftChild) + countLeaves(root.rightChild);
    }
    // Task 5 : Find Sum of Leaf values of a BST
    public int findSumOfLeavesR(Node root) {
        if (root==null) return 0;
        if (isLeaf(root)) return root.value;
        return findSumOfLeavesR(root.leftChild)+findSumOfLeavesR(root.rightChild);

    }

    // Task 6 : Return height of a Node in BST
    public int height(Node root) {
        if (root == null)
            return -1;

        if (isLeaf(root))
            return 0;

        return 1 + Math.max(
                height(root.leftChild),
                height(root.rightChild));
    }

    // Task 7 : Sum of Node Depths of a BST
    public int CalculateSumNodeDepths(){
        return nodeDepthSums(root,0);
    }
    public int nodeDepthSums(Node node, int sums){
        if(node==null) return 0;
        System.out.println(sums);
        return sums+ nodeDepthSums(node.leftChild,sums+1)+nodeDepthSums(node.rightChild,sums+1);
    }
}