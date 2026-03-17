package leetcode_dcc.mar_26;

import java.util.Arrays;
/*
1727. Largest Submatrix With Rearrangements (Medium)
You are given a binary matrix matrix of size m x n, and you are allowed to rearrange the columns of the matrix in any order.

Return the area of the largest submatrix within matrix where every element of the submatrix is 1 after reordering the columns optimally.
Example 1:
Input: matrix = [[0,0,1],[1,1,1],[1,0,1]]
Output: 4
Explanation: You can rearrange the columns as shown above.
The largest submatrix of 1s, in bold, has an area of 4.
Example 2:
Input: matrix = [[1,0,1,0,1]]
Output: 3
Explanation: You can rearrange the columns as shown above.
The largest submatrix of 1s, in bold, has an area of 3.
Example 3:
Input: matrix = [[1,1,0],[1,0,1]]
Output: 2
Explanation: Notice that you must rearrange entire columns, and there is no way to make a submatrix of 1s larger than an area of 2.

Streak>223

* */
public class LargestSubmatrixWithRearrangements {
    public static void main(String[] args) {
        int[][] arr = {{1,0,1,0,1}};
        System.out.println(largestSubmatrix(arr));
    }
    public static int largestSubmatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[] height=new int[n];
        int maxArea=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0) height[j]=0;
                else height[j]+=1;
            }
            int[] sorted=height.clone();
            Arrays.sort(sorted);
            for(int k=n-1;k>=0;k--){
                int h=sorted[k];
                int width=n-k;
                maxArea=Math.max(maxArea,h*width);
            }
        }
        return maxArea;
    }
}
