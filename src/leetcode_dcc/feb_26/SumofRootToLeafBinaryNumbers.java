package leetcode_dcc.feb_26;

/*
1022. Sum of Root To Leaf Binary Numbers (Easy)
You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents a binary number starting with the most significant bit.

For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers.

The test cases are generated so that the answer fits in a 32-bits integer.
Input: root = [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
Streak->201
* */

import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {

    public int sumRootToLeaf(TreeNode root) {
        return dfs(0, root);
    }

    private int dfs(int sum, TreeNode node) {
        if (node == null) return 0;

        // Shift left (binary) and add current value
        sum = (sum << 1) + node.val;

        // Leaf node
        if (node.left == null && node.right == null)
            return sum;

        return dfs(sum, node.left) + dfs(sum, node.right);
    }
}

public class SumofRootToLeafBinaryNumbers {
    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null)
            return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }
    public static void main(String[] args) {
        // Input: root = [1,0,1,0,1,0,1]
        Integer[] input = {1,0,1,0,1,0,1};

        TreeNode root = buildTree(input);

        Solution sol = new Solution();
        int result = sol.sumRootToLeaf(root);

        System.out.println("Sum of Root to Leaf Binary Numbers: " + result);
    }

}
