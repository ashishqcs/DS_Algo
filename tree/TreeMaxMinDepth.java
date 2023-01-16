package tree;

import model.TreeNode;
import util.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeMaxMinDepth {

    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /*
        Less efficient using DFS.
     */
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;

        if(root.left == null || root.right == null)
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    /*
        More efficient using BFS.
     */
    public int minDepthUsingBFS(TreeNode root) {
        if(root == null)
            return 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int height = 0;

        while(!queue.isEmpty()){
            height++;
            int k = queue.size();
            for (int i=0; i< k; i++){
                TreeNode node = queue.poll();

                if (node.left == null && node.right == null)
                    return height;

                if(node.left != null)
                    queue.add(node.left);

                if(node.right != null)
                    queue.add(node.right);

            }
        }

        return 0;
    }

    public static void main(String[] args) {

        TreeNode root = Tree.binaryTree(1, 2, 3, 4, 5, 6, 7, 8);

        TreeMaxMinDepth treeMaxDepth = new TreeMaxMinDepth();
        System.out.println(treeMaxDepth.maxDepth(root));
    }
}
