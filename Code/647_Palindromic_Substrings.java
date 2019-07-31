/*
 * 647. Palindromic Substrings
 * Target: Given a string, your task is to count how many palindromic substrings in this string.
 *         The substrings with different start indexes or end indexes are counted as diff substrings even they consist of same characters.
 * Difficulty：Medium
 * Classification：String, DP
 */

/*
 * Solution 1
 * 2019-07-31  Runtime: 1 ms
 * Algorithm: => Extend Palindrome.
 * Time Complexity: ?. Space Conplexity: O(1)
 */

class Solution {
    int res = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        for (int mid_point = 0; mid_point < n; mid_point++) {
            // odd string
            extendPalindrome(s, mid_point, mid_point);
            // even string
            extendPalindrome(s, mid_point, mid_point + 1);
        }
        return res;
    }
    
    private void extendPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            res++;
            l--;
            r++;
        }
    }
}


/*
 * Solution 2
 * 2019-07-31  Runtime: 1 ms
 * Algorithm: => Extend Palindrome. No global variable.
 * Time Complexity: ?. Space Conplexity: O(1)
 */
 
class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length(), res = 0;
        for (int mid_point = 0; mid_point < n; mid_point++) {
            // odd string
            res += extendPalindrome(s, mid_point, mid_point);
            // even string
            res += extendPalindrome(s, mid_point, mid_point + 1);
        }
        return res;
    }
    
    private int extendPalindrome(String s, int l, int r) {
        int res = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            res++;
            l--;
            r++;
        }
        return res;
    }
}


/*
 * Solution 3
 * 2019-07-31  Runtime: 5 ms
 * Algorithm: => DP. Refer to longest palindromic substring problem.
 *               If string is axa, j - i = 2 < 3, since a is matched with a, x does not matter here.
 * Time Complexity: ?. Space Conplexity: O(1)
 */
 
 class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length(), res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }
}
