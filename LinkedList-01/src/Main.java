import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();


        myLinkedList.addNodeEnd(1);
        myLinkedList.addNodeEnd(1);
        myLinkedList.addNodeEnd(2);
        myLinkedList.addNodeEnd(3);
        myLinkedList.addNodeEnd(4);
        myLinkedList.addNodeEnd(4);
        myLinkedList.addNodeEnd(4);
        myLinkedList.addNodeEnd(5);
        myLinkedList.addNodeEnd(6);
        myLinkedList.addNodeEnd(6);

        MyLinkedList.removeDublicates(myLinkedList);
        System.out.println(myLinkedList);


        int y = myLinkedList.findIndexOfNode(20);
        System.out.println(myLinkedList.getMiddleNode());


        System.out.println(y);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.size());
    }


}
