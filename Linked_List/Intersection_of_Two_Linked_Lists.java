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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // return naiveApproach(headA, headB);

        return optimalApproach(headA, headB);
    }

    public ListNode optimalApproach(ListNode headA, ListNode headB) {
        ListNode moverA = headA, moverB = headB, ans;
        int countA = 1, countB = 1;

        while (moverA.next != null) {
            moverA = moverA.next;
            countA++;
        }
        while (moverB.next != null) {
            moverB = moverB.next;
            countB++;
        }

        if (moverA != moverB) return null;

        if (countA > countB) ans = getCommonNode(countA - countB, headA, headB);
        else ans = getCommonNode(countB - countA, headB, headA);

        return ans;
    }

    public ListNode getCommonNode(int diff, ListNode headA, ListNode headB) {
        for (int i = 0; i < diff; i++) headA = headA.next;
        // System.out.println(headA.val);

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
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