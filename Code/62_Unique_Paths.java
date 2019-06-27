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
