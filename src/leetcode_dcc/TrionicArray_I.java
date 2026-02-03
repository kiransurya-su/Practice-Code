package leetcode_dcc;
/*
3637. Trionic Array I
You are given an integer array nums of length n.

An array is trionic if there exist indices 0 < p < q < n − 1 such that:

nums[0...p] is strictly increasing,
nums[p...q] is strictly decreasing,
nums[q...n − 1] is strictly increasing.
Return true if nums is trionic, otherwise return false.

Streak->180
 */

public class TrionicArray_I {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,2,6};
        System.out.println(isTrionic(nums));
    }
    public static boolean isTrionic(int[] nums) {
        int n = nums.length;
        if(n<3) return false;
        int i=0;
        while(i+1<n && nums[i]<nums[i+1]){
            i++;
        }
        if(i==0 || i==n-1) return false;
        int mid=i;
        while(i+1<n && nums[i]>nums[i+1]){
            i++;
        }
        if(i==mid || i==n-1) return false;
        while(i+1<n && nums[i]<nums[i+1]){
            i++;
        }
        return i==n-1;
    }
}
