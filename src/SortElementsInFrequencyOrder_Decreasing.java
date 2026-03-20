import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class SortElementsInFrequencyOrder_Decreasing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Map<Integer,Integer> mp = new HashMap<>();
        for(int num:arr){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        Integer[] boxed = new Integer[n];
        for(int i=0;i<n;i++) boxed[i]=arr[i];
        Arrays.sort(boxed,(a, b)->{
            if(mp.get(a).equals(mp.get(b))){
                return b-a;
            }
            return mp.get(a)-mp.get(b);
        });
        System.out.println(Arrays.toString(boxed));
    }
}
