import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MyStack<T> {

    private class Node {
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }

    public Node bottom;
    public Node top;
    private int size;

    public void push(T value){
        Node item = new Node(value);
        if (isEmpty()){
            bottom = top = item;
            size++;
            return;
        }
        top.next = item;
        top = item;
        size++;
    }

    public T peek(){
        return top.value;
    }

    public T pop(){
        Node result;
        if(isEmpty()) throw new NoSuchElementException();

        if (bottom == top){
            result = bottom;
            bottom = top = null;
            size = 0;
            return result.value;
        }

        Node current = bottom;
        while (current.next != top){
            current = current.next;
        }
        result = top;
        top = current;
        top.next = null;
        size--;
        return result.value;
    }

    public boolean isEmpty(){
        return bottom == null;
    }

    @Override
    public String toString() {
        Node current = this.bottom;
        List<Node> list = new ArrayList<>();
        while (current != null){
            list.add(current);
            current = current.next;
        }
        return list.toString();
    }





}
