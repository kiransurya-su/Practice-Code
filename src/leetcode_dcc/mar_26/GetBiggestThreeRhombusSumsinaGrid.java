package leetcode_dcc.mar_26;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;
/*
1878. Get Biggest Three Rhombus Sums in a Grid (Medium)

You are given an m x n integer matrix grid

A rhombus sum is the sum of the elements that form the border of a regular rhombus shape in grid.
The rhombus must have the shape of a square rotated 45 degrees with each of the corners centered in a grid cell.
Below is an image of four valid rhombus shapes with the corresponding colored cells that should be included in each rhombus sum:
Note that the rhombus can have an area of 0, which is depicted by the purple rhombus in the bottom right corner.

Return the biggest three distinct rhombus sums in the grid in descending order. If there are less than three distinct values, return all of them.

Streak->222💥
* */
public class GetBiggestThreeRhombusSumsinaGrid {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
        System.out.println(Arrays.toString(getBiggestThree(arr)));
    }
    public static int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        TreeSet<Integer> st = new TreeSet<>(Collections.reverseOrder());
        for(int r=0;r<m;r++)
        {
            for(int c=0;c<n;c++)
            {
                st.add(grid[r][c]);
                int k=1;
                while(true){
                    if(r-k<0 || r+k>=m || c-k<0 || c+k>=n) break;
                    int sum=0;
                    // top->right
                    for(int i=0;i<k;i++)
                    {
                        sum+=grid[r-k+i][c+i];
                    }
                    // right->bottom
                    for(int i=0;i<k;i++)
                    {
                        sum+=grid[r+i][c+k-i];
                    }
                    // bottom->left
                    for(int i=0;i<k;i++)
                    {
                        sum+=grid[r+k-i][c-i];
                    }
                    // left->top
                    for(int i=0;i<k;i++)
                    {
                        sum+=grid[r-i][c-k+i];
                    }
                    st.add(sum);
                    k+=1;
                }
            }
        }
        int size = Math.min(3,st.size());
        int[] res = new int[size];
        int i=0;
        for(int val:st){
            if(i==size) break;
            res[i++]=val;
        }
        return res;
    }
}
