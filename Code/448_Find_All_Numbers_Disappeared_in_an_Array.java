/*
 * 448. Find All Numbers Disappeared in an Array
 * Target: Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *         Find all the elements of [1, n] inclusive that do not appear in this array.
 *         Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * Difficulty：Easy
 * Classification：Divide and Conquer, Heap
 */

/*
 * Solution 1
 * 2019-08-04  Runtime: 7 ms
 * Algorithm: => Iterate through the input array and mark elements as negative using nums[nums[i] - 1] = -nums[nums[i] - 1]. 
 *               In the second iteration, if a value is not marked as negative, 
 *               it implies we have never seen that index before, so just add it to the return list.
 * Time Complexity: O(n). Space Conplexity: O(1). 
 */

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        for (int num : nums) {
            int val = Math.abs(num) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
