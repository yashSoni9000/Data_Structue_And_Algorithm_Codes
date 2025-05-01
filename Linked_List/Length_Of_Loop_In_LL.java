/*Definition of singly linked list:
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}
 */

 class Solution {
    public int findLengthOfLoop(ListNode head) {
       if (head == null || head.next == null) return 0;
       
       return optimalApproach(head);
   }

   // optimal Approach
   public int optimalApproach(ListNode head) {
       ListNode walker = head, runner = head;
       int loopLength = 0;

       while (runner != null && runner.next != null) {
           walker = walker.next;
           runner = runner.next.next;

           if (walker == runner) {
               loopLength++;
               runner = runner.next;
               break;
           }
       }

       if (runner == null || runner.next == null) return 0;

       while (runner != walker) {
           loopLength++;
           runner = runner.next;
       }

       return loopLength;
   }
}