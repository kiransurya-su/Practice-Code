import java.util.*;
public class MoveZerosInLast {
    public static void main(String[] args) {
        int[] arr = {1,2,0,2,0,5,6,7,0,900,10,0,1,11,4,5,60,0,01,10};
        int n = arr.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                arr[count++]=arr[i];
            }
        }
        for(int i=count;i<n;i++){
            arr[i]=0;
        }
        System.out.println(Arrays.toString(arr));
    }
}
