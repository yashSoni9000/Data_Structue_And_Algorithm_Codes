/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node dummy = new Node(0);
        Node mover = dummy;
        Node movHead = head;

        Map<Node, Integer> ogMap = new HashMap<>();
        Map<Integer, Node> newMap = new HashMap<>();

        int count = 0;

        while(movHead != null) {
            Node temp = new Node(movHead.val);
            mover.next = temp;
            mover = mover.next;
            ogMap.put(movHead, count);
            newMap.put(count, temp);
            movHead = movHead.next;

            count++;
        }

        movHead = head;
        mover = dummy.next;

        while (movHead != null) {
            mover.random = newMap.get(ogMap.get(movHead.random));
            movHead = movHead.next;
            mover = mover.next;
        }

        return dummy.next;
    }
}