/*
 * 28. Implement strStr()
 * Target: Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Difficulty：Easy
 * Classification：String, Two pointers
 */

/*
 * Solution 1
 * 2019-07-09  Runtime: 3 ms
 * Algorithm: => Two pointers
 * Time Complexity: O(k*n), n is the length of haystack, k is the length of needle. Space Conplexity: O(1)
 */

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                if (j == needle.length()) {
                    return i - j + 1;
                } 
            } else {
                    i = i - j;
                    j = 0;
            }
        }
        return -1;
    }
}
