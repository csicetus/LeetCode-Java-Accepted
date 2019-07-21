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


/*
 * Solution 2
 * 2019-07-20  Runtime: 3 ms
 * Algorithm: => Backtracking. HashSet stores used number of the position to prevent duplicate combinations.
 */

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        update(res, 0, nums);
        return res;
    }
    
    private void update(List<List<Integer>> res, int start, int[] nums) {
        if (start == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }            
            res.add(new ArrayList<>(temp));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            swap(nums, i, start);
            update(res, start + 1, nums);
            swap(nums, i, start);
        }
        
    }
    
    private void swap(int[] nums, int i, int start) {
        int tmp = nums[start];
        nums[start] = nums[i];
        nums[i] = tmp;
    }
}



