/*
 * 367. Valid Perfect Square
 * Target: Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *         Note: Do not use any built-in library function such as sqrt.
 * Difficulty：Easy
 * Classification：Math, Binary Search
 */

/*
 * Solution 1
 * 2019-08-06  Runtime: 0 ms
 * Algorithm: => Binary Search.
 * Time Complexity: O(n). Space Conplexity: O(1). 
 */
 
 class Solution {
    public boolean isPerfectSquare(int num) {
        int l = 0, r = num;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid  < num) {
                l = (int)mid + 1;
            } else if (mid * mid  > num) {
                r = (int)mid - 1;
            } 
        }
        return false;
    }
}
