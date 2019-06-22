/*
 * 39. Combination Sum
 * Target: Find the starting and ending position of a given target value..
 * Difficulty：Medium
 * Classification：Array, Backtracking
 */
 
 /*
 * Solution 1
 * 2019-06-19  Runtime: 5 ms
 * Algorithm: => Backtracking.
 */
 
 class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) {
            list.add(new ArrayList<>(tempList));
        }
        else{ 
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); 
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}


/*
 * Solution 2
 * 2019-06-22  Runtime: 8 ms
 * Algorithm: => DP.
 */

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> res = new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates[0] > target) {
            return new ArrayList<List<Integer>>();
        }
        
        for (int i = 0; i <= target; i++) {
            List<List<Integer>> res_i = new ArrayList<>();
            res.add(i, res_i);
        }
        
        for (int j = 0; j < candidates.length; j++) {
            for (int sum = candidates[j]; sum <= target; sum++) {
                List<List<Integer>> res_sum = res.get(sum);
                List<List<Integer>> res_sub = res.get(sum - candidates[j]);
                
                if (candidates[j] == sum) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(candidates[j]);
                    res_sum.add(temp);
                }
                
                if (res_sub.size() > 0) {
                     for (int k = 0; k < res_sub.size(); k++) {
                         List<Integer> temp = new ArrayList<>(res_sub.get(k));
                         temp.add(candidates[j]);
                         res_sum.add(temp);
                     }
                }
            }
        }
        
        return res.get(target);
    }
}
