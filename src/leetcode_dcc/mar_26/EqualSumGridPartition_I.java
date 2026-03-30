package leetcode_dcc.mar_26;
/*
3546.Equal Sum Grid Partition I
You are given an m x n matrix grid of positive integers. Your task is to determine if it is possible to make either one horizontal or one vertical cut on the grid such that:
Each of the two resulting sections formed by the cut is non-empty.
The sum of the elements in both sections is equal.
Return true if such a partition exists; otherwise return false.

Input: grid = [[1,4],[2,3]]
Output: true

Streak->231
* */
public class EqualSumGridPartition_I {
    public static void main(String[] args) {
        int[][] arr = {{1,4},{2,3}};
        System.out.println(canPartitionGrid(arr));
    }
    public static boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long totalSum = 0;
        // Step 1: total sum
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                totalSum += grid[i][j];
            }
        }
        // If odd → impossible
        if (totalSum % 2 != 0)
            return false;
        // Step 2: Horizontal cut
        long prefix = 0;
        for (int i = 0; i < m - 1; i++) {
            long rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += grid[i][j];
            }
            prefix += rowSum;
            if (prefix == totalSum - prefix) {
                return true;
            }
        }
        // Step 3: Vertical cut
        prefix = 0;
        for (int j = 0; j < n - 1; j++) {
            long colSum = 0;
            for (int i = 0; i < m; i++) {
                colSum += grid[i][j];
            }
            prefix += colSum;
            if (prefix == totalSum - prefix) {
                return true;
            }
        }
        return false;
    }
}
