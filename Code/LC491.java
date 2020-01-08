///////////////// sol 1

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 0 || nums == null) return res;
        helper(nums, res, new LinkedList<Integer>(), 0);
        return res;
    }
    
    private void helper(int[] nums, List<List<Integer>> res, LinkedList<Integer> tempList, int start) {
        if (tempList.size()> 1) {
            res.add(new ArrayList<>(tempList));
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            if (tempList.size() == 0 || nums[i] >= tempList.peekLast()) {
                set.add(nums[i]);
                tempList.add(nums[i]);
                helper(nums, res, tempList, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
