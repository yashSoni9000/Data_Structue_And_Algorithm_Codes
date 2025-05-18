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
        if (head == null || head.next == null)
            return head;

        // return naiveApproach(head);

        return optimalApproach(head);
    }

    public ListNode optimalApproach(ListNode head) {
        if (head.next == null)
            return head;

        ListNode walker = head, runner = head;

        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode body = walker.next;
        walker.next = null;

        ListNode first = optimalApproach(head);
        ListNode last = optimalApproach(body);

        return merge(first, last);
    }

    // merger sort function
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode mover = dummy;

        while (l1 != null || l2 != null) {
            int first = (l1 != null) ? l1.val : Integer.MAX_VALUE;
            int second = (l2 != null) ? l2.val : Integer.MAX_VALUE;
            if (first <= second) {
                mover.next = l1;
                l1 = l1.next;
                mover = mover.next;
            } else {
                mover.next = l2;
                l2 = l2.next;
                mover = mover.next;
            }

        }
        return dummy.next;
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