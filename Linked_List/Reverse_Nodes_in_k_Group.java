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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head, ahead = head;
        ListNode end = new ListNode();
        end.next = head;
        ListNode prev = end;

        while (ahead != null) {
            for (int i = 0; i < k; i++) {
                if (end.next == null) return head;
                end = end.next;
            }
            start = ahead;
            ahead = end.next;
            end.next = null;
            ListNode temp = reverseLinkedList(start);
            if (start == head) head = temp;
            end = start;
            start = temp;
            end.next = ahead;
            prev.next = start;
            prev = end;
        }

        return head;
    }

    public ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head, ahead;

        while (current != null) {
            ahead = current.next;
            current.next = prev;
            prev = current;
            current = ahead;
        }

        return prev;
    }
}