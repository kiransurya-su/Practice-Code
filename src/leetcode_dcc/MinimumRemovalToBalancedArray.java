package leetcode_dcc;

import java.util.Arrays;

/*
3634. Minimum Removals to Balance Array (Medium)
You are given an integer array nums and an integer k.

An array is considered balanced if the value of its maximum element is at most k times the minimum element.

You may remove any number of elements from nums​​​​​​​ without making it empty.

Return the minimum number of elements to remove so that the remaining array is balanced.

Note: An array of size 1 is considered balanced as its maximum and minimum are equal, and the condition always holds true.
Streak->183
* */
public class MinimumRemovalToBalancedArray {
    public static void main(String[] args) {
        int[] nums={2,1,5};
        int k=2;
        System.out.println(minRemoval(nums,k));
    }
    public static int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        int maxLen=0;
        for(int j=0;j<nums.length;j++){
            while((long)nums[j]>(long)nums[i]*k){
                i++;
            }
            maxLen=Math.max(maxLen,j-i+1);
        }
        return nums.length-maxLen;
    }
}
