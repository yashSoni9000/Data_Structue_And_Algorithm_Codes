/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        return naiveApproach(head);
        // return optimalApproach(head);
    }

    // naive approach
    public ListNode naiveApproach(ListNode head) {
        Map<ListNode, Integer> mp = new HashMap<>();
        int length = 1;
        ListNode mover = head;

        while (mover != null) {
            if (mp.containsKey(mover)) return mover;

            mp.put(mover, length++);
            mover = mover.next;
        }

        return null;
    }

    // optimal Approach
    public ListNode optimalApproach(ListNode head) {
        ListNode slow = head, fast = head, ans = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) return null;

        while (ans != slow) {
            slow = slow.next;
            ans = ans.next;
        }

        return slow;
    }
}