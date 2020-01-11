/////////// sol: BFS

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid == null || n == 0 || grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        int[][] dir = new int[][]{{0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}, 
                                  {1, -1, 0}, {1, 1, 0}, {-1, 1, 0}, {-1, -1, 0}};
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{0, 0, 1});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == n - 1 && curr[1] == n - 1) {
                return curr[2];
            }
            for (int i = 0; i < dir.length; i++) {
                int x = dir[i][0] + curr[0];
                int y = dir[i][1] + curr[1];
                if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] != 1) {
                    grid[x][y] = 1;
                    q.offer(new int[]{x, y, curr[2] + 1});
                }
            }
        }
        return -1;
    }
}
