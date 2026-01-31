package dsa.binarysearch;

public class FloorNumber {
    public static void main(String[] args) {
        int[] arr={2,3,5,9,14,16,18};
        int target=15;
        System.out.println(search(arr,target));
    }

static int search(int[] arr,int target){
    int st = 0, end = arr.length-1;
    while(st<=end){
        int mid = st+(end-st)/2;
        if(arr[mid]==target){
            return arr[mid];
        }else if(target>arr[mid]){
            st=mid+1;
        }
        else{
            end=mid-1;
        }
    }
    return arr[end];
}
}