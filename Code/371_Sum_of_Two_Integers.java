/*
 * 371. Sum of Two Integers
 * Target: Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * Difficulty：Easy
 * Classification：Bit Manipulation
 */

/*
 * Solution 1
 * 2019-08-28  Runtime: 0 ms
 * Algorithm: => Recusion. https://leetcode.com/problems/sum-of-two-integers/discuss/84278/A-summary%3A-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently
 * Time Complexity: O(b). Space Conplexity: O(1)
 */
 
 class Solution {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
 
/*
 * Solution 2
 * 2019-08-28  Runtime: 0 ms
 * Algorithm: => Iteration. 
 *               Helper Link: https://leetcode.com/problems/sum-of-two-integers/discuss/132479/Simple-explanation-on-how-to-arrive-at-the-solution
 * Time Complexity: O(b). Space Conplexity: O(1)
 */
 
 class Solution {
    public int getSum(int a, int b) {
        int c;
        while (b != 0) {
            c = a & b;
            a = a ^ b;
            b = c << 1;
        }
        return a;
    }
}

