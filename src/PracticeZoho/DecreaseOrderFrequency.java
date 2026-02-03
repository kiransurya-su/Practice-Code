package PracticeZoho;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DecreaseOrderFrequency {
    public static void main(String[] args) {
        int[] arr={4,1,2,3,1,2,5,2};
        System.out.println(Arrays.toString(decOrder(arr)));
    }
    public static Integer[] decOrder(int[] arr){
        Map<Integer,Integer> mp = new HashMap<>();
        for(int num:arr){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(nums,(a,b)->{
            int freqCompare=mp.get(b)-mp.get(a);
            return freqCompare!=0?freqCompare:b-a;
        });
        return nums;
    }
}
