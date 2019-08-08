/*
 * 441. Arranging Coins
 * Target: You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 *         Given n, find the total number of full staircase rows that can be formed.
 *         n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * Difficulty：Easy
 * Classification：Math, Binary Search
 */

/*
 * Solution 1
 * 2019-08-08  Runtime: 1 ms
 * Algorithm: => Binary Search
 * Time Complexity: O(logn). Space Conplexity: O(1). 
 */
 
 class Solution {
    public int arrangeCoins(int n) {
        long l = 0, r = (long)n;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (mid * (mid + 1) <= 2 * (long)n) { 
                l = mid + 1;
            } else  {
                r = mid - 1;
            }
        }
        return (int)l - 1;
    }
}

 
 /*
 * Solution 2
 * 2019-08-08  Runtime: 1 ms
 * Algorithm: => Math
 * Time Complexity: O(1). Space Conplexity: O(1). 
 */
 
 class Solution {
    public int arrangeCoins(int n) {
        return (int)(Math.sqrt(1 + 8.0 * n) - 1) / 2;
    }
}
 
