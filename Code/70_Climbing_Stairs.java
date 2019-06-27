/*
 * 70. Climbing Stairs
 * Target: Each time we can either climb 1 or 2 steps. Find the number of distinct ways we can climb to the top.
 * Difficulty：Easy
 * Classification：DP
 */

/*
 * Solution 1
 * 2019-06-27  Runtime: 0 ms
 * Algorithm: => Memoization by using HashMap(optimal recursion).
 * Time complexity: ? Space complexity: ?
 */
 
 class Solution {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return getPath(n, map);
    }
    
    public int getPath(int n, HashMap<Integer, Integer> map) {
        int a = 0;
        int b = 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (!map.containsKey(n - 1)) {
            a = getPath(n - 1, map);
            map.put(n - 1, a);
        } else {
            a = map.get(n - 1);
        }
        if (!map.containsKey(n - 2)) {
            b = getPath(n - 2, map);
            map.put(n - 2, b);
        } else {
            b = map.get(n - 2);
        }
        return a + b;
    }
}


/*
 * Solution 2
 * 2019-06-27  Runtime: 0 ms
 * Algorithm: => Memoization by using Array(optimal solution 1).
 * Time complexity: ? Space complexity: ?
 */

class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        return getPath(n, arr);
    }
    
    public int getPath(int n, int[] arr) {
        int a = 0;
        int b = 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (arr[n - 1] == 0) {
            a = getPath(n - 1, arr);
            arr[n - 1] = a;
        } else {
            a = arr[n - 1];
        }
        if (arr[n - 2] == 0) {
            b = getPath(n - 2, arr);
            arr[n - 2] = b;
        } else {
            b = arr[n - 2];
        }
        return a + b;
    }
}


/*
 * Solution 3
 * 2019-06-27  Runtime: 0 ms
 * Algorithm: => DP
 * Time complexity: O(n) Space complexity: O(n)
 */

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        if (n == 1) return 1;
        if (n == 2) return 2;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}


/*
 * Solution 4
 * 2019-06-27  Runtime: 0 ms
 * Algorithm: => Iteration - 斐波那契数列(Fibonacci sequence).
 * Time complexity: O(n) Space complexity: O(1)
 */

class Solution {
    public int climbStairs(int n) {
        int a = 1;
        int b = 2;
        if (n == 1) return 1;
        if (n == 2) return 2;
        for (int i = 3; i <= n; i++) {
            int tmp = b;
            b = a + b;
            a = tmp;
        }
        return b;
    }
}


/*
 * Solution 5
 * 2019-06-27  Runtime: 0 ms
 * Algorithm: => Formulation
 * Time complexity: O(logn) Space complexity: O(1)
 */
 
 
 /*
 * Solution 6
 * 2019-06-27  Runtime: 0 ms
 * Algorithm: => Formulation
 * Time complexity: O(logn) Space complexity: O(1)
 */

