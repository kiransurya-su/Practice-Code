package leetcode_dcc.feb_26;
/*
* 67. Add Binary (Easy)
* Given two binary strings a and b, return their sum as a binary string.
Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
*  Streak -> 192
* */
import java.math.*;
public class Add_Binary {
    public static void main(String[] args) {
        String a = "11", b = "1";
        System.out.println(addBinary(a,b));
    }
    public static String addBinary(String s1, String s2) {
        BigInteger a = new BigInteger(s1,2);
        BigInteger b = new BigInteger(s2,2);
        BigInteger sum = a.add(b);
        String result = sum.toString(2);
        return result;
    }
}
