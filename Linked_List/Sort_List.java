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
        if (head.next == null) return head;

        ListNode walker = head, runner = head, ahead = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }

        ahead = walker;
        walker = walker.next;
        ahead.next = null;

        ListNode left = optimalApproach(head);
        ListNode right = optimalApproach(walker);

        return merge(left, right);
    }

    // merger sort function
    private ListNode merge(ListNode l1, ListNode l2) {
       ListNode dummy = new ListNode();
       ListNode current = dummy;

       while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) {
            current.next = l1;
            l1 = l1.next;
        }
        else {
            current.next = l2;
            l2 = l2.next;
        }
        current = current.next;
       }

       if (l1 != null) current.next = l1;
       if (l2 != null) current.next = l2;

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