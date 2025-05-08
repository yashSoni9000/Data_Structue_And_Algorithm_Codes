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
        // Base case: if list is empty or has one node, return as is
        if (head == null || head.next == null) {
            return head;
        }
        
        // Find the middle of the list using slow and fast pointers
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Split the list into two halves
        prev.next = null; // Disconnect the first half from the second half
        
        // Recursively sort the two halves
        ListNode left = optimalApproach(head);
        ListNode right = optimalApproach(slow);
        
        // Merge the sorted halves
        return merge(left, right);
    }

    // merger sort function
    private ListNode merge(ListNode l1, ListNode l2) {
        // Create a dummy node to simplify merging
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Merge the two lists by comparing node values
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        // Attach remaining nodes, if any
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
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