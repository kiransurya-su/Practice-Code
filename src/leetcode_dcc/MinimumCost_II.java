package leetcode_dcc;
import java.util.*;
/*
3013. Divide an Array Into Subarrays With Minimum Cost II
You are given a 0-indexed array of integers nums of length n, and two positive integers k and dist.
The cost of an array is the value of its first element. For example, the cost of [1,2,3] is 1 while the cost of [3,4,1] is 3.
You need to divide nums into k disjoint contiguous subarrays, such that the difference between the starting index of the second subarray and the starting index of the kth subarray should be less than or equal to dist. In other words, if you divide nums into the subarrays nums[0..(i1 - 1)], nums[i1..(i2 - 1)], ..., nums[ik-1..(n - 1)], then ik-1 - i1 <= dist.
Return the minimum possible sum of the cost of these subarrays.

Streak - > 179
*/
public class MinimumCost_II {
    public static void main(String[] args) {
        int[] nums = {1,3,2,6,4,2};
        int k=3,dist=3;
        System.out.println(minimumCost(nums,k,dist));
    }
    public static long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;

        TreeMap<Integer, Integer> pq = new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer, Integer> tot = new TreeMap<>();

        long sum = 0;
        int size = 0;

        for (int i = 2; i <= 1 + dist; i++) {
            add(tot, nums[i]);
        }


        while (size < k - 2) {
            int val = pollFirst(tot);
            add(pq, val);
            sum += val;
            size++;

        }

        long min = nums[1] + sum;

        for (int i = 2 + dist; i < n; i++) {
            int removeIdx = i - dist;


            if (contains(tot, nums[removeIdx])) {
                remove(tot, nums[removeIdx]);
            } else if (contains(pq, nums[removeIdx])) {
                remove(pq, nums[removeIdx]);
                sum -= nums[removeIdx];
                size--;

            }

            if (!pq.isEmpty() && nums[i] >= pq.firstKey()) {
                add(tot, nums[i]);
            } else {
                add(pq, nums[i]);
                sum += nums[i];

                int val = pollFirst(pq);
                sum -= val;
                add(tot, val);
                size++;
                size--;


            }

            if (size < k - 2) {
                int val = pollFirst(tot);
                add(pq, val);
                sum += val;
                size++;

            }

            min = Math.min(min, nums[i - dist] + sum);
        }

        int j = n - dist;
        while (true) {

            if (contains(tot, nums[j])) {
                remove(tot, nums[j]);
            } else {
                remove(pq, nums[j]);
                sum -= nums[j];
                size--;

            }

            if (size < k - 2) {
                if (tot.isEmpty()) {
                    break;
                }

                int val = pollFirst(tot);
                add(pq, val);
                sum += val;
                size++;

            }

            min = Math.min(min, nums[j] + sum);
            j++;
        }

        return min + nums[0];
    }

    // Utility methods for TreeMap operations
    private static void add(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    private static void remove(TreeMap<Integer, Integer> map, int val) {
        if (map.containsKey(val)) {
            if (map.get(val) == 1) {
                map.remove(val);
            } else {
                map.put(val, map.get(val) - 1);
            }
        }
    }

    private static int pollFirst(TreeMap<Integer, Integer> map) {
        if (map.isEmpty()) return Integer.MAX_VALUE;
        int key = map.firstKey();
        remove(map, key);
        return key;
    }

    private static boolean contains(TreeMap<Integer, Integer> map, int val) {
        return map.containsKey(val);
    }
}