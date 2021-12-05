import java.util.*;

public class MyLinkedList {

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
            return;
        }
        last.next = item;
        last = item;
        count++;
    }

    public void insertBegining(int value){
        Node item = new Node(value);

        if (isEmpty()){
            first = last = item;
            this.count++;
            return;
        }

        if (first == last){
            item.next = first;
            first = item;
            count++;
            return;
        }

        item.next = first;
        first = item;
        count++;
    }

    public void removeFromEnd(){
        if(isEmpty()) return;

        if (first == last){
            first = last = null;
            count = 0;
            return;
        }
        Node current = first;
        while (current.next != last){
            current = current.next;
        }
        last = current;
        last.next = null;
        count--;
    }

    public void removeFromBegining(){
        if(isEmpty()) return;

        if (first == last){
            first = last = null;
            count = 0;
            return;
        }

        first = first.next;
        count--;
    }

    public void reverseLinkedList(){
        if (isEmpty() || first == last) throw new RuntimeException();

        Node prev = first;
        Node curr = first.next;        //  10   ->    20   ->   30
                                       //   p   <-    c          n
        while(curr != null){           //             p    <-    c         n
            Node nexT = curr.next;     //                        p         c        n
            curr.next = prev;
            prev = curr;
            curr = nexT;
        }

        last = first;
        last.next = null;
        first = prev;

    }

    public int findTheKthNodeFromEnd(int value){
        if(isEmpty()) throw new RuntimeException();

        if(first == last) return 0;

        Node p1 = first;
        Node p2 = first;

        int distance = 0;
        while (true){
            p1 = p1.next;
            p2 = p1;
            if (p1.value == value){
                while (p2 != null){
                    p2 = p2.next;
                    distance++;
                }
                break;
            }
        }

        return distance;

    }

    public ArrayList<Integer> getMiddleNode(){
        if (isEmpty()) throw new RuntimeException();
        ArrayList<Integer> nodeList = new ArrayList<>();

        if (first == last) {
            nodeList.add(first.value);
            return nodeList;
        }

        Node current = first;
        for (int i = 0; i < count / 2 - 1 ; i++){
            current = current.next;
        }
        if (count % 2 == 1){
            nodeList.add(current.next.value);
            return nodeList;
        } else {
            nodeList.add(current.value);
            nodeList.add(current.next.value);
            return nodeList;
        }

    }

    public void insertInOrder(int value){
        Node item = new Node(value);
        if (isEmpty()){
            first = last = item;
            this.count++;
            return;
        } else if (value <= first.value){
            insertBegining(value);
        } else {
            Node current = first;
            while (current.next != null) {
                if (current.value < value && current.next.value > value){
                    item.next = current.next;
                    current.next = item;
                    break;
                }
                current = current.next;
            }
            current.next = item;
            last = item;
        }
        count++;

    }

    public int findIndexOfNode ( int value ){
        int index = 0;
        Node current = first;
        while (current != null){
            if(current.value == value) return ++index;
            current = current.next;
            index++;
        }
        return -1;
    }

    // --------------------------------------------------------Algo-17----------------------------------------------
    public static void removeDublicates(MyLinkedList list){
        Map<Integer, Node> map = new HashMap<>();

        var current = list.first;
        while (current != null){

            if (!map.containsKey(current.value)){
                map.put(current.value, current);
                current = current.next;
                continue;
            }
            Node prev = map.get(current.value);
            prev.next = current.next;
            current = current.next;
        }
    }

    public static MyLinkedList twoNumbersSum(MyLinkedList list1, MyLinkedList list2){

        Node current1 = list1.first;
        Node current2 = list2.first;
        MyLinkedList result = new MyLinkedList();

        int remainer = 0;
        while (current1 != null || current2 != null){

            int digit = (current1.value + current2.value) % 10;
            result.addNodeEnd(digit + remainer);
            remainer = 0;
            remainer = (current1.value + current2.value) / 10;

            current1 = current1.next;
            current2 = current2.next;
        }
        System.out.println(result);

        return result;
    }



    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return count;
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
