package leetcode_dcc;

import java.util.HashSet;
import java.util.Set;

/*
3719. Longest Balanced Subarray I (Medium)
You are given an integer array nums.

A subarray is called balanced if the number of distinct even numbers in the subarray is equal to the number of distinct odd numbers.

Return the length of the longest balanced subarray.

Input: nums = [2,5,4,3]
Output: 4

Streak->187

* */
public class LongestBalancedSubarray_I {
    public static void main(String[] args) {
        int[] arr = {2,5,4,3};
        System.out.println(longestBalanced(arr));
    }
    public static int longestBalanced(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            Set<Integer> odd = new HashSet<>();
            Set<Integer> even = new HashSet<>();
            for(int j=i;j<nums.length;j++){
                if(nums[j]%2==0)
                    even.add(nums[j]);
                else
                    odd.add(nums[j]);

                if(odd.size()==even.size()){
                    result=Math.max(result,j-i+1);
                }
            }
        }
        return result;
    }
}
