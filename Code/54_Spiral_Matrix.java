/*
 * 54. Spiral Matrix
 * Target: Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
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
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int m = matrix.length;
        int n = matrix[0].length;       
        int row = 0;
        int col = 0;
        int direction = 0;
        int topBound = -1;
        int bottomBound = m;
        int leftBound = -1;
        int rightBound = n;
        while (true) {
            if (res.size() == m * n) {
                return res;
            }
            res.add(matrix[row][col]);
            switch (direction) {
                case 0:
                    if (col + 1 == rightBound) {
                        direction = 1;
                        topBound++;
                        row++;
                    } else {
                        col++;
                    }
                    break;
                case 1:
                    if (row + 1 == bottomBound) {
                        direction = 2;
                        rightBound--;
                        col--;
                        
                    } else {
                        row++;
                    }
                    break;
                case 2:
                    if (col - 1 == leftBound) {
                        direction = 3;
                        bottomBound--;
                        row--;
                    } else {
                        col--;
                    }
                    break;
                case 3:
                    if (row - 1 == topBound) {
                        direction = 0;
                        leftBound++;
                        col++;
                    } else {
                        row--;
                    }
                    break;
            }
        }
    }
}
