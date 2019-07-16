/*
 * 240. Search a 2D Matrix II
 * Target: Write an efficient algorithm that searches for a value in an m x n matrix.
 *         Integers in each row are sorted in ascending from left to right.
*          Integers in each column are sorted in ascending from top to bottom.
 * Difficulty：Medium
 * Classification：Binary Search, Divide and Conquer
 */

/*
 * Solution 1
 * 2019-07-16  Runtime: 5 ms
 * Algorithm: => Two points with reverse direction
 * Time Complexity: O(m + n), Space Conplexity: O(1)
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
