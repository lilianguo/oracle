class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while(head != null) {
            ListNode node = dummy;
            while(node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            ListNode tmp = head.next;
            head.next = node.next;
            node.next = head;
            head = tmp;
        }
        return dummy.next;
    }
}