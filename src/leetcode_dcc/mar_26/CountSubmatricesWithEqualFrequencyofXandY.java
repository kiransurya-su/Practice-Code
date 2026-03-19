package leetcode_dcc.mar_26;
/*
3212. Count Submatrices With Equal Frequency of X and Y (Medium)
Hint
Given a 2D character matrix grid, where grid[i][j] is either 'X', 'Y', or '.', return the number of submatrices that contain:

grid[0][0]
an equal frequency of 'X' and 'Y'.
at least one 'X'.
Example 1:

Input: grid = [["X","Y","."],["Y",".","."]]

Output: 3
* */
public class CountSubmatricesWithEqualFrequencyofXandY {
    public static void main(String[] args) {
        char[][] arr = {{'X','Y','.'},{'Y','.','.'}};
        System.out.println(numberOfSubmatrices(arr));
    }
    public static int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] balance = new int[m][n];
        int[][] xCount = new int[m][n];

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int val = 0;
                if (grid[i][j] == 'X')
                    val = 1;
                else if (grid[i][j] == 'Y')
                    val = -1;

                balance[i][j] = val;
                xCount[i][j] = (grid[i][j] == 'X') ? 1 : 0;

                if (i > 0) {
                    balance[i][j] += balance[i - 1][j];
                    xCount[i][j] += xCount[i - 1][j];
                }
                if (j > 0) {
                    balance[i][j] += balance[i][j - 1];
                    xCount[i][j] += xCount[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    balance[i][j] -= balance[i - 1][j - 1];
                    xCount[i][j] -= xCount[i - 1][j - 1];
                }

                if (balance[i][j] == 0 && xCount[i][j] > 0) {
                    result++;
                }
            }
        }

        return result;
    }
}
