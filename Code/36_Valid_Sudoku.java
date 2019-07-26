/*
 * 36. Valid Sudoku
 * Target: Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated.
 *         The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *         A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Difficulty：Medium
 * Classification：Hash Table
 */

/*
 * Solution 1
 * 2019-07-26  Runtime: 3 ms
 * Algorithm: => Brutal
 * Time Complexity: O(N), N is the size of Sudoku. Space Conplexity: O(1)
 */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!isValidRow(board[i])) {
                return false;
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            if (!isValidCol(board, j)) {
                return false;
            }
        }
        for (int i = 0; i < board.length; i = i + 3) {
            for (int j = 0; j < board[0].length; j = j + 3) {
                if (!isValidCell(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValidRow(char[] board) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : board) {
            if (c != '.') {
                if (map.containsKey(c) && map.get(c) != 0) {
                    return false;
                } else {
                    map.put(c, 1);
                }
            }
        }
        return true;
    }
    
    private boolean isValidCol(char[][] board, int col) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int k = 0; k < board.length; k++) {
            char c = board[k][col];
            if (c != '.') {
                if (map.containsKey(c) && map.get(c) != 0) {
                    return false;
                } else {
                    map.put(c, 1);
                }
            }
        }
        return true;
    }
    
    private boolean isValidCell(char[][] board, int row, int col) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                char c = board[row + m][col + n];
                if (c != '.') {
                    if (map.containsKey(c) && map.get(c) != 0) {
                        return false;
                    } else {
                        map.put(c, 1);
                    }
                }
            }
        }
        return true;   
    }
}


/*
 * Solution 2
 * 2019-07-26  Runtime: 4 ms
 * Algorithm: => Use HashSet store three situations at one loop
 * Time Complexity: O(N), N is the size of Sudoku. Space Conplexity: O(N)
 */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set valid = new HashSet();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (!valid.add(c + "row" + i) ||
                        !valid.add(c + "col" + j) ||
                        !valid.add(c + "cell" + i/3 + "&" + j/3) )
                        return false;
                }
            }
        }
        return true;
    }
}
