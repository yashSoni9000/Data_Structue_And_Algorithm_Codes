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

        Map<Node, Integer> originalMap = new HashMap<>();
        Map<Integer, Node> copyMap = new HashMap<>();   

        int count = 0;

        while (movHead != null) {
            Node temp = new Node(movHead.val);
            mover.next = temp;
            mover = mover.next;
            originalMap.put(movHead, count);
            copyMap.put(count, temp);
            movHead = movHead.next;
            count++;
        }

        movHead = head;
        mover = dummy.next;
        count = 0;
        while (movHead != null) {
            if (movHead.random != null) {
                mover.random = copyMap.get(originalMap.get(movHead.random));
            }
            movHead = movHead.next;
            mover = mover.next;
            count++;
        }

        return dummy.next;
    }
}