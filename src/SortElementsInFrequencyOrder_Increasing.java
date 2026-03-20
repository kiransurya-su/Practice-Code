import java.util.*;
public class SortElementsInFrequencyOrder_Increasing {
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
        Arrays.sort(boxed,(a,b)->{
            if(mp.get(a).equals(mp.get(b))){
                return a-b;
            }
            return mp.get(b)-mp.get(a);
        });
        System.out.println(Arrays.toString(boxed));
    }
}
