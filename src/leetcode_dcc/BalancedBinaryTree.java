package leetcode_dcc;
/*
*
* 110. Balanced Binary Tree (Easy)
    Given a binary tree, determine if it is height-balanced.
    Input: root = [3,9,20,null,null,15,7]
    Output: true
    Streak->185
* * */
import java.util.*;

public class BalancedBinaryTree {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Solution {

        public boolean isBalanced(TreeNode root) {
            return dfs(root) != -1;
        }

        private int dfs(TreeNode node) {
            if (node == null) return 0;

            int left = dfs(node.left);
            if (left == -1) return -1;

            int right = dfs(node.right);
            if (right == -1) return -1;

            if (Math.abs(left - right) > 1) return -1;

            return 1 + Math.max(left, right);
        }
    }

    // Build tree from level-order array like [3,9,20,null,null,15,7]
    private static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < arr.length) {
            TreeNode current = queue.poll();

            if (arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {

        // Input: root = [3,9,20,null,null,15,7]
        Integer[] rootArray = {3, 9, 20, null, null, 15, 7};

        TreeNode root = buildTree(rootArray);

        Solution solution = new Solution();
        System.out.println("Is the tree balanced? " + solution.isBalanced(root));
    }
}
