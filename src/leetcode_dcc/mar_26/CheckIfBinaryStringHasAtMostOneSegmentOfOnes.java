package leetcode_dcc.mar_26;
/*
1784. Check if Binary String Has at Most One Segment of Ones (Easy)
Given a binary string S without leading zeros, return true, if s contains at most one contiguous segment of ones. Otherwise, return false.

Input: s = "1001"
Output: false
Explanation: The ones do not form a contiguous segment.

Streak->211
* */
public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
    public static void main(String[] args) {
        String s = "1001";
        System.out.println(checkOnesSegment(s));
    }
    public static boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
