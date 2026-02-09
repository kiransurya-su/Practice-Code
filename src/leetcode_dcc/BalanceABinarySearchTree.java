package leetcode_dcc;

import java.util.*;
/*
* 1382. Balance a Binary Search Tree (Medium)
Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.
A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.

Streak->186
*
* */
public class BalanceABinarySearchTree {

    // Definition for a binary tree node.
    static class TreeNode {
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

    static class Solution {

        public TreeNode balanceBST(TreeNode root) {
            List<Integer> li = new ArrayList<>();
            inorder(root, li);
            return searchBuild(li, 0, li.size() - 1);
        }

        public void inorder(TreeNode root, List<Integer> li) {
            if (root == null) return;
            inorder(root.left, li);
            li.add(root.val);
            inorder(root.right, li);
        }

        public TreeNode searchBuild(List<Integer> li, int left, int right) {
            if (left > right) return null;
            int mid = (left + right) / 2;
            return new TreeNode(
                    li.get(mid),
                    searchBuild(li, left, mid - 1),
                    searchBuild(li, mid + 1, right)
            );
        }
    }

    // Build tree from level-order input
    private static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < arr.length) {
            TreeNode curr = queue.poll();

            if (arr[i] != null) {
                curr.left = new TreeNode(arr[i]);
                queue.offer(curr.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                curr.right = new TreeNode(arr[i]);
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    // Convert tree to level-order output
    private static List<Integer> levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                result.add(null);
            } else {
                result.add(curr.val);
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }

        // remove trailing nulls
        int i = result.size() - 1;
        while (i >= 0 && result.get(i) == null) {
            result.remove(i);
            i--;
        }

        return result;
    }

    public static void main(String[] args) {

        // Input: root = [1,null,2,null,3,null,4,null,null]
        Integer[] input = {1, null, 2, null, 3, null, 4, null, null};

        TreeNode root = buildTree(input);

        Solution sol = new Solution();
        TreeNode balancedRoot = sol.balanceBST(root);

        List<Integer> output = levelOrder(balancedRoot);
        System.out.println(output);
    }
}
