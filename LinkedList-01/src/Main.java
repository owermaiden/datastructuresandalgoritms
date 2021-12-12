

public class Main {
    public static void main(String[] args) {

        MyLinkedList list1 = new MyLinkedList();

        list1.addNodeEnd(0);
        list1.addNodeEnd(1);
        list1.addNodeEnd(2);
        list1.addNodeEnd(2);
        list1.addNodeEnd(2);
        list1.addNodeEnd(0);


        System.out.println(MyLinkedList.isPalindrome(list1));
    }



}
