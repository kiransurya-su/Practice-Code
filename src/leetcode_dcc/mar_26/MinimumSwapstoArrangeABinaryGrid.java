package leetcode_dcc.mar_26;

import java.util.ArrayList;
import java.util.List;

/*
1536. Minimum Swaps to Arrange a Binary Grid (Medium)
Given an n x n binary grid, in one step you can choose two adjacent rows of the grid and swap them.
A grid is said to be valid if all the cells above the main diagonal are zeros.
Return the minimum number of steps needed to make the grid valid, or -1 if the grid cannot be valid.
The main diagonal of a grid is the diagonal that starts at cell (1, 1) and ends at cell (n, n).

Example 1:
Input: grid = [[0,0,1],[1,1,0],[1,0,0]]
Output: 3

Example 2:
Input: grid = [[1,0,0],[1,1,0],[1,1,1]]
Output: 0


Constraints:
n == grid.length == grid[i].length
1 <= n <= 200
grid[i][j] is either 0 or 1

Streak->207
* */
public class MinimumSwapstoArrangeABinaryGrid {
    public static void main(String[] args) {
        int[][] arr = {{0, 0, 1},{1, 1, 0},{1, 0, 0}};
        System.out.println(minSwaps(arr));
    }
    public static int minSwaps(int[][] grid) {
        int n = grid.length;
        List<Integer> rows = new ArrayList<>();
        for(int i=0;i<n;i++){
            int farthest=-1;
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    farthest=j;
                }
            }
            rows.add(farthest);
        }
        int count=0;
        for(int i=0;i<n;i++){
            boolean check=false;
            for(int j=0;j<rows.size();j++){
                if(rows.get(j)<=i){
                    count+=j;
                    rows.remove(j);
                    check=true;
                    break;
                }
            }
            if(!check) return -1;
        }
        return count;
    }
}
