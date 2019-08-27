/*
 * 172. Factorial Trailing Zeroes
 * Target: Given an integer n, return the number of trailing zeroes in n!.
 *         Note: Your solution should be in logarithmic time complexity.
 * Difficulty：Easy
 * Classification：Math
 */

/*
 * Solution 1
 * 2019-08-26  Runtime: 0 ms
 * Algorithm: => Math and Recursion. If we want to obtain trailing zeroes in n!, we just need to find how many 2 * 5 = 10 in n.
 *               Since we can find there're too many even numbers(can be divided by 2), we just need to find the number of factor 5 in n.
 *               For example, if n = 20, then we have 1, 5, 10 and 20, which seems like result is 20 / 5 = 4?
 *               Note that if n = 25, then we have 1, 5, 10, 20 and 25. However, 25 = 5 * 5, so there're six 5 in 25!, which means
 *               we should also add trailingZeroes(25 / 5).
 * Time Complexity: O(log_5_n). Space Conplexity: O(1)
 */
 
 class Solution {
    public int trailingZeroes(int n) {
        if (n < 4) return 0;
        return n / 5 + trailingZeroes(n / 5);
    }
}


/*
 * Solution 2
 * 2019-08-26  Runtime: 0 ms
 * Algorithm: => Math and Iteration. Same as sol 1.
 * Time Complexity: O(log_5_n). Space Conplexity: O(1)
 */
 
 class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 4) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
