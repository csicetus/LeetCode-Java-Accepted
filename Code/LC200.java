//////////sol 1

// Time: O(n^2)?; Space: O(1)
class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    changeNum(i, j, grid);
                }
            }
        }
        return count;
    }
    
    private void changeNum(int i, int j, char[][] grid) {
        if (i == -1 || j == -1 || i == grid.length || j == grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        
        changeNum(i + 1, j, grid);
        changeNum(i - 1, j, grid);
        changeNum(i, j + 1, grid);
        changeNum(i, j - 1, grid);
    }
}

//////////sol 2

