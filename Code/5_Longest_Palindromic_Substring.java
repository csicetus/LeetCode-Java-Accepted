/*
 * 5. Longest Palindromic Substring
 * Target: Find the length of the longest palindromic substring.
 * Difficulty：Medium
 * Classification：String, Dynamic Programming
 */

/*
 * Solution 1
 * 2019-06-03  Runtime: 61 ms
  * Algorithm: Use one-dimensional(optimized by two-dimensional) to find Longest Common Substring. 
 *            The end position of Longest Common Substring of reverse string should corresponding to the orginal position.
 * Note: Time complexity: O(n^2); space complexity: reduced to O(n)(two-dimensional space complexity is O(n^2)).
 * Time complexity: ? Space complexity: ?
 */

 class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int maxEnd = 0;
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[] arr = new int[length];
        
        if(s.equals("")) return "";
        for(int i = 0; i < length; i++){
            for(int j = length - 1; j >= 0; j--){
                if(origin.charAt(i) == reverse.charAt(j)){
                    if(i == 0 || j == 0){
                        arr[j] = 1;
                    }
                    else{
                        arr[j] = arr[j - 1] + 1;
                    }                    
                }
                else{
                    arr[j] = 0;
                }
                if(arr[j] > maxLen){
                    int beforePos = length - j - 1;
                    if(beforePos + arr[j] - 1 == i) {
                        maxEnd = i;
                        maxLen = arr[j];
                    }
                }
            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }
}


/*
 * Solution 2
 * 2019-06-03  Runtime: 43 ms
 * Algorithm: P(i, j) = {   true   s[i, j] is palindromic substring
 *                          false  s[i, j] is not palindromic substring}
 *            P(i, j) = (P(i + 1, j - 1) && s[i] == s[j]).
 * Note: Time complexity: O(n^2); space complexity: reduced to O(n)(two-dimensional space complexity is O(n^2)).
 * Time complexity: ? Space complexity: ?
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
