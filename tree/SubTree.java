package tree;

import model.TreeNode;

/*
    https://leetcode.com/problems/subtree-of-another-tree/
 */
public class SubTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return false;

        return isEqual(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isEqual(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;

        if (root1 != null && root2 != null && root1.val == root2.val){

            return  isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right);
        }

        return false;
    }
}
