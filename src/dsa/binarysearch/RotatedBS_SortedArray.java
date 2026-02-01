package dsa.binarysearch;

public class RotatedBS_SortedArray {
    public static void main(String[] args) {
        int [] arr = {4,5,6,7,0,1,2};
        int target = 0;

        int ans = search(arr, target);
        System.out.println("Targeted index: " + ans);
    }
    public static int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        // if u did not find a pivot, it means the array is not rotated
        if(pivot==-1){
            return binarySeach(nums,target,0,nums.length-1);
        }
        // if pivot is found, you have found 2 asc sorted arrays
        if(nums[pivot]==target){
            return pivot;
        }
        if(target>=nums[0]){
            return binarySeach(nums,target,0,pivot-1);
        }
        return binarySeach(nums,target,pivot+1,nums.length-1);

    }
    static int binarySeach(int[] arr,int target,int start,int end){
        while(start<=end){
            // find the middle element
//            int mid = (start+end)/2; // might be possible that error in sometimes (this may exceeds int error)
            int mid = start+(end-start)/2; // better way to find a mid
            if(target<arr[mid]){
                end=mid-1;
            }else if(target>arr[mid]){
                start=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    static int findPivot(int[] arr){
        int st=0,end=arr.length-1;
        while(st<=end){
            int mid = st+(end-st)/2;
            if(mid<end && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(mid>st && arr[mid]<arr[mid-1]){
                return mid;
            }
            if(arr[mid]<=arr[st]){
                end=mid-1;
            }else{
                st=mid+1;
            }
        }
        return -1;
    }
}
