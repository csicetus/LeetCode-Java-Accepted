    
/*
 * 22. Generate Parentheses
 * Target: Given n pairs of parentheses, generate all combinations of well-formed parentheses.
 * Difficulty：Medium
 * Classification：String, Backtracking
 */
 
/*
 * Solution 1
 * 2019-06-12  Runtime: 1 ms
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


/*
 * Solution 2
 * 2019-06-12  Runtime: 1 ms
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


/*
 * Solution 3
 * 2019-06-13  Runtime: 3 ms
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
