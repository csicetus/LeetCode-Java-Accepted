/*
 * 191. Number of 1 Bits
 * Target: Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
 * Difficulty：Easy
 * Classification：Bit Manipulation
 */

/*
 * Solution 1
 * 2019-09-02  Runtime: 1 ms
 * Algorithm: => Bit. 
 * Time Complexity: O(1), n in this piece of code is a 32-bit integer. Space Conplexity: O(1)
 */
 
 public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) res++;
            mask <<= 1;
        }
        return res;
    }
}


/*
 * Solution 2
 * 2019-09-02  Runtime: 0 ms
 * Algorithm: => Bit Manipulation Trick. 
 *               In the binary representation, the least significant 1-bit in n always corresponds to a 0-bit in n - 1. 
 *               Therefore, anding the two numbers nn and n - 1 always flips the least significant 1-bit in n to 0, 
 *               and keeps all other bits the same.
 * Time Complexity: O(1). Space Conplexity: O(1)
 */
 
 public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= (n - 1);
        }
        return res;
    }
}
 
