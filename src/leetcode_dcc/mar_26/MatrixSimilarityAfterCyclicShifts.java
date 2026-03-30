package leetcode_dcc.mar_26;
/*
2946. Matrix Similarity After Cyclic Shifts (Easy)
Companies
Hint
You are given an m x n integer matrix mat and an integer k. The matrix rows are 0-indexed.
The following proccess happens k times:
Even-indexed rows (0, 2, 4, ...) are cyclically shifted to the left.
Odd-indexed rows (1, 3, 5, ...) are cyclically shifted to the right.
Return true if the final modified matrix after k steps is identical to the original matrix, and false otherwise.
Streak->232
* */
public class MatrixSimilarityAfterCyclicShifts {
    public static void main(String[] args) {
        int[][] arr = {{2,2},{2,2}};
        int k=3;
        System.out.println(areSimilar(arr,k));
    }
    public static boolean areSimilar(int[][] mat, int k) {
        for (int[] el : mat) {
            int n = el.length;
            for (int i = 0; i < n; i++) {
                if (el[i] != el[(i + k) % n])
                    return false;
            }
        }
        return true;
    }
}
