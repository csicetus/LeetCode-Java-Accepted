/*
 * 64. Minimum Path Sum
 * Target: Find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Difficulty：Medium
 * Classification：Array, DP
 * Best solution: solution 2.
 * Note: Same as LC_62.
 */

/*
 * Solution 1
 * 2019-06-27  Runtime: 15 ms
 * Algorithm: => Recursion and use HashMap.
 * Time complexity: ? Space complexity: ?
 */
 
  class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        HashMap<String, Integer> visited = new HashMap<>();
        return getPathSum(0, 0, m - 1, n - 1, grid, visited);
    }

    private int getPathSum(int x, int y, int m, int n, int[][] grid, HashMap<String, Integer> visited) {
        if (x == m && y == n) {
            return grid[m][n];
        }
        int n1 = Integer.MAX_VALUE;
        int n2 = Integer.MAX_VALUE;
        String key = x + 1 + "@" + y;
        if (!visited.containsKey(key)) {
            if (x + 1 <= m) {
                n1 = getPathSum(x + 1, y, m, n, grid, visited);
            }
        } else {
            n1 = visited.get(key);
        }
        key = x + "@" + (y + 1);
        if (!visited.containsKey(key)) {
            if (y + 1 <= n) {
                n2 = getPathSum(x, y + 1, m, n, grid, visited);
            }
        } else {
            n2 = visited.get(key);
        }
        key = x + "@" + y;
        visited.put(key, Math.min(n1, n2) + grid[x][y]);
        return Math.min(n1, n2) + grid[x][y];
    }
}

 
/*
 * Solution 2
 * 2019-06-27  Runtime: 2 ms
 * Algorithm: => Iteration. Same as DP.
 * Time complexity: O(m*n) Space complexity: O(1)
 */

class Solution {
    public int minPathSum(int[][] grid) {
        int len1 = grid.length;
        int len2 = grid[0].length;
        
        // update first column
        for (int i = 1; i < len1; i++) {
            grid[i][0] = grid[i][0] + grid[i - 1][0];
        }    
        
        // update first row
        for (int j = 1; j < len2; j++) {
            grid[0][j] = grid[0][j] + grid[0][j - 1]; 
        }
        
        
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                grid[i][j] = Math.min(grid[i][j] + grid[i][j - 1], grid[i][j] + grid[i - 1][j]);
            }
        }
        return grid[len1 - 1][len2 - 1];
    }
}
