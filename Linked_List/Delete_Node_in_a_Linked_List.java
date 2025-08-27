package Linked_List;
class Solution {
    public void deleteNode(ListNode node) {
        // naiveApproach(node);

        optimalApproach(node);
    }

    public void optimalApproach(ListNode node) {
        node.val = node.next.val;

        node.next = node.next.next;
    }

    public void naiveApproach(ListNode node) {
        ListNode mover = node;
        ListNode nextData = node.next;

        while (nextData.next != null) {
            mover.val = nextData.val;
            mover = nextData;
            nextData = nextData.next;
        }
        mover.val = nextData.val;
        mover.next = null;
    }
}