class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next != null && head.next.next != null) {
            // head -> n1 -> n2 -> 
            // head -> n2 -> n1 ->
            // 最后head指向 n1
            ListNode n1 = head.next;
            ListNode n2 = head.next.next;
            ListNode tmp = n2;
            n1.next = n2.next;
            n2.next = n1;
            head.next = n2;
            
            head = n1;
        }
        return dummy.next;
    }
}