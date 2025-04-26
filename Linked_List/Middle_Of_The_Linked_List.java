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
    public ListNode middleNode(ListNode head) {
        // return naiveSolution(head);

        return optimalSolution(head);
    }

    public ListNode optimalSolution(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode naiveSolution(ListNode head) {
        ListNode mover = head;
        ListNode ans = head;
        int length = 0;

        while (mover.next != null) {
            mover = mover.next;
            length++;
        }
        
        if (length % 2 == 0) length = (length / 2);
        else length = (length / 2) + 1;

        while (length != 0) {
            ans = ans.next;
            length--;
        }

        return ans;
    }
}