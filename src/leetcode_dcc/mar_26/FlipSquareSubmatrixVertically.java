package leetcode_dcc.mar_26;

import java.util.Arrays;

/*
3643. Flip Square Submatrix Vertically (Easy)
You are given an m x n integer matrix grid, and three integers x, y, and k.
The integers x and y represent the row and column indices of the top-left corner of a square submatrix and the integer k represents the size (side length) of the square submatrix.
Your task is to flip the submatrix by reversing the order of its rows vertically.
Return the updated matrix.

Ex1:
Input: grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], x = 1, y = 0, k = 3
Output: [[1,2,3,4],[13,14,15,8],[9,10,11,12],[5,6,7,16]]

Ex2:
Input: grid = [[3,4,2,3],[2,3,4,2]], x = 0, y = 2, k = 2

Output: [[3,4,4,2],[2,3,2,3]]

Streak->228
* */
public class FlipSquareSubmatrixVertically {
    public static void main(String[] args) {
        int[][] arr = {{3,4,2,3},{2,3,4,2}};
        int x=0,y=2,k=2;
        System.out.println(Arrays.deepToString(reverseSubmatrix(arr,x,y,k)));
    }
    public static int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for(int i=0;i<k/2;i++){
            for(int j=0;j<k;j++){
                int temp = grid[x+i][y+j];
                grid[x+i][y+j]=grid[x+k-1-i][y+j];
                grid[x+k-1-i][y+j]=temp;
            }
        }
        return grid;
    }
}
