public class Main {
    public static void main(String[] args) {
        var doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.insertNodeToEnd(10);
        doublyLinkedList.insertNodeToEnd(20);
        doublyLinkedList.insertNodeToEnd(30);
        doublyLinkedList.insertNodeToEnd(40);

        doublyLinkedList.insertBefore(40, 05);
        doublyLinkedList.insertBefore(30, 35);
        doublyLinkedList.insertAfter(20,25);
        doublyLinkedList.insertAfter(10,15);

        doublyLinkedList.insertAtPosition(3,99);



        System.out.println(doublyLinkedList);
    }
}
