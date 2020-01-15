///////////// sol 1: math

// Time: O(logn) for Math.pow; Space: O(1)
class Solution {
    public int integerBreak(int n) {
        // when x = N / 2
        // even: N/2 * N/2 >= N -> x >= 4
        // odd: (N-1)/2 * (N+1)/2 -> x >=5
        // if x >= 4, we can do the break to get better
        // so x = 1(obviously not), 2, 3
        // for 6, 3*3 > 2*2*2
        // the optimal should contain no more than 3
        if (n == 2) return 1;
        if (n == 3) return 2;
        int num_3 = n / 3;
        int remainder = n % 3;
        System.out.println("num_3 " + num_3);
        System.out.println("remainder " + remainder);
        // x*x*x*1 < x*x*y, y = x + 1
        if (remainder == 1) {
            remainder = 4;
            num_3--;
        // set remainder = 1 to maintain 3^num_3 == n
        } else if (remainder == 0) {
            remainder = 1;
        }
        return (int)Math.pow(3, num_3) * remainder;
    }
}
