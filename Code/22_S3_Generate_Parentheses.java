/*
 * 22. Generate Parentheses solution 3
 * 2019-06-13  Runtime: 3 ms
 * Target: Given n pairs of parentheses, generate all combinations of well-formed parentheses.
 * Difficulty：Medium
 * Classification：String, Backtracking
 * Algorithm: => Recursion. The length of res is 2 * n.
 * Note: res[0] => "(", res[1 : c - 1] => group a legal sequence, res[c] => ")", res[c + 1 : 2 * n - 1]: group b legal sequence
 */
 
 class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        if (n == 0){
            res.add("");
        }
        else {
            for (int i = 0; i < n ; i++){
                for (String l : generateParenthesis(i)){
                    for (String r : generateParenthesis(n - 1 - i)){
                        res.add("(" + l + ")" + r);
                    }
                }
            }
        }
        Collections.reverse(res);
        Collections.reverse(res);
        return res;
    }
}
