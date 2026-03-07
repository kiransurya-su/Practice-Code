package leetcode_dcc.mar_26;
/*
1888. Minimum Number of Flips to Make the Binary String Alternating (Medium)
You are given a binary string s. You are allowed to perform two types of operations on the string in any sequence:

Type-1: Remove the character at the start of the string s and append it to the end of the string.
Type-2: Pick any character in s and flip its value, i.e., if its value is '0' it becomes '1' and vice-versa.
Return the minimum number of type-2 operations you need to perform such that s becomes alternating.

The string is called alternating if no two adjacent characters are equal.

For example, the strings "010" and "1010" are alternating, while the string "0100" is not.
Example 1:

Input: s = "111000"
Output: 2
Explanation: Use the first operation two times to make s = "100011".
Then, use the second operation on the third and sixth elements to make s = "101010".
Streak->212
* */

public class MinimumNumberOfFlipsToMakeTheBinaryStringAlternating {
    public static void main(String[] args) {
        String s = "111000";
        System.out.println(minFlips(s));
    }
    public static int minFlips(String s) {
        int n = s.length();
        String doubled=s+s;
        int d1=0,d2=0;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<doubled.length();i++){
            char e1=(i%2==0)?'0':'1';
            char e2=(i%2==0)?'1':'0';
            if(doubled.charAt(i)!=e1) d1++;
            if(doubled.charAt(i)!=e2) d2++;

            if(i>=n){
                char prev=doubled.charAt(i-n);
                char p1=((i-n)%2==0)?'0':'1';
                char p2=((i-n)%2==0)?'1':'0';
                if(prev!=p1) d1--;
                if(prev!=p2) d2--;

            }
            if(i>=n-1){
                ans=Math.min(ans,Math.min(d1,d2));
            }
        }
        return ans;
    }
}
