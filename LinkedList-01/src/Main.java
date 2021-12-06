

public class Main {
    public static void main(String[] args) {

        MyLinkedList list1 = new MyLinkedList();
        MyLinkedList list2 = new MyLinkedList();


        list1.addNodeEnd(9);
        list1.addNodeEnd(9);
        list1.addNodeEnd(9);
        list1.addNodeEnd(9);
        list1.addNodeEnd(9);
        list1.addNodeEnd(1);

        list2.addNodeEnd(9);
        list2.addNodeEnd(9);
        list2.addNodeEnd(9);


        MyLinkedList.twoNumbersSum(list1,list2);
        System.out.println(list1);
        System.out.println(list2);
    }



}
