class ValidateBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    //采用分治法，时间复杂度 O(n)
    // DFS
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    // node : current TreeNode
    // lower : node should be node.val > lower, lower is the largest val in left part 
    // upper : node should be node.val < upper, upper is the smallest val in right part
    private boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        // so now it goes to the right child, so the lower boundary changes to the current node value: val
        if (!helper(node.right, val, upper)) {
            return false;
        }
        // so now it goes to the left child, so the upper boundary changes to the current node value: val
        if (!helper(node.left, lower, val)) {
            return false;
        }
        return true;
    }

    // using in order traversal
    public boolean isBSTII(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double prev = - Double.MAX_VALUE;
        while (root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= prev) {
                return false;
            }
            prev = root.val;
            root = root.right;
        }
        return true;
    }
}