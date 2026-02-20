package leetcode_dcc.feb_26;
import java.util.*;
/*
761. Special Binary String (Hard)
Special binary strings are binary strings with the following two properties:
The number of 0's is equal to the number of 1's.
Every prefix of the binary string has at least as many 1's as 0's.
You are given a special binary string s.
A move consists of choosing two consecutive, non-empty, special substrings of s, and swapping them. Two strings are consecutive if the last character of the first string is exactly one index before the first character of the second string.
Return the lexicographically largest resulting string possible after applying the mentioned operations on the string.

Example 1:
Input: s = "11011000"
Output: "11100100"
Explanation: The strings "10" [occuring at s[1]] and "1100" [at s[3]] are swapped.
This is the lexicographically largest string possible after some number of swaps.

Example 2:
Input: s = "10"
Output: "10"

Streak->197
* */

public class Special_Binary_String {
    public static void main(String[] args) {
        String  s = "11011000";
        System.out.println(makeLargestSpecial(s));
    }
    public static String makeLargestSpecial(String s) {
        List<String> li = new ArrayList<>();
        int balance=0,st=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') balance++;
            else balance--;
            if(balance==0){
                String innerString = s.substring(st+1,i);
                String optimizedString = makeLargestSpecial(innerString);
                li.add("1"+optimizedString+"0");
                st=i+1;
            }
        }
        Collections.sort(li,Collections.reverseOrder());
        StringBuilder k = new StringBuilder();
        for(String l:li){
            k.append(l);
        }
        return k.toString();
    }
}
