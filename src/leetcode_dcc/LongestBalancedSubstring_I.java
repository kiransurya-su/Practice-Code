package leetcode_dcc;
/*
* 3713. Longest Balanced Substring I (Medium)
* You are given a string s consisting of lowercase English letters.

A substring of s is called balanced if all distinct characters in the substring appear the same number of times.

Return the length of the longest balanced substring of s.

Input: s = "abbac"
Output: 4

Streak->189
*
* * */

public class LongestBalancedSubstring_I {
    public static void main(String[] args) {
        System.out.println(longestBalanced("abbac"));
    }
    public static int longestBalanced(String s) {
        int n = s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            int[] freq=new int[26];
            for(int j=i;j<n;j++){
                freq[s.charAt(j)-'a']++;
                int min=Integer.MAX_VALUE;
                int max=0;
                for(int f:freq){
                    if(f>0){
                        min=Math.min(min,f);
                        max=Math.max(max,f);
                    }
                }
                if(min==max){
                    ans=Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
}
