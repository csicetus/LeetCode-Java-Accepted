/*
 * 496. Next Greater Element I
 * Target: You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. 
 *         Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 *         The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
 *         If it does not exist, output -1 for this number.
 * Difficulty：Medium
 * Classification：Stack
 */
 
 /*
 * Solution 1
 * 2019-08-02  Runtime: 3 ms
 * Algorithm: => Stack. Stack stores pre numbers and compare the top number with current T[i]. Map stores the increase sequence(key < value).
 * Time Complexity: O(n). Space Conplexity: O(n). 
 */
 
 class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
