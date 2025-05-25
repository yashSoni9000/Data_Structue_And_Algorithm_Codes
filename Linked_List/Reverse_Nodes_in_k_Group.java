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
        if (head == null || head.next == null || k <= 1) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode prevGroup = dummy;

        while (head != null) {
            // Check if there are k nodes to reverse
            ListNode kth = getKthNode(head, k);
            if (kth == null) break; // Less than k nodes, no reversal

            ListNode nextGroup = kth.next;
            kth.next = null; // Disconnect the kth node
            ListNode reversedHead = reverseLL(head); // Reverse the group
            prevGroup.next = reversedHead; // Connect previous group to reversed head
            head.next = nextGroup; // Connect end of reversed group to next group
            prevGroup = head; // Update prevGroup to the end of current reversed group
            head = nextGroup; // Move to the next group
        }

        return dummy.next;
    }

    // Helper to get the kth node from current, or null if fewer than k nodes
    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 1) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    // Helper to reverse a linked list
    public ListNode reverseLL(ListNode head) {
        ListNode prev = null, current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}