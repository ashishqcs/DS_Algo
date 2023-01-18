package tree;

import model.TreeNode;

import java.util.Stack;

/*
    https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode node1, TreeNode node2){
        if (node1 == null && node2 == null)
            return true;

        if (node1 != null && node2 != null && node1.val == node2.val){
            return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
        }

        return false;
    }

    public boolean isSymmetricIterative(TreeNode root) {
        Stack<TreeNode> stackLeft = new Stack<>();
        Stack<TreeNode> stackRight = new Stack<>();
        stackLeft.push(root);
        stackRight.push(root);

        while (!stackLeft.isEmpty() && !stackRight.isEmpty()) {
            TreeNode leftNode = stackLeft.pop();
            TreeNode rightNode = stackRight.pop();

            if(leftNode == null && rightNode == null) continue;

            if(leftNode == null ^ rightNode == null)
                return false;

            if (leftNode.val != rightNode.val)
                return false;

            stackLeft.push(leftNode.left);
            stackLeft.push(leftNode.right);

            stackRight.push(rightNode.right);
            stackRight.push(rightNode.left);
        }

        return stackLeft.isEmpty() && stackRight.isEmpty();
    }
}
