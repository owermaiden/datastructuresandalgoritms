public class Main {
    public static void main(String[] args) {
        var node = new Node();
        node.add(8);
        node.add(9);
        node.add(0);
        node.add(2);
        node.add(4);
        node.add(5);
        node.add(7);

        System.out.println(node);
        node.addNodeInOrder(0);
        System.out.println(node);

    }
}
