/*
 * 8. String to Integer (atoi)
 * Target: Implement atoi which converts a string to an integer.
 * Difficulty：Medium
 * Classification：Math, String
 */

/*
 * Solution 1
 * 2019-07-07  Runtime: 1 ms
 * Algorithm: => Math
 * Time Complexity: O(n), n is the length of str. Space Conplexity: O(1)
 */
 
 class Solution {
    public int myAtoi(String str) {
        int sym = 1;
        int res = 0, pop = 0;
        boolean hasBegin = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-' && !hasBegin) {
                sym = -1;
                hasBegin = true;
                continue;
            }
            if (str.charAt(i) == '+' && !hasBegin) {
                sym = 1;
                hasBegin = true;
                continue;
            }
            if (str.charAt(i) == ' ' && !hasBegin) continue;
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                hasBegin = true;
                pop = str.charAt(i) - '0';
                if (res * sym > Integer.MAX_VALUE / 10 || (res * sym == Integer.MAX_VALUE / 10 && pop * sym > 7)) {
                    return 2147483647;
                } else if (res * sym < Integer.MIN_VALUE / 10 || (res * sym == Integer.MIN_VALUE / 10 && pop * sym < -8)) {
                    return -2147483648;
                }
                res = res * 10 + pop;
            } else {
                    return res * sym;
            }
        }
        return res * sym;
    }
}
 
