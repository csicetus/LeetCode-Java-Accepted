/*
 * 326. Power of Three
 * Target: Given an integer, write a function to determine if it is a power of three.
 * Difficulty：Easy
 * Classification：Math
 */

/*
 * Solution 1
 * 2019-08-24  Runtime: 11 ms
 * Algorithm: => Recursion
 * Time Complexity: ?. Space Conplexity: O(1)
 */
 
 class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        return (n % 3 == 0 && isPowerOfThree(n / 3));
    }
}


/*
 * Solution 2
 * 2019-08-24  Runtime: 11 ms
 * Algorithm: => Iteration
 * Time Complexity: ?. Space Conplexity: O(1)
 */
 
 class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        if (n > 1) {
            while (n % 3 == 0) {
                n /= 3;
            }
        }
        return n == 1;
    }
}


/*
 * Solution 3
 * 2019-08-24  Runtime: 11 ms
 * Algorithm: => Math.pow(3, 19) is the maximum integer of 3,  3^20 is bigger than int. Check if it is a multiple of the given input.
 * Time Complexity: ?. Space Conplexity: O(1)
 */
 
 class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        int maxPowerOfThree = (int)Math.pow(3, 19);
        return (n > 0 && maxPowerOfThree % n == 0);
    }
}


/*
 * Solution 4
 * 2019-08-24  Runtime: 11 ms
 * Algorithm: => Math. log(243) = 5.493061443340548, log(3) = 1.0986122886681098 ==> log(243)/log(3) = 4.999999999999999
 *                     log10(243) = 2.385606273598312, log10(3) = 0.47712125471966244 ==> log10(243)/log10(3) = 5.0
 * Time Complexity: ?. Space Conplexity: O(1)
 */
 
 class Solution {
    public boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}


/*
 * Solution 5
 * 2019-08-24  Runtime: 11 ms
 * Algorithm: => Math. log(243) = 5.493061443340548, log(3) = 1.0986122886681098 ==> log(243)/log(3) = 4.999999999999999
 *                     log10(243) = 2.385606273598312, log10(3) = 0.47712125471966244 ==> log10(243)/log10(3) = 5.0
 * Time Complexity: ?. Space Conplexity: O(1)
 */
 
 class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        return n == Math.pow(3, Math.round(Math.log(n) / Math.log(3)));
    }
}
