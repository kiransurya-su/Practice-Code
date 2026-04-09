package leetcode_dcc.apr_26;
/*
3653. XOR After Range Multiplication Queries I (Medium)
You are given an integer array nums of length n and a 2D integer array queries of size q, where queries[i] = [li, ri, ki, vi].
For each query, you must apply the following operations in order:
Set idx = li.
While idx <= ri:
Update: nums[idx] = (nums[idx] * vi) % (109 + 7)
Set idx += ki.
Return the bitwise XOR of all elements in nums after processing all queries.
Streak->244
* */
public class XORAfterRangeMultiplicationQueries_I {
    public static void main(String[] args) {
        int[]  nums = {1, 1, 1};
        int[][] queries = {{0, 2, 1, 4}};
        System.out.println(xorAfterQueries(nums,queries));
    }
    public static int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1_000_000_007;
        int n = nums.length;
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];

            for (int i = l; i <= r; i += k) {
                nums[i] = (int) ((long) nums[i] * v % MOD);
            }
        }
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
}
