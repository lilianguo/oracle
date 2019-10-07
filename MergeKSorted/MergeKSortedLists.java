
/*
23. Merge k Sorted Lists
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeHelper(lists, 0, lists.length - 1);
    }

    private ListNode mergeHelper(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left)/2;
        ListNode l = mergeHelper(lists, left, mid);
        ListNode r = mergeHelper(lists, mid + 1, right);
        return mergeTwoList(l, r);
    }

    private ListNode mergeTwoList(ListNode n1 , ListNode n2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                tail.next = new ListNode(n1.val);
                tail = tail.next;
                n1 = n1.next;
            } else {
                tail.next = new ListNode(n2.val);
                tail = tail.next;
                n2 = n2.next;
            }
        }
        if (n1 != null) {
            tail.next = n1;
        } else {
            tail.next = n2;
        }

        return dummy.next;
    }
}