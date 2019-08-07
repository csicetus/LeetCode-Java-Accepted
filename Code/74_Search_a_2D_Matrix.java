/*
 * 74. Search a 2D Matrix
 * Target: Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *         Integers in each row are sorted from left to right.
 *         The first integer of each row is greater than the last integer of the previous row.
 * Difficulty：Easy
 * Classification：Array, Binary Search
 */

/*
 * Solution 1
 * 2019-08-06  Runtime: 0 ms
 * Algorithm: => Binary Search.
 * Time Complexity: O(n). Space Conplexity: O(1). 
 */
 

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[mid / n][mid % n] == target) {
                return true;
            } else if (matrix[mid / n][mid % n] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}


/*
 * Solution 2
 * 2019-08-06  Runtime: 0 ms
 * Algorithm: => Binary Search.
 * Time Complexity: O(n). Space Conplexity: O(1). 
 */
 
 class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
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
