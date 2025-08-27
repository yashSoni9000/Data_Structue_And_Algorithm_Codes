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
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;

        ListNode walker = head, runner = head.next.next;

        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }

        walker.next = walker.next.next;

        return head;
    }
}