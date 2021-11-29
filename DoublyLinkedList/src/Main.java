public class Main {
    public static void main(String[] args) {
        var doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertNode(10);
        doublyLinkedList.insertNode(20);
        doublyLinkedList.insertNode(30);
        doublyLinkedList.insertNode(40);
        doublyLinkedList.deleteNodeFromEnd();
        System.out.println(doublyLinkedList);
    }
}
