/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode copy = head;
        ListNode prev = null;
        while(copy != null) {
            if (copy.val != val) {
                prev = copy;
                System.out.println(prev.val);
                copy = copy.next;
                continue;
            }
            if (copy.val == val) {
                if (prev == null) {
                    head = head.next;
                    copy = copy.next;
                    continue;
                }
                if (prev != null && copy.next != null) {
                    copy.val = copy.next.val;
                    prev.next = copy.next;
                    copy = copy.next;
                    continue;
                }
                if (copy.next == null) {
                    prev.next = null;
                    copy = copy.next;
                }
            }
        }
        return head;
    }
}