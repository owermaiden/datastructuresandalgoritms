public class Main {
    public static void main(String[] args) {
        var doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.setTail(10);
        doublyLinkedList.setTail(20);
        doublyLinkedList.setTail(30);
        doublyLinkedList.setTail(40);
        doublyLinkedList.setHead(1);

        doublyLinkedList.insertBefore(40, 5);
        doublyLinkedList.insertBefore(30, 35);
        doublyLinkedList.insertAfter(20,25);
        doublyLinkedList.insertAfter(10,15);


        doublyLinkedList.insertAtPosition(3,99);



        System.out.println(doublyLinkedList);
    }
}
