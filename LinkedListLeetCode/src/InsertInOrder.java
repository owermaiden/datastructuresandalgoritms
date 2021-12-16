public class InsertInOrder {


    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    class Solution {
        public Node insert(Node head, int insertVal) {
            if (head == null) {
                Node node = new Node(insertVal, null);
                node.next = node;
                return node;
            }

            Node prev = head;
            Node curr = head.next;
            boolean insertPlaceFound = false;

            do {
                if (prev.val <= insertVal && insertVal <= curr.val) {
                    insertPlaceFound= true;
                } else if (prev.val > curr.val) {

                    if (insertVal >= prev.val || insertVal <= curr.val)
                        insertPlaceFound = true;
                }//elseif

                if (insertPlaceFound) {
                    prev.next = new Node(insertVal, curr);
                    return head;
                } //endif

                prev = curr;
                curr = curr.next;

            }  while(prev!=head) ;

            prev.next = new Node(insertVal, curr);
            return head;
        }
    }
}
