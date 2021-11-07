public class Main {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.addNodeEnd(10);
        linkedList.addNodeEnd(20);
        linkedList.addNodeEnd(30);
        linkedList.removeFromEnd();
        linkedList.removeFromEnd();

        System.out.println(linkedList);


    }
}
