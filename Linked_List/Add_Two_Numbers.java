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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return ugliestApproach(l1, l2);

        // return optimalApproach(l1, l2);
    }

    public ListNode ugliestApproach(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode mover = dummy;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int currSum = l1.val + l2.val + carry;
            int addCurr = currSum % 10;

            addSumToAns(addCurr, 0, mover);
            mover = mover.next;
            carry = currSum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null && l2 == null) {
            if (carry != 0) addSumToAns(carry, 0, mover);
            mover = mover.next;
            return dummy.next;
        }

        while (l1 != null) {
            int currSum = l1.val + carry;
            addSumToAns(currSum % 10, 0, mover);
            mover = mover.next;
            carry = currSum / 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            int currSum = l2.val + carry;
            addSumToAns(currSum % 10, 0, mover);
            mover = mover.next;
            carry = currSum / 10;
            l2 = l2.next;
        }

        if (carry != 0) addSumToAns(carry, 0, mover);
        mover = mover.next;

        return dummy.next;
    }

    public void addSumToAns(int addCurr, int carry, ListNode mover) {
        ListNode temp = new ListNode(addCurr + carry);
        mover.next = temp;
        // mover = mover.next;
    }

    public int checkCarry(int currSum) {
        // if((currSum % 100) != (currSum % 10)) return currSum / 10;
        return currSum / 10;
    }
}