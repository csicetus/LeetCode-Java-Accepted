/*
 * 40. Combination Sum II
 * Target: Find the starting and ending position of a given target value.
 *         Each number in candidates may only be used once in the combination.
 * Difficulty：Medium
 * Classification：Array, Backtracking
 */
 
 /*
 * Solution 1
 * 2019-07-19  Runtime: 6 ms
 * Algorithm: => Backtracking.
 */
 
 class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tmpList, int[] candidates, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) {
            list.add(new ArrayList<>(tmpList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) continue;
                tmpList.add(candidates[i]);
                backtrack(list, tmpList, candidates, remain - candidates[i], i + 1);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
}
