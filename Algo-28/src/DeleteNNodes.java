public class DeleteNNodes {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode node = arrayToListNode(arr);
        print(node);
        System.out.println();
        print(deleteNAfterMNodes(node,2,3));
    }

    public static ListNode deleteNAfterMNodes(ListNode node, int m, int n) {

        ListNode current = node;

        while (current != null) {

            for (int i = 1; i < m; i++) {
                current = current.next;
            }
            ListNode lastNode = current;
            for (int i = 0; i <= n; i++) {
                current = current.next;
            }
            lastNode.next=current;
        }


        return node;
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.value + ", ");
            node = node.next;
        }
    }

    public static ListNode arrayToListNode(int[] arr) {
        ListNode nodeToAdd = new ListNode(arr[0]);
        ListNode head = nodeToAdd;
        for (int i = 1; i < arr.length; i++) {
            nodeToAdd.next = new ListNode(arr[i]);
            nodeToAdd = nodeToAdd.next;
        }
        return head;
    }
}
