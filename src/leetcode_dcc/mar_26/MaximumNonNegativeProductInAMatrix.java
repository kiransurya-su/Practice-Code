package leetcode_dcc.mar_26;
/*
1594. Maximum Non Negative Product in a Matrix (Medium)

You are given a m x n matrix grid. Initially, you are located at the top-left corner (0, 0), and in each step, you can only move right or down in the matrix.
Among all possible paths starting from the top-left corner (0, 0) and ending in the bottom-right corner (m - 1, n - 1), find the path with the maximum non-negative product. The product of a path is the product of all integers in the grid cells visited along the path.
Return the maximum non-negative product modulo 109 + 7. If the maximum product is negative, return -1.
Notice that the modulo is performed after getting the maximum product.

Input: grid = [[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]
Output: -1
Explanation: It is not possible to get non-negative product in the path from (0, 0) to (2, 2), so return -1.

Streak-229
* */
public class MaximumNonNegativeProductInAMatrix {
    public static void main(String[] args) {
        int[][] arr ={{-1,-2,-3},{-2,-3,-3},{-3,-3,-2}};
        System.out.println(maxProductPath(arr));
    }
    public static long picker(int n, int m, long prod, int[][] grid) {
        if (n == 0 && m == 0)
            return prod * grid[0][0];
        if (prod == 0)
            return 0;

        long up = (n != 0) ? picker(n - 1, m, prod * grid[n][m], grid) : Long.MIN_VALUE;
        long left = (m != 0) ? picker(n, m - 1, prod * grid[n][m], grid) : Long.MIN_VALUE;

        return Math.max(up, left);
    }

    public static int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long ans = picker(n - 1, m - 1, 1, grid);
        return ans < 0 ? -1 : (int) (ans % 1000000007);
    }
}
