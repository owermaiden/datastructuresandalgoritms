

public class Main {
    public static void main(String[] args) {

        MyLinkedList list1 = new MyLinkedList();
        MyLinkedList list2 = new MyLinkedList();


        list1.addNodeEnd(1);
        list1.addNodeEnd(3);
        list1.addNodeEnd(5);

        list2.addNodeEnd(1);
        list2.addNodeEnd(4);
        list2.addNodeEnd(7);


        MyLinkedList.mergeTwoLinkedLİst(list1,list2);
        System.out.println(list1);
        System.out.println(list2);
    }



}
