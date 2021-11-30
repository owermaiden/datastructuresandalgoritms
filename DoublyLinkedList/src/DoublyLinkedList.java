import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList {
    private class Node {
        private int value;
        private Node next;
        private Node pre;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return ""+ value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void setTail(int value){
        setTail(new Node(value));
    }
    private void setTail(Node node) {
        if (isEmpty()){
            head = tail = node;
            size++;
            return;
        }
        if (head == tail){
            node.pre = tail;
            tail.next = node;
            tail = node;
            size++;
            return;
        }
        insertAfter(tail, node);
    }

    public void setHead(int value){
        setHead(new Node(value));
    }
    private void setHead(Node node) {
        if (isEmpty()){
            head = tail = node;
            size++;
            return;
        }
        insertBefore(head, node);

    }
    //---------------------------------------------------------------------Insert Before--------------------------------
    public void insertBefore(int target, int value){
        if (isEmpty()) throw new IllegalArgumentException();

        Node newNode = new Node(value);
        if (head == tail && head.value == target ) {
            newNode.next = tail;
            head = newNode;
            tail.pre = head;
            size++;
            return;
        }
        insertBefore(new Node(target), newNode);
    }

    private void insertBefore(Node node, Node nodeToInsert) {
        if (node.value == head.value){
            nodeToInsert.next = head;
            head.pre = nodeToInsert;
            head = nodeToInsert;
            size++;
            return;
        } else if (node.value == tail.value){
            nodeToInsert.next = tail;
            tail.pre.next = nodeToInsert;
            nodeToInsert.pre = tail.pre;
            tail.pre = nodeToInsert;
            size++;
            return;
        }

        Node current = head;
        while (current.value != node.value){
            if (current.next == null) throw new IllegalArgumentException("There is no such element to insert..");
            current = current.next;
        }
        nodeToInsert.next = current;
        current.pre.next = nodeToInsert;
        nodeToInsert.pre = current.pre;
        current.pre = nodeToInsert;
        size++;
    }
    //---------------------------------------------------------------------Insert After--------------------------------
    public void insertAfter(int target, int value){
        if (isEmpty()) throw new IllegalArgumentException();

        Node newNode = new Node(value);
        if (head == tail && head.value == target){
            newNode.pre = tail;
            tail.next = newNode;
            tail = newNode;
            size++;
            return;
        }
        insertAfter(new Node(target), newNode);

    }

    private void insertAfter(Node node, Node nodeToInsert) {
        if ( node.value == head.value ){
            nodeToInsert.next = head.next;
            head.next.pre = nodeToInsert;
            head.next = nodeToInsert;
            nodeToInsert.pre = head;
            size++;
            return;
        } else if ( node.value == tail.value){
            nodeToInsert.pre = tail;
            tail.next = nodeToInsert;
            tail = nodeToInsert;
            size++;
            return;
        }

        Node current = head;
        while (current.value != node.value){
            if (current.next == null) throw new IllegalArgumentException("There is no such element to insert..");
            current = current.next;
        }

        nodeToInsert.next = current.next;
        current.next.pre = nodeToInsert;
        current.next = nodeToInsert;
        nodeToInsert.pre = current;
        size++;

    }
    //---------------------------------------------------------------------Insert At position--------------------------
    public void insertAtPosition(int position, int value){
        if (position > size) throw new IllegalStateException("This list is smaller than you think...");
        insertAtPosition(position, new Node(value));
    }
    private void insertAtPosition(int position, Node nodeToInsert) {
        Node current = head;
        for (int i = 0; i < position; i++){
            current = current.next;
        }
        insertBefore(current, nodeToInsert);
    }
    //------------------------------------------------Delete From End--------------------------------------------------
    public void deleteNodeFromEnd(){
        if (isEmpty()) return;

        if (head == tail) {
            head = tail = null;
            size--;
            return;
        }

        tail = tail.pre;
        tail.next = null;
        size--;
    }

    public void removeNodesWithValue(int value) {
        // Write your code here.
    }
    public void remove(Node node) {
        // Write your code here.
    }

    public int indexOf(int value) {
        // Write your code here.
        return -1;
    }
    public boolean containsNodeWithValue(int value) {
        Node current = head;
        return false;
    }

    private boolean isEmpty(){
        return this.head == null && this.tail == null;
    }

    @Override
    public String toString() {
        var current = head;
        List<Integer> list = new ArrayList<>();
        while (current != null){
            list.add(current.value);
            current = current.next;
        }
        return list.toString();
    }
}