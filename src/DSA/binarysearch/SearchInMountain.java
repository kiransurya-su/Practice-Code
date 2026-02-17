package DSA.binarysearch;
// https://leetcode.com/problems/find-in-mountain-array/description/
public class SearchInMountain {
    public static void main(String[] args) {
        SearchInMountain obj = new SearchInMountain();

        int[] arr = {1, 3, 5, 7, 6, 4, 2}; // mountain array
        int target = 6;

        int ans = obj.search(arr, target);
        System.out.println("Target index: " + ans);
    }
    int search(int[] arr,int target){
        int peak=peakIndexInMountainArray(arr);
        int firstTry=OrderAgnostic_BS(arr,target,0,peak);
        if(firstTry!=-1){
            return firstTry;
        }
        // try to search in 2nd Half
        return OrderAgnostic_BS(arr,target,peak+1,arr.length-1);
    }
    public static int peakIndexInMountainArray(int[] arr) {
        int st=0;
        int end=arr.length-1;
        while(st<end){
            int mid=st+(end-st)/2;
            if(arr[mid]>arr[mid+1]){
                // decreasing part of array
                // it may be a answer, but look at left
                end=mid; // this is why end!=mid-1;
            }else{
                // increasing part of array
                st=mid+1; // arr[mid+1]>arr[mid]
            }
        }
        // in the end, st==end and pointing to the largest number because of the 2 checks above
        // start and end are always trying to find max element in the above 2 checks
        // hence when they are pointing to just one element , that is the max one bacause that is what is the checks say
        // more elaboration: at every point of time for start and end, they have the best possible answer till that time
        // and if we are saying that only one item is remaining, hence cuz above line that is the best possible answer
        return st;
    }
    static int OrderAgnostic_BS(int[] arr,int target,int start,int end){
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
