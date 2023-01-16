package model;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(TreeNode left, TreeNode right, int numData) {
        this.left = left;
        this.right = right;
        this.val = numData;
    }
}
