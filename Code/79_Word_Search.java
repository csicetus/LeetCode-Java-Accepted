/*
 * 79. Word Search
 * Target: Given a 2D board and a word, find if the word exists in the grid.
 * Difficulty：Medium
 * Classification：Array, Backtracking
 * Best solution: solution 2
 */

/*
 * Solution 1
 * 2019-06-28  Runtime: 4 ms
 * Algorithm: => DFS
 */
 
 class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        if (rows == 0) return false;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (searchWord(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean searchWord(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1)  return true;
        
        visited[row][col] = true;
        
        boolean up = searchWord(board, word, index + 1, row - 1, col, visited);
        boolean down = searchWord(board, word, index + 1, row + 1, col, visited);
        boolean left = searchWord(board, word, index + 1, row, col - 1, visited);
        boolean right = searchWord(board, word, index + 1, row, col + 1, visited);
        
        if (up || down || left || right) return true;
        
        visited[row][col] = false;
        return false;
    }
}


/*
 * Solution 2
 * 2019-06-28  Runtime: 4 ms
 * Algorithm: => DFS (optimal of solution 1, less Space complexity)
 */
 
 class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        if (rows == 0) return false;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean searchWord(char[][] board, String word, int index, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (board[row][col] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1)  return true;
        
        char temp = board[row][col];
        board[row][col] = '#';
        
        boolean up = searchWord(board, word, index + 1, row - 1, col);
        boolean down = searchWord(board, word, index + 1, row + 1, col);
        boolean left = searchWord(board, word, index + 1, row, col - 1);
        boolean right = searchWord(board, word, index + 1, row, col + 1);
        
        if (up || down || left || right) return true;
        
        board[row][col] = temp;
        return false;
    }
}
