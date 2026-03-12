package leetcode_dcc.mar_26;
/*

1758. Minimum Changes To Make Alternating Binary String (Easy)

You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.
The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.
Return the minimum number of operations needed to make s alternating.

Streak->210
* */
public class MinimumChangesToMakeAlternatingBinaryString {
    public static void main(String[] args) {
        String s = "10";
        System.out.println(minOperations(s));
    }

    public static int minOperations(String s) {
        int st0=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(i%2==0){
                if(ch=='1'){
                    st0++;
                }
            }else{
                if(ch=='0'){
                    st0++;
                }
            }
        }
        return Math.min(st0,s.length()-st0);
    }
}
