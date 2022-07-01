public class MyTree2 {
    public Node root;

    public MyTree2() {
    }

    public MyTree2(Node root) {
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


    public int findLeastCommonAncestor(Node root, int p, int q){

        int rootValue = root.value;

        if (rootValue > p && rootValue > q){

            return findLeastCommonAncestor(root.leftChild, p, q);

        } else if (rootValue < p && rootValue < q){

            return findLeastCommonAncestor(root.rightChild, p, q);

        } else {

            return root.value;
        }


    }


}
