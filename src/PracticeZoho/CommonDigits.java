package PracticeZoho;
import java.util.*;
public class CommonDigits {
    public static void main(String[] args) {
        int[] nums = {111, 222, 333, 4444, 666};
        for(int num:common_digits(nums)){
            System.out.print(num+" ");
        }
    }
    public static int[] common_digits(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int num:nums){
            while(num!=0){
                st.add(num%10);
                num/=10;
            }
        }
        int k=0;
        int[] arr = new int[st.size()];
        for(int el:st){
            arr[k++]=el;
        }
        return arr;
    }
}
