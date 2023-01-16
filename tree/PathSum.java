package tree;

import model.TreeNode;

/*
    Problem : https://leetcode.com/problems/path-sum/
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return path(root, 0, targetSum);
    }

    public boolean path(TreeNode root, int sum, int targetSum){
        if(root == null){
            return false;
        }
        int currentSum = sum+root.val;

        if(currentSum == targetSum && root.left == null && root.right == null) return true;

        return path(root.left, currentSum, targetSum) || path(root.right, currentSum, targetSum);
    }
}
