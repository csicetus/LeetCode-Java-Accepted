////////// sol 1: backtrack

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(candidates, target, res, new ArrayList<Integer>(), 0);
        return res;
    }
    
    private void backtrack(int[] nums, int target, List<List<Integer>> res, List<Integer> tempList, int first) {
        if (target < 0) return;
        else if (target == 0) {
            res.add(new ArrayList<Integer>(tempList));
        } else {
            for (int i = first; i < nums.length; i++) {
                // skip duplicate numbers
                if (i > first && nums[i] == nums[i - 1]) {
                    continue;
                }
                tempList.add(nums[i]);
                backtrack(nums, target - nums[i], res, tempList, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
