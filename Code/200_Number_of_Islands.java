/*
 * 200. Number of Islands
 * Target: Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 *         An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 *         You may assume all four edges of the grid are all surrounded by water.
 * Difficulty：Medium
 * Classification：DFS, BFS, Union Find
 */

/*
 * Solution 1
 * 2019-07-30  Runtime: 1 ms
 * Algorithm: => DFS.
 * Time Complexity: O(N*M). Space Conplexity: O(1)
 */
 
 class Solution {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    helperDFS(grid, i, j);
                    cnt++;
                }

            }
        }
        return cnt;
    }
    
    private void helperDFS(char[][] grid, int i, int j) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            helperDFS(grid, i + 1, j);
             helperDFS(grid, i - 1, j);
            helperDFS(grid, i, j + 1);          
            helperDFS(grid, i, j - 1);
        }
    }
}


/*
 * Solution 2
 * 2019-07-30  Runtime: 3 ms
 * Algorithm: => BFS.
 * Time Complexity: O(N*M). Space Conplexity: O(N*M)
 */
 
 class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int cnt = 0, m = grid.length, n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    q.offer(new int[]{i, j});
                    isVisited[i][j] = true;
                    helperBFS(grid, isVisited, q);
                    cnt++;
                }

            }
        }
        return cnt;
    }
    
    int[][] dict = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private void helperBFS(char[][] grid, boolean[][] isVisited, Queue<int[]> q) {
        int m = grid.length, n = grid[0].length;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dict) {
                int i = cur[0] + d[0];
                int j = cur[1] + d[1];
                if (i < 0 || i >= m || j < 0 || j >=n || isVisited[i][j] || grid[i][j] == '0') 
                    continue;
                isVisited[i][j] = true;
                q.offer(new int[]{i, j});
            }
        }      
    }
}


/*
 * Solution 3
 * 2019-07-30  Runtime: 3 ms
 * Algorithm: => Union Find.
 * Time Complexity: O(N*M). Space Conplexity: O(N*M)
 */
