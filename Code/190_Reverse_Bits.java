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
 * Time Complexity: O(1). Space Conplexity: O(1)
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


/*
 * Solution 2
 * 2019-09-01  Runtime: 1 ms
 * Algorithm: => Bit. 
 * Time Complexity: O(1). Space Conplexity: O(1)
 */
 
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if (n == 0) return 0;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n & 1;
            n >>>= 1;
            if (i < 31) {
                res <<= 1;
            }
        }
        return res;
    }
}


/*
 * Solution 3
 * 2019-09-01  Runtime: 1 ms
 * Algorithm: => Bit Manipulation Trick. Select certain bits and reverse
 * Time Complexity: O(1). Space Conplexity: O(1)
 */

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if (n == 0) return 0;
        int res = n;
        res = ((res & 0xaaaaaaaa) >>> 1) | ((res & 0x55555555) << 1);
        res = ((res & 0xcccccccc) >>> 2) | ((res & 0x33333333) << 2);
        res = ((res & 0xf0f0f0f0) >>> 4) | ((res & 0x0f0f0f0f) << 4);
        res = ((res & 0xff00ff00) >>> 8) | ((res & 0x00ff00ff) << 8);
        res = ((res & 0xffff0000) >>> 16) | ((res & 0x0000ffff) << 16);
        return res;
    }
}
