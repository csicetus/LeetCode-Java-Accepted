/*
 * 5. Longest Palindromic Substring solution 4
 * 2019-06-03  Runtime: 22 ms
 * Target: Find the length of the longest palindromic substring.
 * Difficulty：Medium
 * Classification：String, Dynamic Programming
 * Algorithm: => Manacher's Algorithm           
 * Note: Time complexity: O(n^2); space complexity: O(1).
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
