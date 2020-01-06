////////// sol 1

// Time: O(m*n); Space: O(1)
class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[] neighbors = {-1, 0, 1};
        
        for (int m = 0; m < rows; m++) {
            for (int n = 0; n < cols; n++) {
                int liveCount = 0;
                // count live neighbors
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            // r, c is the neighbors' row/col
                            int r = m + neighbors[i];
                            int c = n + neighbors[j];
                            if (r < rows && r >= 0 && c < cols && c >= 0) {
                                // should check -1 becuse live -> dead set -1
                                if (Math.abs(board[r][c]) == 1) {
                                    liveCount++;
                                }
                            }
                        }
                    }
                }
                
                // set change node to new value(don't change nodes after curr)
                // rule 1 and rule 3: set -1 to live -> dead
                if (board[m][n] == 1 && (liveCount < 2 || liveCount > 3)) {
                    board[m][n] = -1;
                }
                // rule 2: no change
                
                // rule 4: set 2 to dead -> live
                if (board[m][n] == 0 && liveCount == 3) {
                    board[m][n] = 2;
                } 
            }
        }
        
        // set 2 to 1, -1 to 0;
        for (int m = 0; m < rows; m++) {
            for (int n = 0; n < cols; n++) {
                if (board[m][n] > 0) {
                    board[m][n] = 1;
                } else {
                    board[m][n] = 0;
                }
            }
        }
    }
}
