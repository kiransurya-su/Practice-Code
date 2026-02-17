package DSA.binarysearch;

public class OrderAgnosticBS {
    public static void main(String[] args) {
        int[] arr = {2,3,4,6,7,8,10,11,22,99,110};
        int target=99;
        int ans=OrderAgnostic_BS(arr,target);
        System.out.println(ans);
    }
    static int OrderAgnostic_BS(int[] arr,int target){
        int start = 0;
        int end=arr.length-1;
        boolean isAsc = arr[start]<arr[end];
        while(start<=end){
            // find the middle element
//            int mid = (start+end)/2; // might be possible that error in sometimes (this may exceeds int error)
            int mid = start+(end-start)/2; // better way to find a mid
            if(arr[mid]==target){
                return mid;
            }
            if(isAsc){
                if(target<arr[mid]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            } else{
                if(target>arr[mid]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }

        }
        return -1;
    }
}
