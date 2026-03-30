package leetcode_dcc.mar_26;
/*
2573. Find the String with LCP (Hard)
We define the lcp matrix of any 0-indexed string word of n lowercase English letters as an n x n grid such that:
lcp[i][j] is equal to the length of the longest common prefix between the substrings word[i,n-1] and word[j,n-1].
Given an n x n matrix lcp, return the alphabetically smallest string word that corresponds to lcp. If there is no such string, return an empty string.
A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ, string a has a letter that appears earlier in the alphabet than the corresponding letter in b. For example, "aabd" is lexicographically smaller than "aaca" because the first position they differ is at the third letter, and 'b' comes before 'c'.

Input: lcp = [[4,3,2,1],[3,3,2,1],[2,2,2,1],[1,1,1,1]]
Output: "aaaa"
Explanation: lcp corresponds to any 4 letter string with a single distinct letter. The lexicographically smallest of them is "aaaa".

Streak->234
* */
import java.util.*;
public class FindTheStringWithLCP {
    public static void main(String[] args) {
        int[][] arr = {{4, 3, 2, 1}, {3, 3, 2, 1}, {2, 2, 2, 1},{1, 1, 1, 1}};
        System.out.println(findTheString(arr));
    }
    public static String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] res = new char[n];
        Arrays.fill(res, '#');

        // Step 1: diagonal check
        for (int i = 0; i < n; i++) {
            if (lcp[i][i] != n - i)
                return "";
        }

        // Step 2: assign characters
        char ch = 'a';

        for (int i = 0; i < n; i++) {
            if (res[i] == '#') {
                if (ch > 'z')
                    return "";

                for (int j = i; j < n; j++) {
                    if (lcp[i][j] > 0) {
                        res[j] = ch;
                    }
                }
                ch++;
            }
        }

        // Step 3: validate LCP
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int expected = 0;

                if (res[i] == res[j]) {
                    if (i == n - 1 || j == n - 1)
                        expected = 1;
                    else
                        expected = 1 + lcp[i + 1][j + 1];
                }

                if (lcp[i][j] != expected)
                    return "";
            }
        }

        return new String(res);
    }
}
