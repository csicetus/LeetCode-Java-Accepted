/*
 * 190. Reverse Bits
 * Target: Reverse bits of a given 32 bits unsigned integer.
 * Difficulty：Easy
 * Classification：Bit Manipulation
 */

/*
 * Solution 1
 * 2019-08-31  Runtime: 1 ms
 * Algorithm: => Bit. 
 * Time Complexity: ?. Space Conplexity: O(1)
 */
 
 public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if (n == 0) return 0;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            if ((n & 1) == 1) res++;
            n >>= 1;
        }
        return res;
    }
}
