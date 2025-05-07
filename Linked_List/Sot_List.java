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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        // return naiveApproach(head);

        return optimalApproach(head);
    }

    public ListNode optimalApproach(ListNode head) {
        
        return head;
    }

    // naive approach
    public ListNode naiveApproach(ListNode head) {
        ListNode mover = head;
        ArrayList<Integer> arr = new ArrayList<>();

        while (mover != null) {
            arr.add(mover.val);
            mover = mover.next;
        }

        Collections.sort(arr);
        mover = head;

        for (int i = 0; i < arr.size(); i++) {
            mover.val = arr.get(i);
            mover = mover.next;
        }

        return head;
    }
}