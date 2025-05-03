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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        // return naiveApproach(head);

        return optimalApproach(head);
    }

    // optimal approach
    public boolean optimalApproach(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }

    // naive approach
    public boolean naiveApproach(ListNode head) {
        Map<ListNode, Integer> mp = new HashMap<>();
        ListNode mover = head;
        int length = 1;

        while (mover != null) {
            if (mp.containsKey(mover)) return true;

            mp.put(mover, length++);
            mover = mover.next;
        }

        return false;
    }
}