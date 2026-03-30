package leetcode_dcc.mar_26;

import java.util.HashSet;

/*
3548. Equal Sum Grid Partition II (Hard)
You are given an m x n matrix grid of positive integers. Your task is to determine if it is possible to make either one horizontal or one vertical cut on the grid such that:
Each of the two resulting sections formed by the cut is non-empty.
The sum of elements in both sections is equal, or can be made equal by discounting at most one single cell in total (from either section).
If a cell is discounted, the rest of the section must remain connected.
Return true if such a partition exists; otherwise, return false.
Note: A section is connected if every cell in it can be reached from any other cell by moving up, down, left, or right through other cells in the section.
Input: grid = [[1,4],[2,3]]

Output: true
Streak->232
* */
public class EqualSumGridPartition_II {
    public static void main(String[] args) {
        int[][] arr = {{1,4},{2,3}};
        System.out.println(canPartitionGrid(arr));
    }
    public static boolean canPartitionGrid(int[][] grid) {
        long total = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
            }
        }
        for (int k = 0; k < 4; k++) {
            HashSet<Long> exist = new HashSet<>();
            exist.add(0L);
            long sum = 0;
            m = grid.length;
            n = grid[0].length;
            if (m < 2) {
                grid = rotation(grid);
                continue;
            }
            if (n == 1) {
                for (int i = 0; i < m - 1; i++) {
                    sum += grid[i][0];
                    long tag = sum * 2 - total;
                    if (tag == 0 || tag == grid[0][0] || tag == grid[i][0]) {
                        return true;
                    }
                }
                grid = rotation(grid);
                continue;
            }
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n; j++) {
                    exist.add((long) grid[i][j]);
                    sum += grid[i][j];
                }
                long tag = sum * 2 - total;
                if (i == 0) {
                    if (tag == 0 || tag == grid[0][0] || tag == grid[0][n - 1]) {
                        return true;
                    }
                    continue;
                }
                if (exist.contains(tag)) {
                    return true;
                }
            }
            grid = rotation(grid);
        }
        return false;
    }

    public static int[][] rotation(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] tmp = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmp[j][m - 1 - i] = grid[i][j];
            }
        }
        return tmp;
    }
}
