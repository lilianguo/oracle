/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
class MergeKSortedList {

    // divide and conquer
    // time complexity O(NlogK) where K is the number o linkedlists 
    //                                N is the total number of nodes in two lists
    // space: O(1)
    // step 1: pair up K lists into K/2 lists
    // then to k/4, k/8, down to 1
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }

    private ListNode helper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start)/2;
        ListNode left = helper(lists, start, mid);
        ListNode right = helper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode merged = new ListNode(0);
        ListNode dummy = merged;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = new ListNode(l1.val);
                l1 = l1.next;
                dummy = dummy.next;
            } else {
                dummy.next = new ListNode(l2.val);
                l2 = l2.next;
                dummy = dummy.next;
            }
        }
        if (l1 != null) {
            dummy.next = l1;
        }
        if (l2 != null) {
            dummy.next = l2;
        }
        return merged.next;
    }
}