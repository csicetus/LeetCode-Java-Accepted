/*
 * 22. Generate Parentheses solution 2
 * 2019-06-12  Runtime: 1 ms
 * Target: Given n pairs of parentheses, generate all combinations of well-formed parentheses.
 * Difficulty：Medium
 * Classification：String, Backtracking
 * Algorithm: => Backtracking.
 * Note: Two special cases, one is l >= n, the other is r >= l. In the situation, return false directly.
 */
 
 class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        backtrack(res, "", 0, 0, n);
        return res;
    }
    
    public void backtrack(List<String> res, String cur, int l, int r, int n){
        if (2 * n == cur.length()){
            res.add(cur);
            return;
        }
        if (l < n){
            backtrack(res, cur + "(", l + 1, r, n);
        }
        if (r < l){
            backtrack(res, cur + ")", l, r + 1, n);
        }
    }
}
