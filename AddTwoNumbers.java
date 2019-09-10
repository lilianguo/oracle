class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode sum = res;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int tmpSum = carry 
                        + (l1 == null ? 0 : l1.val)
                        + (l2 == null ? 0 : l2.val);
            sum.next = new ListNode(tmpSum % 10);
            carry = tmpSum / 10;
            sum = sum.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry == 0) {
            return res.next;
        } else {
            sum.next = new ListNode(carry);
            return res.next;
        }
    }
}