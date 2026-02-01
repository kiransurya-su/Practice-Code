package dsa.binarysearch;
//https://leetcode.com/problems/peak-index-in-a-mountain-array/
public class MountainArrayIndex {
    public static void main(String[] args) {
        int[] arr = {0,1,2,5,4,3};
        System.out.println(peakIndexInMountainArray(arr));
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
}
