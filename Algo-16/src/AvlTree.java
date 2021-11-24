public class AvlTree {

    private class AVLNode {
        private int height;
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;
        private int childCount;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Value=" + this.value;
        }
    }

    // --------------------------AVL TREE CLASS-------------------------------------------------------------------
    private AVLNode root;
    private int size;


    // ---------------------------MAIN METHODS--------------------------------------------------------------------
    public void insert(int... keys) {
        for (int key : keys) {
            root = insert(root, key);
        }
    }

    public void insert(int value) { root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value) {
        if (root == null){
            ++size;
            return new AVLNode(value);
        }

        if (value < root.value)
            root.leftChild = insert(root.leftChild, value);
        else
            root.rightChild = insert(root.rightChild, value);

        setHeightAndChildCount(root);

        return balance(root);
    }


    private AVLNode balance(AVLNode root) {
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.leftChild) < 0)
                root.leftChild = rotateLeft(root.leftChild);
            return rotateRight(root);
        }
        else if (isRightHeavy(root)) {
            if (balanceFactor(root.rightChild) > 0)
                root.rightChild = rotateRight(root.rightChild);
            return rotateLeft(root);
        }
        return root;
    }

    private AVLNode rotateLeft(AVLNode root) {
        var newRoot = root.rightChild;

        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        setHeightAndChildCount(root);
        setHeightAndChildCount(newRoot);

        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root) {
        var newRoot = root.leftChild;

        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeightAndChildCount(root);
        setHeightAndChildCount(newRoot);

        return newRoot;
    }

    private void setHeightAndChildCount(AVLNode node) {
        node.height = Math.max(
                height(node.leftChild),
                height(node.rightChild)) + 1;

        node.childCount = 0;
        if (node.leftChild != null) {
            node.childCount = node.leftChild.childCount + 1;
        }
        if (node.rightChild != null) {
            node.childCount += node.rightChild.childCount + 1;
        }
    }

    private AVLNode getNodeAtIndex(AVLNode root, int index) {
        AVLNode current = root;

        for (;;) {
            int leftSubtreeSize = getLeftSubtreeSize(current);

            if (index == leftSubtreeSize) {
                return current;
            }

            if (index > leftSubtreeSize) {
                index -= (leftSubtreeSize + 1);
                current = current.rightChild;
            } else {
                current = current.leftChild;
            }
        }
    }

    private int getLeftSubtreeSize(AVLNode node) {
        int tmp = node.childCount;

        if (node.rightChild != null) {
            tmp -= (node.rightChild.childCount + 1);
        }
        return tmp;
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    // ---------------------------OTHER METHODS--------------------------------------------------------------------

    public double getMedian() {
        if (size == 0) {
            throw new IllegalStateException(
                    "Asking for median from an empty tree.");
        }

        if (size % 2 == 0) {
            int b = getNodeAtIndex(root, size / 2 - 1).value;
            int a = getNodeAtIndex(root, size / 2).value;
            return 0.5 * (a + b);
        } else {
            return getNodeAtIndex(root, size / 2).value;
        }
    }

    @Override
    public String toString() {
        return "root = " + root.value
                + " rigth child = " + root.rightChild.value
                + " left child = " + root.leftChild.value ;
    }
}
