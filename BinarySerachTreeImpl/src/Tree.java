import java.util.*;
import java.util.stream.Collectors;

public class Tree {
    private class Node{
        private Node leftChild;
        private Node rightChild;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    private Node root;

    public void insertTree(int value){
        Node node = new Node(value);
        if (root == null){
            root = node;
            return;
        }

        Node current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }  //------------------- End of Insert---------------------------

    public void traversePreOrder(){
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root){
        if (root == null) return;
        System.out.println(root.value);

        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }
    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if (root == null) return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if (root == null) return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public void traverseLevelOrder() {
        for (var i = 0; i <= height(); i++) {
            for (var value : getNodesAtDistance(i))
                System.out.print(" | " + value);
        }
    }

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null)
            return;

        if (distance == 0) {
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);
    }

    // ------------------- traverse breadth first another approach ----------------------------
    public void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.value + " ");

            /*add left child to the queue */
            if (tempNode.leftChild != null) {
                queue.add(tempNode.leftChild);
            }

            /*add right right child to the queue */
            if (tempNode.rightChild != null) {
                queue.add(tempNode.rightChild);
            }
        }
    }

    //------------------- End of Traversals---------------------------

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;

        if (isLeaf(root))
            return 0;

        return 1 + Math.max(
                height(root.leftChild),
                height(root.rightChild));
    }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }
    // O(log n)

    public int min() {
        if (root == null)
            throw new IllegalStateException();

        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }
    // O(n)

    private int min(Node root) {
        if (isLeaf(root))
            return root.value;

        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    public int max() {
        if (root == null)
            throw new IllegalStateException();

        return max(root);
    }

    private int max(Node root) {
        if (root.rightChild == null)
            return root.value;

        return max(root.rightChild);
    }

    public boolean equals(Tree other) {
        if (other == null)
            return false;

        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return true;

        if (first != null && second != null)
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);

        return false;
    }
    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.value < min || root.value > max)
            return false;

        return
                isBinarySearchTree(root.leftChild, min, root.value - 1)
                        && isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

