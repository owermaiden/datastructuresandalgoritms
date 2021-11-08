public class Main {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.addNodeEnd(05);
        linkedList.insertBegining(10);
        linkedList.addNodeEnd(20);
        linkedList.addNodeEnd(30);
        linkedList.addNodeEnd(40);
        linkedList.addNodeEnd(50);

        int x = linkedList.findTheKthNodeFromEnd(30);
        int y = linkedList.findIndexOfNode(20);
        System.out.println(linkedList.getMiddleNode());

        System.out.println(linkedList.size());
        System.out.println(x);
        System.out.println(y);


    }
}
