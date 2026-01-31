import java.util.Arrays;

public class MinMax {
    public static void main(String[] args) {
        int[] arr = {100,-500,20,240,15000};
        int n = arr.length;
        int maxIndex = 0;
        int minIndex = 0;
        for(int i=1;i<n;i++){
            if(arr[i]>arr[maxIndex]) maxIndex=i;
            if(arr[i]<arr[minIndex]) minIndex=i;
        }
        int temp=arr[maxIndex];
        arr[maxIndex]=arr[minIndex];
        arr[minIndex]=temp;
        System.out.println(Arrays.toString(arr));
    }
}
