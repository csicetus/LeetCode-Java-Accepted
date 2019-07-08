/*
 * 7. Reverse Integer
 * Target: Given a 32-bit signed integer, reverse digits of an integer.
 * Difficulty：Easy
 * Classification：Math
 */

/*
 * Solution 1
 * 2019-07-07  Runtime: 1 ms
 * Algorithm: => Math
 * Time Complexity: O(logx), Space Conplexity: O(1)
 */
 
class Solution {
    public int reverse(int x) {
        int sym = 0;
        long reverse = 0;
        if (x < 0) {
            sym = -1;
            x = -x;
        } else {
            sym = 1;
        }
        while (x != 0) {         
            reverse = reverse * 10 + x % 10;
            x /= 10;  
        }
        return (Math.abs(reverse) > Math.pow(2, 31)) ? 0 : (int)reverse * sym;
    }
}
