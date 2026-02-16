package leetcode_dcc.feb_26;
/*
190. Reverse Bits (Easy)

Reverse bits of a given 32 bits signed integer.

Example 1:

Input: n = 43261596

Output: 964176192

Explanation:

Integer-> 43261596
Binary-> 00000010100101000001111010011100

Integer->964176192
Binary->00111001011110000010100101000000
-----------------------------------------

Streak->193
* */
public class Reverse_Bits {
    public static void main(String[] args) {
        int num=43261596;
        System.out.println(reverseBits(num));
    }
    public static int reverseBits(int n) {
        int result=0;
        for(int i=0;i<32;i++){
            result<<=1;
            result|=(n&1);
            n>>=1;
        }
        return result;
    }
}
