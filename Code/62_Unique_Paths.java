/*
 * 62. Unique Paths
 * Target: Robot unique paths
 * Difficulty：Medium
 * Classification：Array, Greedy
 * Best solution: solution 3.
 */

/*
 * Solution 1
 * 2019-06-26  Runtime: 5 ms
 * Algorithm: => Recursion.
 * Time complexity: ? Space complexity: ?
 */
 
 class Solution {
    public int uniquePaths(int m, int n) {
        HashMap<String, Integer> visited = new HashMap<>();
        return getPath(0, 0, m - 1, n - 1, 0, visited);
    }

    private int getPath(int x, int y, int m, int n, int num, HashMap<String, Integer> visited) {
        if (x == m && y == n) {
            return 1;
        }
        int n1 = 0;
        int n2 = 0;
        String key = x + 1 + "@" + y;
        if (!visited.containsKey(key)) {
            if (x + 1 <= m) {
                n1 = getPath(x + 1, y, m, n, num, visited);
            }
        } else {
            n1 = visited.get(key);
        }
        key = x + "@" + (y + 1);
        if (!visited.containsKey(key)) {
            if (y + 1 <= n) {
                n2 = getPath(x, y + 1, m, n, num, visited);
            }
        } else {
            n2 = visited.get(key);
        }
        key = x + "@" + y;
        visited.put(key, n1+n2);
        return n1 + n2;
    }
}



/*
 * Solution 2
 * 2019-06-27  Runtime: 0 ms
 * Algorithm: => Iteration.
 * Time complexity: O(m*n) Space complexity: O(n)
 */

class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        
        return dp[n - 1];
    }
}


/*
 * Solution 3
 * 2019-06-27  Runtime: 0 ms
 * Algorithm: => Formulation. Unique Paths = the way to choose k numbers from N numbers, which is n!/((n - k)!*k!) = (n - k + i)!/k!.
 * Time complexity: O(n) Space complexity: O(1)
 */

class Solution {
    public int uniquePaths(int m, int n) {
        long res = 1;
        int k = m - 1;
        int N = m + n - 2;        
        
        for (int i = 1; i <= k; i++) {
            res = res * (N - k + i) / i;
        }
        return (int)res;
    }
}
