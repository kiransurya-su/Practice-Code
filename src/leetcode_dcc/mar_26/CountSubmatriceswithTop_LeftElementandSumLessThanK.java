package leetcode_dcc.mar_26;
/*
3070. Count Submatrices with Top-Left Element and Sum Less Than k (Medium)
You are given a 0-indexed integer matrix grid and an integer k.

Return the number of submatrices that contain the top-left element of the grid, and have a sum less than or equal to k.
Input: grid = [[7,6,3],[6,6,1]], k = 18
Output: 4
Explanation: There are only 4 submatrices, shown in the image above, that contain the top-left element of grid, and have a sum less than or equal to 18.

Streak->224
* */
public class CountSubmatriceswithTop_LeftElementandSumLessThanK {
    public static void main(String[] args) {
        int[][] arr = {{7,6,3},{6,6,1}};
        int k=18;
        System.out.println(countSubmatrices(arr,k));
    }
    public static int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0)
                    grid[i][j] += grid[i - 1][j];
                if (j > 0)
                    grid[i][j] += grid[i][j - 1];
                if (i > 0 && j > 0)
                    grid[i][j] -= grid[i - 1][j - 1];

                if (grid[i][j] <= k)
                    count++;
            }
        }

        return count;
    }
}
