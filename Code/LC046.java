////////// sol 1: backtrack

// Time: O(n!); Space: O(n!)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 || nums == null) {
            return res;
        }
        // without sorting, backtrack directly
        backtrack(new ArrayList<Integer>(), nums, res);
        return res;
    }
    
    private void backtrack(List<Integer> tempList, int[] nums, List<List<Integer>> res) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<Integer>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtrack(tempList, nums, res);
                tempList.remove(tempList.size() - 1);
            }
        } 
    }
}
