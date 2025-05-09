/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return naiveApproach(headA, headB);
    }
    public ListNode naiveApproach(ListNode headA, ListNode headB) {
        Set<ListNode> st = new HashSet<>();
        ListNode moverA = headA, moverB = headB;

        while (moverA != null && moverB != null) {
            if (st.contains(moverA)) return moverA;
            st.add(moverA);
            if (st.contains(moverB)) return moverB;
            st.add(moverB);

            moverA = moverA.next;
            moverB = moverB.next;
        }

        while (moverA != null) {
            if (st.contains(moverA)) return moverA;
            moverA = moverA.next;
        }

        while (moverB != null) {
            if (st.contains(moverB)) return moverB;
            moverB = moverB.next;
        }

        return null;
    }
}