package DSA.binarysearch;

public class SplitArray {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int k=2;
        System.out.println(splitArray(nums,k));
    }
    public static int splitArray(int[] nums, int k) {
        int st=0;
        int end=0;
        for (int i = 0; i < nums.length; i++) {
            st=Math.max(st,nums[i]); // in the end of the loop this will contain the max item from the array
            end+=nums[i];
        }
        // binary search
        while(st<end){
            // try for the middle for potential answer
            int mid = st+(end-st)/2;
            // calculate how many pieces you can divide this in with this max sum
            int sum=0;
            int pieces=1;
            for(int num:nums){
                if(sum+num>mid) {
                    // you can't add this in this subarray, make new one
                    // say you add this num in new subarray, then sum=num
                    sum=num;
                    pieces++;
                }else{
                    sum+=num;
                }
            }
            if(pieces>k){
                st=mid+1;
            }else{
                end=mid;
            }
        }
        return end;
    }
}

