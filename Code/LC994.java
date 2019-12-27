////////// sol 1: refresh orange by day

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) return -1;
        int fresh = 0, day = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        for (int oldFresh = fresh; fresh > 0; day++, oldFresh = fresh) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == day + 2) {
                        fresh -= changeOranges(i - 1, j, grid, day) + changeOranges(i + 1, j, grid, day)
                            + changeOranges(i, j - 1, grid, day) + changeOranges(i, j + 1, grid, day);
                    }
                }
            }
            if (fresh == oldFresh) return -1;
        }
        return day;
    }
    
    private int changeOranges(int i, int j, int[][] grid, int d) {
        if (i == -1 || j == -1 || i == grid.length || j == grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = d + 3;
        return 1;
    }
}

////////// sol 2: BFS

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) return -1;
        int fresh = 0, day = 0;
        Queue<int[]> q = new LinkedList<>();
        int dict[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        if (fresh == 0) return 0;
        
        while (!q.isEmpty()) {
            day++;
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int points[] = q.poll();
                for (int d[] : dict) {
                    int i = points[0] + d[1];
                    int j = points[1] + d[0];
                    if (i == -1 || j == -1 || i == grid.length || j == grid[0].length || grid[i][j] != 1) {
                        continue;
                    }
                    grid[i][j] = 2;
                    q.offer(new int[]{i, j});
                    fresh--;
                }
            }   
        }
        return fresh == 0 ? day - 1 : -1;
    }
}

