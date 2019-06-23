/*
 * 48. Rotate Image
 * Target: Rotate the image(n x n 2D matrix) by 90 degrees (clockwise)..
 * Difficulty：Medium
 * Classification：Array
 */
 
 /*
 * Solution 1
 * 2019-06-22  Runtime: 0 ms
 * Algorithm: => First diagonal, then vertical axis.
 * Time complexity: O(n^2). Space complexity: O(1).
 */
 
 class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for (int i = 0, j = matrix.length - 1; i < matrix.length / 2; i++, j--) {
            for (int k = 0; k < matrix.length; k++) {
                int temp = matrix[k][i];
                matrix[k][i] = matrix[k][j];
                matrix[k][j] = temp;
            }
        }
    }
}


/*
 * Solution 2
 * 2019-06-23  Runtime: 322 ms
 * Algorithm: => Compare one by one.
 * Time complexity: O(k*n). Space complexity: O(1).
 */
