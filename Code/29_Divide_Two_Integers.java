/*
 * 29. Divide Two Integers
 * Target: Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * Difficulty：Medium
 * Classification：Math, Binary Search
 */

/*
 * Solution 1
 * 2019-07-10  Runtime: 1 ms
 * Algorithm: => Math
 * Time Complexity: O((logn)^2), Space Conplexity: O(1)
 */

class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? true : false;
        long res = 0;
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);        
        while (absDividend >= absDivisor) {
            long count = 1;
            long tmp = absDivisor;
            while (tmp <= absDividend) {
                tmp <<= 1;
                count <<= 1;
            }
            res += count >> 1;
            absDividend -= tmp >> 1;
        }
        return isNegative ? (int) ~res + 1 : res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
    }
}
