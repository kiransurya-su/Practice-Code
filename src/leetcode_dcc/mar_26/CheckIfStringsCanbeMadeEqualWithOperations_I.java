package leetcode_dcc.mar_26;
/*
2839. Check if Strings Can be Made Equal With Operations I (Easy)
You are given two strings s1 and s2, both of length 4, consisting of lowercase English letters.
You can apply the following operation on any of the two strings any number of times:
Choose any two indices i and j such that j - i = 2, then swap the two characters at those indices in the string.
Return true if you can make the strings s1 and s2 equal, and false otherwise.
Example 1:

Input: s1 = "abcd", s2 = "cdab"
Output: true
Explanation: We can do the following operations on s1:
- Choose the indices i = 0, j = 2. The resulting string is s1 = "cbad".
- Choose the indices i = 1, j = 3. The resulting string is s1 = "cdab" = s2.

Streak->235
* */
public class CheckIfStringsCanbeMadeEqualWithOperations_I {
    public static void main(String[] args) {
        String s1 = "abcd", s2 = "cdab";
        System.out.println(canBeEqual(s1,s2));
    }
    public static boolean canBeEqual(String s1, String s2) {
        return match(s1.charAt(0),s1.charAt(2),s2.charAt(0),s2.charAt(2)) &&
                match(s1.charAt(1),s1.charAt(3),s2.charAt(1),s2.charAt(3));
    }
    private static boolean match(char a, char b,char c, char d){
        return (a==c&&b==d) || (a==d && b==c);
    }
}
