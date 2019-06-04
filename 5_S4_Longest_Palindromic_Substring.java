/*
 * 5. Longest Palindromic Substring solution 4
 * 2019-06-03  Runtime: 22 ms
 * Target: Find the length of the longest palindromic substring.
 * Difficulty：Medium
 * Classification：String, Dynamic Programming
 * Algorithm: Manacher's Algorithm
 * Note: Time complexity: O(n^2); space complexity: O(1).
 */
 
 class Solution {
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
        int[] P = new int[T.length()];
        int C = 0, R = 0;  
        int maxLen = 0;
        int centerPos = 0;
        
        for(int i = 1; i < T.length() - 1; i++){
            int i_mirror = 2 * C - i;
            if(R > i){
               P[i] = Math.min(R - i, P[i_mirror]); 
            }else{
                P[i] = 0; //if P[i] == R
            }
            
            while(T.charAt(i + P[i] + 1) == T.charAt(i - P[i] - 1)){
                P[i]++;
            }
            
            // Refresh R situation 
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
