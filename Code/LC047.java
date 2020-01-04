class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 || nums == null) {
            return res;
        }
        Arrays.sort(nums);
        backtrack(new ArrayList<Integer>(), nums, res, new boolean[nums.length]);
        return res;
    }
    
    private void backtrack(List<Integer> tempList, int[] nums, List<List<Integer>> res, boolean[] used) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<Integer>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(tempList, nums, res, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        } 
    }
}
