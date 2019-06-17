/*
 * 5. Longest Palindromic Substring solution 3
 * 2019-06-03  Runtime: 6 ms
 * Target: Find the length of the longest palindromic substring.
 * Difficulty：Medium
 * Classification：String, Dynamic Programming
 * Algorithm: 1. The palindrome must be symmetrical, so we can select a center position each time, 
 *               and expand left and right to determine whether the left and right characters are equal. 
 *            2. Because of the occurrence of odd and even strings, 
 *               We need to expand from one character or from position between two characters.
 * Note: Time complexity: O(n^2); space complexity: O(1).
 */

class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        if(s.length() < 1 || s.equals("")) return "";
        for(int i = 0; i < s.length(); i++){
            int len1 = expandCenter(s, i, i);
            int len2 = expandCenter(s, i, i + 1);
            int maxLen = Math.max(len1, len2);
            if(maxLen > end - start + 1){
                start = i - (maxLen - 1)/ 2;
                end = maxLen/2 + i;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int expandCenter(String s, int left, int right){
        int L = left, R = right;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R - L - 1;
    }
}
