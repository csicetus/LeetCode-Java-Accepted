/*
 * 69. Sqrt(x)
 * Target: Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Difficulty：Easy
 * Classification：Math, Binary Search
 */

/*
 * Solution 1
 * 2019-07-24  Runtime: 2 ms
 * Algorithm: => Math. Divide and Conquer
 * Time Complexity: O(logx). Space Conplexity: O(1)
 */
 
 class Solution {
    public int mySqrt(int x) {
        int l = 1, r = x;
        int res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int div = x / mid;
            if (div == mid) {
                return (int)mid;
            } else if (mid < div) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}


/*
 * Solution 2
 * 2019-07-24  Runtime: 3 ms
 * Algorithm: => Math. Formula
 * Time Complexity: ?. Space Conplexity: O(1)
 */

class Solution {
    public int mySqrt(int x) {
        double l = 0, r = x;
        double mid = (l + r) / 2;
        while (Math.abs(mid * mid - x) > 0.1) {
            double l_p = l * l - x;
            double mid_p = mid * mid - x;
            if (l_p * mid_p < 0) {
                r = mid;
            } else {
                l = mid;
            }
            mid = (l + r) / 2;
        }
        int res = (int)Math.round(mid);
        if (res != 0 && res > x / res) {
            res -= 1;
        }
        return res;
    }
}


/*
 * Solution 3
 * 2019-07-24  Runtime: 1 ms
 * Algorithm: => Math. Newton method: x_n+1 = x_n - f(x_n) / f'(x_n)
 * Time Complexity: ?. Space Conplexity: O(1)
 */
 
 class Solution {
    public int mySqrt(int x) {
        double root = x;
        while (root * root - x > 0.1) {
            root = (root + x / root) / 2;
        }
        int res = (int)Math.round(root);
        if (res != 0 && res > x / res) {
            res -= 1;
        }
        return res;
    }
}
