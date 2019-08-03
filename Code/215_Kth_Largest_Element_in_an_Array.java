/*
 * 215. Kth Largest Element in an Array
 * Target: Find the kth largest element in an unsorted array.
 *         Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *         You may assume k is always valid, 1 ≤ k ≤ array's length.
 * Difficulty：Medium
 * Classification：Divide and Conquer, Heap
 * Note: Two important things we should mention during the interview.
 *       1. If the array -> nums is very small. Use sol 1 directly.
 *       2. If k > nums.length, return -1 directly.
 */

/*
 * Solution 1
 * 2019-08-03  Runtime: 3 ms
 * Algorithm: => Sort the array. 
 * Time Complexity: O(n*logn). Space Conplexity: O(1). 
 */
 
 class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n - k];
    }
}


/*
 * Solution 2
 * 2019-08-03  Runtime: 6 ms
 * Algorithm: => PriorityQueue. 
 * Time Complexity: O(n*logk). Space Conplexity: O(k). 
 */
 
 class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}


/*
 * Solution 3
 * 2019-08-03  Runtime: 7 ms
 * Algorithm: => Quicksort. 
 * Time Complexity: best: O(n); worst: O(n^2). Space Conplexity: O(1). 
 */
 
 
 
