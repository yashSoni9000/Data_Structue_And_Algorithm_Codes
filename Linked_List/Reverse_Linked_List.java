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
        
        // return iterativeApproach(head);

        return recursiveApproach(head, null);
    }

    public ListNode recursiveApproach(ListNode current, ListNode prev) {
        if (current == null) return prev;

        // next = current.next;
        // current.next = prev;
        // prev = current;
        // current = next;
        ListNode next = current.next;
        current.next = prev;

        return recursiveApproach(next, current);
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
}`