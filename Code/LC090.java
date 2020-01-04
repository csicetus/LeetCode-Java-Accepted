// Time: O(n*2^n?); Space: O(2^n?)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 || nums == null) {
            return res;
        }
        Arrays.sort(nums);
        backtrack(0, new ArrayList<Integer>(), nums, res);
        return res;
    }
    
    private void backtrack(int first, List<Integer> tempList, int[] nums, List<List<Integer>> res) {
        res.add(new ArrayList<Integer>(tempList));
        for (int i = first; i < nums.length; i++) {
            // skip duplicate numbers
            if (i > first && nums[i] == nums[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            backtrack(i + 1, tempList, nums, res);
            tempList.remove(tempList.size() - 1);
        }
    }
}
