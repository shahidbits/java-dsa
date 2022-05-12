package drivers;

import string.LongestPalindromicSubstring;
import string.ValidAnagram;

public class StringDriver {

    public void anagram() {
        ValidAnagram validAnagram = new ValidAnagram();
        validAnagram.isAnagram("anagram", "nagaram");
    }

    public void longestPalindromicSubstring() {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println("longest palindrome=" + longestPalindromicSubstring.longestPalindrome("babad"));
    }

}
