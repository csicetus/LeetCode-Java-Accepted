/*
 * 88. Merge Sorted Array
 * Target: Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *         The number of elements initialized in nums1 and nums2 are m and n respectively.
*          You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Difficulty：Easy
 * Classification：Array, Two pointers
 */

/*
 * Solution 1
 * 2019-07-18  Runtime: 0 ms
 * Algorithm: => Three pointers, all of them have the same direction(From start to end). Regard nums1 as the final array. 
 *               First remove all the numbers of nums1 to the end of nums1. Then select min numbers from nums1 and nums2.
 *               If all numbers of one array have selected, add all numbers from the other array next to last number added.
 * Time Complexity: O(n), Space Conplexity: O(1)
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = n, j = 0, k = 0;
        for (int p = 0; p < m; p++) {
            nums1[m + n - p - 1] = nums1[m - p - 1];
        }
        while (j < n) {
            if (i == m + n) {
                while (j < n) {
                    nums1[k++] = nums2[j++];
                }
                return;
            }
            if (nums1[i] < nums2[j]) {
                nums1[k] = nums1[i++];
            } else {
                nums1[k] = nums2[j++];
            }
            k++;
        }
    }
}


/*
 * Solution 2
 * 2019-07-18  Runtime: 0 ms
 * Algorithm: => Optimal of solution 1(without removing numbers of nums1).Two points with same direction(From end to start).
 * Time Complexity: O(n), Space Conplexity: O(1)
 */
 
 class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (j >= 0) {
            if (i < 0) {
                while (j >= 0) {
                    nums1[k--] = nums2[j--];
                }
                return;
            }
            if (nums1[i] < nums2[j]) {
                nums1[k] = nums2[j--];
            } else {
                nums1[k] = nums1[i--];
            }
            k--;
        }
    }
}
