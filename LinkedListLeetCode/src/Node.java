import java.util.ArrayList;
import java.util.List;

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
            if (isRigthPlace(current,node)) break;
            current = current.next;
        }

        node.next = current.next;
        current.next = node;
        return this;
    }

    private boolean isRigthPlace(Node head, Node nodeToadd){
        return head.val > nodeToadd.val && head.next.val <  nodeToadd.val ||
               head.val <  nodeToadd.val && head.next.val >  nodeToadd.val ||
               head.val== nodeToadd.val;
    }

    @Override
    public String toString() {
        return val +" --> " + next;
    }
}
