/*
 * 46. Permutations
 * Target: Given a collection of distinct integers, return all possible permutations.
 * Difficulty：Medium
 * Classification：Backtracking
 * Diff between lc39, lc78
 */
 
/*
 * Solution 1
 * 2019-06-22  Runtime: 1 ms
 * Algorithm: => Backtracking.
 */
 
 class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), nums);
        return res;
    }
    
    private void backtracking(List<List<Integer>> res, List<Integer> templist, int[] nums) {
        if (templist.size() == nums.length) {
            res.add(new ArrayList<>(templist));
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (templist.contains(nums[i])) continue;
            templist.add(nums[i]);
            backtracking(res, templist, nums);
            templist.remove(templist.size() - 1);
        }
    }
    
}

 
/*
 * Solution 2
 * 2019-06-22  Runtime: 1 ms
 * Algorithm: => Recursion, same as DP.
 * Time complexity: O(k*n). Space complexity: O(1).
 */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        upset(nums, 0, res);
        return res;
    }
    
    private void upset(int[] nums, int begin, List<List<Integer>> res) {
        if (begin == nums.length) {
            List<Integer> templist = new ArrayList<>();
            for (int i = 0; i < begin; i++) {
                templist.add(nums[i]);
            }
            res.add(new ArrayList<>(templist));
            return;
        }
        
        for (int i = begin; i < nums.length; i++) {
            swap(nums, i, begin);
            upset(nums, begin + 1, res);
            swap(nums, i, begin);
        }
    }
    
    private void swap(int[] nums, int i, int begin) {
        int temp = nums[i];
        nums[i] = nums[begin];
        nums[begin] = temp;
    }
    
}
