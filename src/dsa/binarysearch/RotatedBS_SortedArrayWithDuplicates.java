package dsa.binarysearch;

public class RotatedBS_SortedArrayWithDuplicates {

    public static void main(String[] args) {
        int [] arr = {2,5,6,0,0,1,2};
        int target = 0;

        boolean ans = search(arr, target);
        System.out.println(ans);
    }
    public static boolean search(int[] nums, int target) {
        int pivot = findPivotWithDuplicates(nums);
        // if u did not find a pivot, it means the array is not rotated
        if(pivot==-1){
            return binarySeach(nums,target,0,nums.length-1);
        }
        // if pivot is found, you have found 2 asc sorted arrays
        if(nums[pivot]==target){
            return true;
        }
        if(target>=nums[0]){
            return binarySeach(nums,target,0,pivot-1);
        }
        return binarySeach(nums,target,pivot+1,nums.length-1);

    }
    static boolean binarySeach(int[] arr,int target,int start,int end){
        while(start<=end){
            // find the middle element
//            int mid = (start+end)/2; // might be possible that error in sometimes (this may exceeds int error)
            int mid = start+(end-start)/2; // better way to find a mid
            if(target<arr[mid]){
                end=mid-1;
            }else if(target>arr[mid]){
                start=mid+1;
            }else{
                return true;
            }
        }
        return false;
    }
    static int findPivotWithDuplicates(int[] arr){
        int st=0,end=arr.length-1;
        while(st<=end){
            int mid = st+(end-st)/2;
            if(mid<end && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(mid>st && arr[mid]<arr[mid-1]){
                return mid-1;
            }

            // if elements at middle,st,end are equal just skip the duplicates

            if(arr[mid]==arr[st] && arr[mid]==arr[end]){
                // skip the duplicates
                // Note: what if these elements at st and end were the pivot
                // check if st is pivot
                if(st<end && arr[st]>arr[st+1]){
                    return st;
                }
                st++;
                // check wheather end is pivot
                if(end>st && arr[end]<arr[end-1]){
                    return end-1;
                }
                end--;
            }
            // left side is sorted, so pivot should be in right
            else if(arr[st]<arr[mid] || (arr[st]==arr[mid] && arr[mid]>arr[end])){
                st=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }
}
