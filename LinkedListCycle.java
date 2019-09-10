/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode copy = head;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = fast.next;
        }
        return true;
    }
}