//--------------------------------getNodesAtDistance-----------------------------------------------------------------



    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null)
            return 0;

        if (isLeaf(root))
            return 1;

        return 1 + size(root.leftChild) + size(root.rightChild);
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node root) {
        if (root == null)
            return 0;

        if (isLeaf(root))
            return 1;

        return countLeaves(root.leftChild) + countLeaves(root.rightChild);
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node root, int value) {
        if (root == null)
            return false;

        if (root.value == value)
            return true;

        return contains(root.leftChild, value) || contains(root.rightChild, value);
    }

    public boolean areSibling(int first, int second) {
        return areSibling(root, first, second);
    }

    private boolean areSibling(Node root, int first, int second) {
        if (root == null)
            return false;

        var areSibling = false;
        if (root.leftChild != null && root.rightChild != null) {
            areSibling = (root.leftChild.value == first && root.rightChild.value == second) ||
                    (root.rightChild.value == first && root.leftChild.value == second);
        }

        return areSibling ||
                areSibling(root.leftChild, first, second) ||
                areSibling(root.rightChild, first, second);
    }

    public int findLeastCommonAncestor(int value1, int value2){
        List<Integer> firstValueAncestors = getAncestors(value1);
        List<Integer> secondValueAncestor = getAncestors(value2);

        int result = firstValueAncestors.stream()
                .filter(secondValueAncestor::contains)
                .mapToInt(v -> v)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        return firstValueAncestors.contains(value2) ? value2 : secondValueAncestor.contains(value1) ? value1 : result ;

    }

    public List<Integer> getAncestors(int value) {
        var list = new ArrayList<Integer>();
        if (value == root.value){
            list.add(value);
            return list;
        }
        getAncestors2(root, value, list);
        return list;
    }

    private boolean getAncestors(Node root, int value, List<Integer> list) {
        // We should traverse the tree until we find the target value.
        // If find the target value, we return true without adding the current node
        // to the list; otherwise, if we ask for ancestors of 5, 5 will be also
        // added to the list.
        if (root == null)
            return false;

        if (root.value == value)
            return true;

        // If we find the target value in the left or right sub-trees, that means
        // the current node (root) is one of the ancestors. So we add it to the list.
        if (getAncestors(root.leftChild, value, list) || getAncestors(root.rightChild, value, list)) {
            list.add(root.value);
            return true;
        }

        return false;
    }

    private void getAncestors2(Node root, int value, List<Integer> list){
        if (root == null) return;

        while (root.value != value){

            if (value < root.value){
                    list.add(root.value);
                    root = root.leftChild;
            } else {
                    list.add(root.value);
                    root = root.rightChild;
            }
        }
        Collections.reverse(list);
    }
    // ---------------------------------------helpers-----------------------------------------------------------

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node root) {
        if (root == null)
            return true;

        var balanceFactor = height(root.leftChild) - height(root.rightChild);

        return Math.abs(balanceFactor) <= 1 &&
                isBalanced(root.leftChild) &&
                isBalanced(root.rightChild);
    }

    public boolean isPerfect() {
        return size() == (Math.pow(2, height() + 1) - 1);
    }

    //------------------------------------------------------remove leafs----------------------------------------------
    public List<List<Integer>> getLeaves(){
        List<List<Integer>> result = new ArrayList<>();
        while (root != null){
            List<Integer> leafs = new ArrayList<>();
            getLeaves(root, leafs);
            result.add(leafs);
            if (root.rightChild == null && root.leftChild == null) {
                result.add(new ArrayList<>(Arrays.asList(root.value)));
                break;
            }
        }
        return result;
    }

    private void getLeaves(Node node, List<Integer> list){
        if (node == null) {
            return;
        }

        if (node.leftChild == null && node.rightChild == null){
            list.add(node.value);
            deleteLeaf(node);
        }
        getLeaves(node.leftChild, list);
        getLeaves(node.rightChild, list);
    }

    public void deleteLeaf(Node leaf){
        if (!isLeaf(leaf)) throw new IllegalArgumentException("This is not a leaf");
        deleteLeaf(root, leaf);
    }
    private void deleteLeaf(Node root, Node leaftoDelete){
        if (root.rightChild == null && root.leftChild == null) return;

        if (root.rightChild != null && root.rightChild.value == leaftoDelete.value){
            root.rightChild = null;
            return;
        } else if (root.leftChild != null && root.leftChild.value == leaftoDelete.value){
            root.leftChild = null;
            return;
        }
        deleteLeaf(root.leftChild, leaftoDelete);
        deleteLeaf(root.rightChild, leaftoDelete);

    }

    // ----------------------------- sum of leafs---------------------------------------------------------------

    public List<Integer> calculateBranchSums(){
        List<Integer> sums = new ArrayList<>();
        if(root==null) return sums;
        branchSums(root, 0, (ArrayList<Integer>) sums);
        return sums;
    }
    public void branchSums(Node node, int tempSum, ArrayList<Integer> sumsList){
        if (node == null) return;
        tempSum += node.value;
        if (node.leftChild == null && node.rightChild == null) {
            sumsList.add(tempSum);
        }
        branchSums(node.leftChild, tempSum, sumsList);
        branchSums(node.rightChild, tempSum, sumsList);
    }
    // ------------------------------------ total distance------------------------------------------------------------

    public int calculateTotalDistance2(){
        List<Integer> distances = new ArrayList<>();
        Node node = root;
        int distance = 0;
        calculateTotalDistance2(node, distance, distances);
        return distances.stream().reduce(0,Integer::sum);
    }
    private void calculateTotalDistance2(Node root, int distance, List<Integer> distances){
        if (root == null) return;
        distances.add(distance++);
        calculateTotalDistance2(root.leftChild, distance, distances);
        calculateTotalDistance2(root.rightChild, distance, distances);
    }
    //------------------------------inverse the tree-----------------------------------------------------------------

    public void inverseTree(){
        inverseTree2(root);
    }

    private void inverseTree2(Node root){
        if (root==null) return;

        Node temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;

        inverseTree2(root.leftChild);
        inverseTree2(root.rightChild);

    }
    //------------------------------print----------------------------------------------------------------------------
    public static void showTrunks(Trunk p)
    {
        if (p == null) {
            return;
        }

        showTrunks(p.prev);
        System.out.print(p.str);
    }
    public void printTree(){
        printTree(root, null, false);
    }
    private void printTree( Node root, Trunk prev, boolean isLeft)
    {
        if (root == null) {
            return;
        }

        String prev_str = "    ";
        Trunk trunk = new Trunk(prev, prev_str);

        printTree(root.rightChild, trunk, true);

        if (prev == null) {
            trunk.str = "———";
        }
        else if (isLeft) {
            trunk.str = ".———";
            prev_str = "   |";
        }
        else {
            trunk.str = "`———";
            prev.str = prev_str;
        }

        showTrunks(trunk);
        System.out.println(" " + root.value);

        if (prev != null) {
            prev.str = prev_str;
        }
        trunk.str = "   |";

        printTree(root.leftChild, trunk, false);
    }
}
