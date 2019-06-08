/*
 * 15. 3Sum
 * 2019-06-08  Runtime: 32 ms
 * Target: Find all unique triplets in the array which gives the sum of zero.
 * Difficulty：Medium
 * Classification：Array, Two Pointers
 * Algorithm: => Inner loop: Set two points l, r as the beginning and end of array. And nums[l] + nums[r] == 0 -  nums[i].
 * Note: How to avoid list repeating elements, eg. [-1, 0, 1] is the same as [-1, 1, 0].
 * Time Conplexity: O(n^2)
 */
 
 class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++){
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r){
                    if (nums[l] + nums[r] == sum){
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    }
                    else if (nums[l] + nums[r] < sum){
                        l++;
                    }
                    else {
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
