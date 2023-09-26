public class binary_tree_path {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public java.util.List<String> binaryTreePaths(TreeNode root) {
        java.util.LinkedList<String> paths = new java.util.LinkedList<>();
        if (root == null) return paths;
        java.util.LinkedList<TreeNode> node_stack = new java.util.LinkedList<>();
        java.util.LinkedList<String> path_stack = new java.util.LinkedList<>();
        node_stack.add(root);
        path_stack.add(Integer.toString(root.val));
        TreeNode node;
        String path;
        while (!node_stack.isEmpty()) {
            node = node_stack.pollLast();
            path = path_stack.pollLast();
            if ((node.left == null) && (node.right == null)) paths.add(path);
            if (node.left != null) {
                node_stack.add(node.left);
                path_stack.add(path + "->" + node.left.val);
            }
            if (node.right != null) {
                node_stack.add(node.right);
                path_stack.add(path + "->" + node.right.val);
            }
        }
        return paths;
    }
}
