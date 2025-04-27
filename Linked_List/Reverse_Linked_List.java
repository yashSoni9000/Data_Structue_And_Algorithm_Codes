/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        return iterativeApproach(head);
    }

    public ListNode iterativeApproach(ListNode head) {
        ListNode curr1 = null, curr2 = null, mover = head;

        while (mover != null) {
            curr2 = mover.next;
            mover.next = curr1;
            curr1 = mover;
            mover = curr2;
        }

        return curr1;
    }
}