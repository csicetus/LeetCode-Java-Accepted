////////// sol 1

// Time: O(m*n); Space: O(1)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Boolean fr = false, fc = false;
        
        // set first row and first col as flags
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        // based on flag, set each node
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // if first row has 0, set all nodes of first row to 0
        if (fr) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        
        // if first col has 0, set all nodes of first col to 0
        if (fc) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }  
    }
}
