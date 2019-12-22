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

class UnionFind {
    int pre[];
    int num;
    
    public UnionFind(int row, int col, char[][] grid) {
        num = 0;
        // calculate grid[i][j] == '1' number
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    num++;
                }
            }
        }
        
        // set pre[]
        int total = row * col;
        pre = new int[total];
        // firstly each node's parent is itself
        for (int i = 0; i < total; i++) {
            pre[i] = i;
        }
    }
    
    int find(int node) {
        // while current not root, go upstairs to find root
        while (pre[node] != node) {
            pre[node] = pre[pre[node]];
            node = pre[node];
        }
        return node;
    }
    
    void union(int node1, int node2) {
        // find two groups' roots
        int root1 = find(node1);
        int root2 = find(node2);
        // if groups' roots not equal, union them
        if (root1 != root2) {
            pre[root2] = root1;
            num--;
        }
    }
    
    int getNum() {
        return num;
    }
}

class Solution {
    int row;
    int col;
    
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        row = grid.length;
        col = grid[0].length;
        UnionFind uf = new UnionFind(row, col, grid);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    // refresh right and bottom num
                    if (i != (row - 1) && grid[i + 1][j] == '1') {
                        uf.union(node(i, j), node(i + 1, j));
                    }
                    if (j != (col - 1) && grid[i][j + 1] == '1') {
                        uf.union(node(i, j), node(i, j + 1));
                    }
                }
            }
        }
        return uf.getNum();
    }
    
    int node(int i, int j) {
        return i * col + j;
    }
}

