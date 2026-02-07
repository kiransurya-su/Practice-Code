package leetcode_dcc;
/*
 1653. Minimum Deletions to Make String Balanced (Medium)
 You are given a string s consisting only of characters 'a' and 'b',

You can delete any number of characters in s to make s balanced. s is balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.

Return the minimum number of deletions needed to make s balanced.

 Streak->184
 */
public class MinimumDeletionsToMakeStringBalanced {
    public static int minimumDeletions(String s) {
        int res=0,count=0;
        for(char ch:s.toCharArray()){
            if(ch=='b'){
                count++;
            }else if(count!=0){
                res++;
                count--;
            }
        }
        return res;

    }
    public static void main(String[] args) {
        String st="aababbab";
        System.out.println(minimumDeletions(st));
    }
}
