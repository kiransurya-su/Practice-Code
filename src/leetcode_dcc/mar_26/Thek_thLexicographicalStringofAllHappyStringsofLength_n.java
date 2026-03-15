package leetcode_dcc.mar_26;
import java.util.*;
/*
1415. The k-th Lexicographical String of All Happy Strings of Length n (Medium)
A happy string is a string that:

consists only of letters of the set ['a', 'b', 'c'].
s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are not happy strings.

Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.

Return the kth string of this list or return an empty string if there are less than k happy strings of length n.

Streak->221

* */
public class Thek_thLexicographicalStringofAllHappyStringsofLength_n {
    public static void main(String[] args) {
        int n=1,k=3;
        System.out.println(getHappyString(n,k));
    }
    static List<String> li = new ArrayList<>();
    public static String getHappyString(int n, int k) {
        track(n,"");
        if(k>li.size()) return "";
        return li.get(k-1);
    }
    private static void track(int n,String cur){
        if(cur.length()==n){
            li.add(cur);
            return;
        }
        for(char ch:new char[]{'a','b','c'}){
            if(cur.length()>0 && cur.charAt(cur.length()-1)==ch) continue;
            track(n,cur+ch);
        }
    }
}
