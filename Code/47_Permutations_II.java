/*
 * 47. Permutations II
 * Target: Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * Difficulty：Medium
 * Classification：Backtracking
 * Diff between lc39, lc46, lc78
 */
 
/*
 * Solution 1
 * 2019-07-19  Runtime: 3 ms
 * Algorithm: => Backtracking.
 */
 
 class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> pre = new ArrayList<>();
        backtracking(res, new ArrayList<>(), nums, pre);
        return res;
    }
    
    private void backtracking(List<List<Integer>> res, List<Integer> tmpList, int[] nums, List<Integer> pre) {
        if (tmpList.size() == nums.length) {
            res.add(new ArrayList<>(tmpList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (pre.contains(i)) continue;
                if (i > 0 && !pre.contains(i - 1) && nums[i] == nums[i - 1]) continue;
                pre.add(i);
                tmpList.add(nums[i]);
                backtracking(res, tmpList, nums, pre);
                pre.remove(pre.size() - 1);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
}
