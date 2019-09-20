class LowestCommonAncestorOfBinaryTree {
    // 236
    // this recursive call return a node if exist
    public TreeNode getAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) {
            return null;
        }
        if (root == node1|| root == node2) {
            return root;
        }
        // when left is not null, it's either node1 or node2
        TreeNode left = getAncestor(root.left, node1, node2);
        // same: when right is not null, it's either node1 or node 2
        TreeNode right = getAncestor(root.right, node1, node2);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
}