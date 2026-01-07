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
    private Node head;
    private Node last;

    public void addNodeEnd(int value){
        Node item = new Node(value);
        if (isEmpty()){
            head = last = item;
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
            head = last = item;
            this.count++;
            return;
        }

        if (head == last){
            item.next = head;
            head = item;
            count++;
            return;
        }

        item.next = head;
        head = item;
        count++;
    }

    public void removeFromEnd(){
        if(isEmpty()) return;

        if (head == last){
            head = last = null;
            count = 0;
            return;
        }
        Node current = head;
        while (current.next != last){
            current = current.next;
        }
        last = current;
        last.next = null;
        count--;
    }


    public void removeFromBegining(){
        if(isEmpty()) return;

        if (head == last){
            head = last = null;
            count = 0;
            return;
        }

        head = head.next;
        count--;
    }

    public void reverseLinkedList(){
        if (isEmpty() || head == last) throw new RuntimeException();

        Node prev = head;
        Node curr = head.next;        //  10   ->    20   ->   30
                                       //   p   <-    c          n
        while(curr != null){           //             p    <-    c         n
            Node nexT = curr.next;     //                        p         c        n
            curr.next = prev;
            prev = curr;
            curr = nexT;
        }

        last = head;
        last.next = null;
        head = prev;

    }

    public int findTheKthNodeFromEnd(int value){
        if(isEmpty()) throw new RuntimeException();

        if(head == last) return 0;

        Node p1 = head;
        Node p2 = head;

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

        if (head == last) {
            nodeList.add(head.value);
            return nodeList;
        }

        Node current = head;
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
            head = last = item;
            this.count++;
            return;
        } else if (value <= head.value){
            insertBegining(value);
        } else {
            Node current = head;
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
        Node current = head;
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

        var current = list.head;
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

    public static MyLinkedList twoNumbersSum(MyLinkedList listX, MyLinkedList listY){
        Node current1 = listX.head;
        Node current2 = listY.head;
        MyLinkedList result = new MyLinkedList();

        int remainer = 0;
        while (current1 != null || current2 != null || remainer != 0){

            int sumX = current1 == null ? 0 : current1.value;        // if number digits ends...then we may assume it zero...
            int sumY = current2 == null ? 0 : current2.value;

            int digit = (sumX + sumY + remainer) % 10;
            result.addNodeEnd(digit );                               // Add to result...
            remainer = (sumX + sumY) / 10;                           // Re-calculate remainer....

            current1 = current1 == null ? current1 : current1.next;   // if we reach and then no need to go further
            current2 = current2 == null ? current2 : current2.next;
        }
        System.out.println(result);
        return result;
    }

    public static MyLinkedList mergeTwoLinkedList(MyLinkedList listX, MyLinkedList listY){
        Node current1 = listX.head;
        Node current2 = listY.head;
        MyLinkedList result = new MyLinkedList();

        while (current1 != null || current2 != null){

            int x = current1 == null ? Integer.MAX_VALUE : current1.value;
            int y = current2 == null ? Integer.MAX_VALUE : current2.value;

            if (x < y){
                result.addNodeEnd(x);
                current1 = current1.next;
                continue;
            } else if (y < x){
                result.addNodeEnd(y);
                current2 = current2.next;
                continue;
            }
            result.addNodeEnd(current1.value);
            result.addNodeEnd(current2.value);
            current1 = current1.next;
            current2 = current2.next;
        }
        System.out.println(result);
        return result;
    }

    public static void shiftLinkedList(MyLinkedList list, int k){
        list.last.next = list.head;
        int times = k > 0 ? list.count - k : k;
        for (int i = 0; i < Math.abs(times); i++){
            list.last = list.last.next;
            list.head = list.head.next;
        }
        list.last.next = null;
    }

    public static boolean isPalindrome(MyLinkedList list){
        if (list.isEmpty())throw new IllegalStateException();
        if (list.head == list.last) return true;
        if(list.head.value != list.last.value) return false;

        Stack<Integer> stack = new Stack<>();
        Node current = list.head;
        int i = 0;
        while (i < list.size() / 2){
            stack.push(current.value);
            current = current.next;
            i++;
        }
        if (list.size() % 2 == 1) current = current.next;
        while (current != null){
            if (stack.pop() != current.value) return false;
            current = current.next;
        }
        return true;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return count;
    }

    @Override
    public String toString() {
        Node current = this.head;
        List<Node> list = new ArrayList<>();
        while (current != null){
            list.add(current);
            current = current.next;
        }
        return list.toString();
    }
}
