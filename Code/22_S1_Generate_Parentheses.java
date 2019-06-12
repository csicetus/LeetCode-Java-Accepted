    
/*
 * 22. Generate Parentheses solution 1
 * 2019-06-12  Runtime: 1 ms
 * Target: Given n pairs of parentheses, generate all combinations of well-formed parentheses.
 * Difficulty：Medium
 * Classification：String, Backtracking
 * Algorithm: => Violent cracking.
 * Time complexity: O(2 ^ (2n) * n), Space complexity: O(2 ^ (2n) * n)
 */
 
 class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        combinePare(new char[2 * n], 0, res);
        return res;
    }
    
    public void combinePare(char[] cur, int pos, List<String> res){
        if (pos == cur.length){
            if (isValid(cur)){
                res.add(new String(cur));
            }
        }
        else {
            cur[pos] = '(';
            combinePare(cur, pos + 1, res);
            cur[pos] = ')';
            combinePare(cur, pos + 1, res);
        }
    }
    
    public boolean isValid(char[] st){
        int count = 0;
        for (char c : st){
            if (c == '('){
                count ++;
            }
            else if (c == ')'){
                count --;
            }
            if (count < 0){
                return false;
            }
        }
        return count == 0;
    }
}
