package DSA.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2,3,4,6,7,8,10,11};
        int target=11;
        int ans=binarySeach(arr,target);
        System.out.println(ans);
    }
    // return the index
    // return -1 if does not exist
    static int binarySeach(int[] arr,int target){
        int start = 0;
        int end=arr.length-1;
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
}
