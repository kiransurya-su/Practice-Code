package leetcode_dcc.mar_26;
/*
2840. Check if Strings Can be Made Equal With Operations II (Hard)
You are given two strings s1 and s2, both of length n, consisting of lowercase English letters.
You can apply the following operation on any of the two strings any number of times:
Choose any two indices i and j such that i < j and the difference j - i is even, then swap the two characters at those indices in the string.
Return true if you can make the strings s1 and s2 equal, and false otherwise.
Example 1:
Input: s1 = "abcdba", s2 = "cabdab"
Output: true
Explanation: We can apply the following operations on s1:
- Choose the indices i = 0, j = 2. The resulting string is s1 = "cbadba".
- Choose the indices i = 2, j = 4. The resulting string is s1 = "cbbdaa".
- Choose the indices i = 1, j = 5. The resulting string is s1 = "cabdab" = s2.

Streak->236
* */
public class CheckIfStringsCanbeMadeEqualWithOperations_II {
    public static void main(String[] args) {
        String s1 = "abcdba", s2 = "cabdab";
        System.out.println(checkStrings(s1,s2));
    }
    public static boolean checkStrings(String s1, String s2) {
        int[] even = new int[26];
        int[] odd  = new int[26];
        for(int i=0;i<s1.length();i++){
            if(i%2==0){
                even[s1.charAt(i)-'a']++;
                even[s2.charAt(i)-'a']--;
            }else{
                odd[s1.charAt(i)-'a']++;
                odd[s2.charAt(i)-'a']--;
            }
        }
        for(int i:even) if(i!=0) return false;
        for(int i:odd) if(i!=0) return false;
        return true;
    }
}
