package leetcode_dcc.mar_26;
/*
1545. Find Kth Bit in Nth Binary String (Medium)

Given two positive integers n and k, the binary string Sn is formed as follows:

S1 = "0"
Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
Where + denotes the concatenation operation, reverse(x) returns the reversed string x, and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).

For example, the first four strings in the above sequence are:

S1 = "0"
S2 = "011"
S3 = "0111001"
S4 = "011100110110001"
Return the kth bit in Sn. It is guaranteed that k is valid for the given n.

Example 1:

Input: n = 3, k = 1
Output: "0"
Explanation: S3 is "0111001".
The 1st bit is "0".
Example 2:

Input: n = 4, k = 11
Output: "1"
Explanation: S4 is "011100110110001".
The 11th bit is "1".

Streak->208
* */
public class FindTheKthBitInNthBinaryString {
    public static void main(String[] args) {
        int n = 4, k = 11;
        System.out.println(findKthBit(n,k));
    }
    public static char findKthBit(int n, int k) {
        String s="0";
        for(int i=1;i<n;i++){
            String front=s;
            StringBuilder sb=new StringBuilder(s);
            for(int j=0;j<sb.length();j++){
                sb.setCharAt(j,sb.charAt(j)=='1'?'0':'1');
            }
            sb.reverse();
            s=front+"1"+sb.toString();
        }
        return s.charAt(k-1);
    }
}
