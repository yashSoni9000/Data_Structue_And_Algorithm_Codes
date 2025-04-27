class Solution {
    public DLLNode reverseDLL(DLLNode head) {
        // Your code here
        
        if (head == null || head.next == null) return head;
        DLLNode mover = head, temp = null;
        
        while (mover != null) {
            temp = mover.prev;
            mover.prev = mover.next;
            mover.next = temp;
            
            mover = mover.prev;
        }
        
        return temp.prev;
    }
}
