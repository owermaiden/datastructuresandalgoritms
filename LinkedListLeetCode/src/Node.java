
public class Node {
    int val;
    Node next;

    Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public void add(int val) {
        var node = new Node(val);
        Node current = this;
        if (this.val == 0 && this.next == null) {
            this.val = val;
            return;
        }
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }

    public Node addNodeInOrder(int val){
        var node = new Node(val);
        if (this.next == null){
            add(val);
            return this;
        }

        Node current = this;
        while(current.val > val || current.val < val){
            if (isRightPlace(current,node)) break;
            current = current.next;
        }

        node.next = current.next;
        current.next = node;
        return this;
    }

    private boolean isRightPlace(Node current, Node nodeToadd){
        return current.val <= nodeToadd.val && nodeToadd.val <= current.next.val ||
               current.val >= nodeToadd.val && nodeToadd.val <= current.next.val && isRealHead(current);
    }

    private boolean isRealHead(Node current){
        return current.val > current.next.val;
    }

    @Override
    public String toString() {
        return val +" --> " + next;
    }
}
