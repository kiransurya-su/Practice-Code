import java.util.*;
/*
* Question: Valid Palindrome
    Given a string s, determine if it is a palindrome.
    Ignore non-alphanumeric characters
    Ignore case sensitivity

    Input: s = "A man, a plan, a canal: Panama"
    Output: true

    Input: s = "race a car"
    Output: false
    Return true if it is a palindrome, otherwise false.
    */
public class ValidPalindromeSentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine().replaceAll("[^A-Za-z0-9]","").toLowerCase();
        StringBuilder k = new StringBuilder(st);
        String rev = k.reverse().toString();
        System.out.println(st.equals(rev));
    }
}
