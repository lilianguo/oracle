class ConvertSortedListToBinarySearchTree {
    // 109
    // time: O(n)
    public TreeNode sortedListToBST(ListNode head) {
        int[] nums = covertListToArray(head);
        return covertArrayToBST(nums, 0, nums.length - 1);
    }

    private int[] covertListToArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    private TreeNode covertArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        if (start == end) {
            return root;
        }
        root.left = covertArrayToBST(nums, start, mid  -1);
        root.right = covertArrayToBST(nums, mid + 1, end);
        return root;
    }
}