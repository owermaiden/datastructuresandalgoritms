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

        doublyLinkedList.removeNodeFromTail();
        doublyLinkedList.removeNodeFromTail();
        doublyLinkedList.removeNodesWithValue(30);
        doublyLinkedList.removeNodesWithValue(1);
        doublyLinkedList.removeNodesWithValue(10);
        System.out.println(doublyLinkedList.getSize());
        System.out.println(doublyLinkedList.indexOf(35));
        System.out.println(doublyLinkedList.containsNodeWithValue(35));
        System.out.println(doublyLinkedList.containsNodeWithValue(9));



        System.out.println(doublyLinkedList);
    }
}
