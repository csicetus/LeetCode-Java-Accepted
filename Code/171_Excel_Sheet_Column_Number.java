/*
 * 171. Excel Sheet Column Number
 * Target: Given a column title as appear in an Excel sheet, return its corresponding column number.
 * Difficulty：Easy
 * Classification：Math
 */

/*
 * Solution 1
 * 2019-08-26  Runtime: 1 ms
 * Algorithm: => Math. 
 * Time Complexity: O(n). Space Conplexity: O(1)
 */
 
 class Solution {
    public int titleToNumber(String s) {
        if (s.length() == 0) return 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + s.charAt(i) - 'A' + 1;
        }
        return res;
    }
}


/*
 * Solution 2
 * 2019-08-26  Runtime: 37 ms
 * Algorithm: => Math. 
 * Time Complexity: O(n). Space Conplexity: O(1)
 */
 
 class Solution {
    public int titleToNumber(String s) {
        return s.chars().reduce(0, (r, c) -> r * 26 + (c - 'A' + 1));
    }
}
