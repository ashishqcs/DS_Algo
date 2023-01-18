package tree;

import model.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/*
    https://leetcode.com/problems/sum-of-left-leaves/
 */
public class SumLeftLeaf {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int sum = 0;

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if (node.left != null){
                queue.add(node.left);

                if(hasLeftLeaf(node.left))
                    sum+=node.left.val;
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }

        return sum;
    }

    private boolean hasLeftLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
