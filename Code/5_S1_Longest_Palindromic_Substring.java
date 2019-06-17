/*
 * 5. Longest Palindromic Substring solution 1
 * 2019-06-03  Runtime: 61 ms
 * Target: Find the length of the longest palindromic substring.
 * Difficulty：Medium
 * Classification：String, Dynamic Programming
 * Algorithm: Use one-dimensional(optimized by two-dimensional) to find Longest Common Substring. 
 *            The end position of Longest Common Substring of reverse string should corresponding to the orginal position.
 * Note: Time complexity: O(n^2); space complexity: reduced to O(n)(two-dimensional space complexity is O(n^2)).
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
