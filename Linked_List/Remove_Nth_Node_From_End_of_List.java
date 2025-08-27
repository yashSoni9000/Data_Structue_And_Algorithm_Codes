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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;

        ListNode mover = head, remover = head;
        for (int i = 0; i < n; i++) mover = mover.next;

        if (mover == null) return head.next;

        while (mover.next != null) {
            mover = mover.next;
            remover = remover.next;
        }

        remover.next = remover.next.next;

        return head;
        
    }
}