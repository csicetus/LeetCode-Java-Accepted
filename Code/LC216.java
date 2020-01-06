// Time: O(n*2^n)?; Space: O(2^n)?
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k == 0 || n == 0) return res;
        backtrack(k, n, new ArrayList<Integer>(), res, 1);
        return res;
    }
    
    private void backtrack(int k, int n, List<Integer> tempList, List<List<Integer>> res, int start) {
        if (tempList.size() == k && n == 0) {
            res.add(new ArrayList<Integer>(tempList));
        }
        for (int i = start; i <= 9 && i <= n; i++) {
            tempList.add(i);
            backtrack(k, n - i, tempList, res, i + 1);
            // for (int t : tempList) {
            //     System.out.println(t);
            // }
            // System.out.println("------------");
            tempList.remove(tempList.size() - 1);
        }
    }
}
