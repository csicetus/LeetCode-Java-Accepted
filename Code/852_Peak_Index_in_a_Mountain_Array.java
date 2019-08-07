/*
 * 852. Peak Index in a Mountain Array
 * Target: Given an array that is definitely a mountain, 
 *         return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 * Difficulty：Easy
 * Classification：Binary Search
 */

/*
 * Solution 1
 * 2019-08-06  Runtime: 0 ms
 * Algorithm: => Linear Scan.
 * Time Complexity: ?. Space Conplexity: O(1). 
 */
 
 class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int idx = 0;
        while (A[idx] < A[idx + 1]) idx++;
        return idx;
    }
}

 
/*
 * Solution 2
 * 2019-08-06  Runtime: 0 ms
 * Algorithm: => Binary Search. When there are two numbers left, mid == l, so return l.
 * Time Complexity: O(n). Space Conplexity: O(1). 
 */
 
 class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (A[mid] < A[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
