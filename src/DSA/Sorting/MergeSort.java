package DSA.Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {7,3,9,5,4,8,0,1};
        mergeSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr,int noOfElements){
        if(noOfElements<2) return;
        int mid=noOfElements/2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[noOfElements-mid];
        for(int i=0;i<mid;i++){
            leftArr[i]=arr[i];
        }
        for(int i=mid;i<noOfElements;i++){
            rightArr[i-mid]=arr[i];
        }
        mergeSort(leftArr,mid); // Apply merge sort on left partition
        mergeSort(rightArr,noOfElements-mid); // Apply merge sort on right partition
        merge(arr,leftArr,rightArr,mid,noOfElements-mid); // Finally merge the partitions

    }
    private static void merge(int[] arr,int[] leftArr,int[] rightArr,int left,int right){
        int i=0,j=0,k=0;
        // Merge arrays based on the smaller values
        while(i<left && j<right){
            if(leftArr[i]<=rightArr[j]){
                arr[k++]=leftArr[i++];
            }else{
                arr[k++]=rightArr[j++];
            }
        }
        // Fill out remaining values if any
        while(i<left){
            arr[k++]=leftArr[i++];
        }
        while(j<right){
            arr[k++]=rightArr[j++];
        }
    }
}
