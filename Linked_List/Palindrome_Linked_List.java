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
        ListNode mover = head;
        int length = 0;

        while (mover != null) {
            length++;
            mover = mover.next;
        }

        // return naiveApproach(head, length);

        return optimalApproach(head, length);
    }

    // optimal approach
    public boolean optimalApproach(ListNode head, int length) {
        int half = length / 2;
        boolean skip = false;

        if (length % 2 == 1) skip = true;

        ListNode[] reversedHead = reverseFirstHalf(head, half);

        ListNode first = reversedHead[0];
        ListNode second = reversedHead[1];

        if (skip) second = second.next;

        for (int i = 0; i < half; i++) {
            if (first.val != second.val) return false;

            first = first.next;
            second = second.next;
        }
        return true;
    }

    // helper function for reversing first half of linked list
    public ListNode[] reverseFirstHalf(ListNode head, int half) {
        ListNode prev = null, current = head, next;
        ListNode[] nodes = new ListNode[2];

        for (int i = 0; i < half; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        nodes[0] = prev;
        nodes[1] = current;

        return nodes;
    }


    // naive approach
    public boolean naiveApproach(ListNode head, int length) {
        boolean skip = false;
        int half;

        Stack<Integer> st = new Stack<>();
        ListNode mover = head;
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