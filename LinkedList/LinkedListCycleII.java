// 142. Linked List Cycle II
class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode start = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == slow) {
            while(start != fast) {
                start = start.next;
                fast = fast.next;
            }
            return start;
        } else {
            return null;
        }
    }
}