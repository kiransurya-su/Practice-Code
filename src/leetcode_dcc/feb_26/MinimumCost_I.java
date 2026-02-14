package leetcode_dcc.feb_26;
/*
Problem Number - 3010 || Divide an Array Into Subarrays With Minimum Cost I
You are given an array of integers nums of length n.
The cost of an array is the value of its first element. For example, the cost of [1,2,3] is 1 while the cost of [3,4,1] is 3.
You need to divide nums into 3 disjoint contiguous subarrays.
Return the minimum possible sum of the cost of these subarrays.
*/
// Streak ->178
public class MinimumCost_I {
    public static void main(String[] args) {
        int[] arr = {1,2,3,12};
        System.out.println(minimumCost(arr));
    }
    public static int minimumCost(int[] nums) {
        int maxup=51;
        int sum=nums[0];
        int fMin=maxup;
        int sMin=maxup;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<fMin){
                sMin=fMin;
                fMin=nums[i];
            }else if(nums[i]<sMin){
                sMin=nums[i];
            }
        }
        return sum+fMin+sMin;
    }
}
