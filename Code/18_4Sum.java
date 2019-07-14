/*
 * 18. 4Sum
 * Target: Given an array nums of n integers and an integer target, are there elements a, b, c, 
 *         and d in nums such that a + b + c + d = target?
 * Difficulty：Medium
 * Classification：Array, Hash Table, Two Pointers
 */

/*
 * Solution 1
 * 2019-07-14  Runtime: 19 ms
 * Algorithm: => Two Pointers. Firstly sort the array, then go through the array and update res.
 * Time Complexity: O(n^3), Space Conplexity: O(n)
 */

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int l = j + 1, r = nums.length - 1;
                        while (l < r) {
                            if (nums[i] + nums[j] + nums[l] + nums[r] == target) {
                                res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                                while (l < r && nums[l] == nums[l + 1]) l++;
                                while (l < r && nums[r] == nums[r - 1]) r--;
                                l++;
                                r--;
                            } else if (nums[i] + nums[j] + nums[l] + nums[r] < target) {
                                l++;
                            } else {
                                r--;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
