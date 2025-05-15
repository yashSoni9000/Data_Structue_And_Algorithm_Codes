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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode mover = head;
        int length = 1;
        while (mover.next != null) {
            mover = mover.next;
            length++;
        }
        k = k % length;

        ListNode end = mover;
        end.next = head;
        int value = mover.val;
        ListNode ahead = mover.next;

        while(k != 0) {
            for (int i = 0; i < length; i++) {
                ahead = mover.next;
                int temp = ahead.val;
                ahead.val = value;
                value = temp;
                mover = mover.next;
            }
            value = mover.val;
            k--;
        }
        end.next = null;

        return head;
    }
}