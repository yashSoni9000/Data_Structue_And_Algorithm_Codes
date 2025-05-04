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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;

        ListNode odd = head, even = head.next, oMov = head, eMov = head.next;

        while(eMov != null) {
            oMov.next = oMov.next.next;
            if (oMov.next == null) break;
            oMov = oMov.next;

            eMov.next = eMov.next.next;
            eMov = eMov.next;
        }

        oMov.next = even;

        return odd;
    }
}