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
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;

        return naiveApproach(head);
    }

    // naive approach
    public boolean naiveApproach(ListNode head) {
        boolean skip = false;
        ListNode mover = head;
        int length = 0, half;

        while (mover != null) {
            length++;
            mover = mover.next;
        }

        Stack<Integer> st = new Stack<>();
        mover = head;
        half = length / 2;

        if (length % 2 == 1) skip = true;

        for (int i = 0; i < half; i++) {
            st.push(mover.val);
            mover = mover.next;
        }

        if (skip) mover = mover.next;

        for (int i = 0; i < half; i++) {
            if (st.peek() != mover.val) return false;
            st.pop();
            mover = mover.next;
        }

        return true;
    }
}