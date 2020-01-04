// Time complexity is O(N^target) where N is a length of candidates array.
// Space complexity is O(target).

// This is worst case and without any optimization, like moving position forward and sorting to stop early.
// Just assuming that each recursive step we go over all existing candidates, so base N.
// And go as deep as target in our recursive calls (if candidates are close to 1), so power of target.
// This is the worst case and optimizations can make time complexity a little better

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(0, new ArrayList<Integer>(), res, candidates, target);
        return res;
    }
    
    private void backtrack(int first, ArrayList<Integer> tempList, List<List<Integer>> res, int[] candidates, int target) {
        if (target < 0) return;
        // target == 0 so we can add temp to result
        else if (target == 0) {
            res.add(new ArrayList<Integer>(tempList));
        } else {       
            for (int i = first; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                // not i + 1 because the number can be reused
                backtrack(i, tempList, res, candidates, target - candidates[i]);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
