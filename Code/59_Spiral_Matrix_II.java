/*
 * 59. Spiral Matrix II
 * Target: Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * Difficulty：Medium
 * Classification：Array
 */

/*
 * Solution 1
 * 2019-10-21  Runtime: 0 ms
 * Algorithm: => Snake
 * Time Complexity: O(n^2), Space Conplexity: O(1)
 */
 
class Solution {
    public int[][] generateMatrix(int n) {
        if (n == 0) return null;
        int res[][] = new int[n][n];
        int direction = 1;
        int topLine = -1, bottomLine = n, leftLine = -1, rightLine = n;
        int row = 0, col = 0, num = 1;
        while (true) {
            if (num == n * n + 1) {
                return res;
            }
            res[row][col] = num;
            num++;
            switch (direction) {
                case 1:
                    if (col + 1 == rightLine) {
                        direction = 2;
                        topLine++;
                        row++;
                    } else {
                        col++;
                    }
                    break;
                case 2:
                    if (row + 1 == bottomLine) {
                        direction = 3;
                        rightLine--;
                        col--;
                    } else {
                        row++;
                    }
                    break;
                case 3:
                    if (col - 1 == leftLine) {
                        direction = 4;
                        bottomLine--;
                        row--;
                    } else {
                        col--;
                    }
                    break;
                case 4:
                    if (row - 1 == topLine) {
                        direction = 1;
                        leftLine++;
                        col++;
                    } else {
                        row--;
                    }
                    break;    
            }
        }  
    }
}
