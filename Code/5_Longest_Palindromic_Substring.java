/*
 * 5. Longest Palindromic Substring
 * Target: Find the length of the longest palindromic substring.
 * Difficulty：Medium
 * Classification：String, Dynamic Programming
 */

/*
 * Solution 1
 * 2019-06-03 
  * Algorithm: Use one-dimensional(optimized by two-dimensional) to find Longest Common Substring. 
 *            The end position of Longest Common Substring of reverse string should corresponding to the orginal position.
 * Time complexity: O(n^2); space complexity: reduced to O(n)(two-dimensional space complexity is O(n^2)).
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
 * Time complexity: O(n^2); space complexity: reduced to O(n)(two-dimensional space complexity is O(n^2)).
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


/*
 * Solution 3
 * 2019-06-03  Runtime: 6 ms
 * Algorithm: 1. The palindrome must be symmetrical, so we can select a center position each time, 
 *               and expand left and right to determine whether the left and right characters are equal. 
 *            2. Because of the occurrence of odd and even strings, 
 *               We need to expand from one character or from position between two characters.
 * Time complexity: O(n^2); space complexity: O(1).
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


/*
 * Solution 4
 * 2019-06-03  Runtime: 22 ms
 * Algorithm: => Manacher's Algorithm           
 * Time complexity: O(n^2); space complexity: O(1).
 */
 
 class Solution {
    /* 
     * Change orginal string to the odd new string by adding "#" between each char and the beginning and the end of string.
     * Then add different two signs at the beginning and the end of string, such as "%" and "$".
     * "abba" => "%#a#b#b#a$"; "aba" => "%#a#b#a#$"
     */
  
    public String newStr(String s){
        String newStr = "%";
        
        if(s.length() == 0){
            return "";
        }
        for(int i = 0; i < s.length(); i++){
            newStr += "#" + s.charAt(i);
        }
        newStr += "#$";
        return newStr;
    }
    
    public String longestPalindrome(String s) {
        String T = newStr(s);
        int[] P = new int[T.length()];  // P[i] is the radius of longest palindrome string
        int C = 0, R = 0;  // C is Center position of the palindrome substring; R is END position of the palindrome substring
        int maxLen = 0;
        int centerPos = 0;  // Center position of longest palindrome string
        
        for(int i = 1; i < T.length() - 1; i++){
            int i_mirror = 2 * C - i;
            if(R > i){
            /* 
             * Since the C-centered palindrome substring is red 3, including substring 1 and substring 2, 
             * and substring 1 and substring 2 are centered on C. 
             * There must be substring 2 = substring 1. And it is known that substring 1 is the longest substring centered on j, 
             * then substring 2 is definitely the longest substring centered on i.
             */
               P[i] = Math.min(R - i, P[i_mirror]);
            }else{
                P[i] = 0; //  if i == R
            }
            
            while(T.charAt(i + P[i] + 1) == T.charAt(i - P[i] - 1)){  //  Calculate largest P[i] for each i
                P[i]++;
            }
            
            /* 
             * In the iteration, it is always guaranteed that R is the rightmost position at 
             * the end of all the palindrome substrings that have been obtained.
             */
            // Refresh R 
            if(P[i] + i > R){
                C = i;
                R = i + P[i];
            }
        }
        
        // Find the largest P[i]
        for(int i = 1; i < T.length() - 1; i++){
            if(P[i] > maxLen){
                maxLen = P[i];
                centerPos = i;
            }
        }
        int start = (centerPos - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}
