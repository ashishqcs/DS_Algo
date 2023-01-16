package tree;

import model.TreeNode;

/*
    Problem: https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        swap(root, left, right);

        return root;
    }

    private void swap(TreeNode root, TreeNode left, TreeNode right) {
        root.left = right;
        root.right = left;
    }

}
