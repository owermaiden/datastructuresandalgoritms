import java.util.ArrayList;
import java.util.List;

public class LinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return ""+ this.value;
        }
    }


    private int count;
    private Node first;
    private Node last;

    public void addNodeEnd(int value){
        Node item = new Node(value);
        if (isEmpty()){
            first = last = item;
            this.count++;
        }
        last.next = item;
        last = item;
        count++;
    }

    public void removeFromEnd(){
        if(isEmpty()) return;

        if (first == last){
            first = last = null;
            count = 0;
        }
        Node current = first;
        while (current.next != last){
            current = current.next;
        }
        last = current;
        last.next = null;
        count--;
    }

    public boolean isEmpty(){
        return first == null;
    }

    @Override
    public String toString() {
        Node current = this.first;
        List<Node> list = new ArrayList<>();
        while (current != null){
            list.add(current);
            current = current.next;
        }
        return list.toString();
    }
}
