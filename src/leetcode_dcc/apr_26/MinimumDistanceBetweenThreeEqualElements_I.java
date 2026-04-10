package leetcode_dcc.apr_26;
/*
3740. Minimum Distance Between Three Equal Elements I (Easy)
You are given an integer array nums.
A tuple (i, j, k) of 3 distinct indices is good if nums[i] == nums[j] == nums[k].
The distance of a good tuple is abs(i - j) + abs(j - k) + abs(k - i), where abs(x) denotes the absolute value of x.
Return an integer denoting the minimum possible distance of a good tuple. If no good tuples exist, return -1.

Input: nums = [1,2,1,1,3]
Output: 6
Explanation:
The minimum distance is achieved by the good tuple (0, 2, 3).
(0, 2, 3) is a good tuple because nums[0] == nums[2] == nums[3] == 1. Its distance is abs(0 - 2) + abs(2 - 3) + abs(3 - 0) = 2 + 1 + 3 = 6.
Streak->247

* */
import java.util.*;
public class MinimumDistanceBetweenThreeEqualElements_I {
    public static void main(String[] args) {
        int[] arr = {1,2,1,1,3};
        System.out.println(minimumDistance(arr));
    }
    public static int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int min = Integer.MAX_VALUE;
        for (List<Integer> li : mp.values()) {
            if (li.size() >= 3) {
                for (int i = 0; i <= li.size() - 3; i++) {
                    int first = li.get(i);
                    int third = li.get(i + 2);
                    int dist = 2 * (third - first);
                    min = Math.min(min, dist);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
