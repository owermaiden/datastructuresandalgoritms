import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList {
    class Node {
        private Integer value;
        private Node next;
        private Node pre;

        public Node(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return ""+ value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void insertNode(int value){
        var node = new Node(value);
        if (isEmpty()){
            first = last = node;
            size++;
            return;
        }
        node.pre = last;
        last.next = node;
        last = node;
        size++;
    }

    public void deleteNodeFromEnd(){
        if (isEmpty()) return;

        if (first == last) {
            first = last = null;
            size--;
            return;
        }

        last = last.pre;
        last.next = null;
        size--;
    }

    private boolean isEmpty(){
        return this.first == null && this.last == null;
    }

    @Override
    public String toString() {
        var current = first;
        List<Integer> list = new ArrayList<>();
        while (current != null){
            list.add(current.value);
            current = current.next;
        }
        return list.toString();
    }
}
