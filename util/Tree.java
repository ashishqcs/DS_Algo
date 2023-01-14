package util;

import model.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Tree {

    public static TreeNode binaryTree(int... values){
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = null;

        for (int value : values) {
            TreeNode node = new TreeNode(null, null, value);
            if (root == null) root = node;

            if(queue.isEmpty()) {
                queue.add(root);
            }
            else {
                queue.add(node);
                TreeNode parentNode = queue.peek();
                if (parentNode.left == null)
                    parentNode.left = node;
                else {
                    parentNode.right = node;
                    queue.poll();
                }
            }
        }

        return root;
    }
}
