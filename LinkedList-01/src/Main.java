

public class Main {
    public static void main(String[] args) {

        MyLinkedList list1 = new MyLinkedList();

        list1.addNodeEnd(0);
        list1.addNodeEnd(1);
        list1.addNodeEnd(2);
        list1.addNodeEnd(3);
        list1.addNodeEnd(4);
        list1.addNodeEnd(5);

        MyLinkedList.shiftLinkedList(list1, -2);
        System.out.println(list1);
    }



}
