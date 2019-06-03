/*
 * 5. Longest Palindromic Substring solution 2
 * 2019-06-03  Runtime: 43 ms
 * Target: Find the length of the longest palindromic substring.
 * Difficulty：Medium
 * Classification：String, Dynamic Programming
 * Algorithm: P(i, j) = {   true   s[i, j] is palindromic substring
 *                          false  s[i, j] is not palindromic substring}
 *            P(i, j) = (P(i + 1, j - 1) && s[i] == s[j]).
 * Note: Time complexity: O(n^2); space complexity: reduced to O(n)(two-dimensional space complexity is O(n^2)).
 */
 
 class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[] bo = new boolean[n];
        String res = "";
        
        for(int i = n - 1; i >= 0; i--){
            for(int j = n - 1; j >= i; j--){
                bo[j] = (s.charAt(i) == s.charAt(j)) && (j - i < 3|| bo[j - 1]);

                if(bo[j] && j - i + 1 > res.length()){
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
