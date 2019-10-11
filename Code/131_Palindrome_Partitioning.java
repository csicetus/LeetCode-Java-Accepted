/*
 * 131. Palindrome Partitioning
 * Target: Given a string s, partition s such that every substring of the partition is a palindrome.
 *         Return all possible palindrome partitioning of s.
 * Difficulty：Medium
 * Classification：Backtracking
 */

/*
 * Solution 1
 * 2019-10-04  Runtime: 6 ms
 * Algorithm: => Divide problem. aabb -> a|abb, find groups of "abb" and for every group add "a" at the index 0.
 * Time Complexity: ?, Space Conplexity: O(1)
 */
 
 class Solution {
    public List<List<String>> partition(String s) {
         return partitionRecursion(s, 0);
    }
    
    private List<List<String>> partitionRecursion(String s, int start) {
        // empty list
        if (start == s.length()) {
            List<String> list = new ArrayList<>();
            List<List<String>> res = new ArrayList<>();
            res.add(list);
            return res;
        }
        List<List<String>> res = new ArrayList<>();
        // left part with length from 0 to s.length()
        for (int i = start; i < s.length(); i++) {
            if (isPartition(s.substring(start, i + 1))) {
                String leftPart = s.substring(start, i + 1);
                for (List<String> list : partitionRecursion(s, i + 1)) {
                    // add left part to index 0, the beginning of rest palindrome part
                    list.add(0, leftPart);
                    res.add(list);
                }
            }
        }
        return res;
    }
    
    private boolean isPartition(String s) {
        if (s.length() == 0) return true;
        int l = 0, r = s.length() - 1;
        char ch[] = s.toCharArray();
        while (l < r) {
            if (ch[l] != ch[r]) {
                return false;
            } 
            l++;
            r--;
        }
        return true;
    }
}


/*
 * Solution 2
 * 2019-10-10  Runtime: 3 ms
 * Algorithm: => Optimal of sol 2. Divide problem and dp. Divide problem, use dp rather than isPartition() function
 * Time Complexity: ?, Space Conplexity: O(1)
 */
 
class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                // In dp[i + 1][j - 1], i + 1 <= j - 1, and j = i + len - 1. So len >= 3.
                // When len = 1 or 2, we just need to check s.charAt(i) == s.charAt(j)
                dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
            }
        }
        return partitionRecursion(s, 0, dp);
    }
    
    private List<List<String>> partitionRecursion(String s, int start, boolean[][] dp) {
        if (start == s.length()) {
            List<String> list = new ArrayList<>();
            List<List<String>> res = new ArrayList<>();
            res.add(list);
            return res;
        }
        List<List<String>> res = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                String leftPart = s.substring(start, i + 1);
                for (List<String> list : partitionRecursion(s, i + 1, dp)) {
                    list.add(0, leftPart);
                    res.add(list);
                }
            }
        }
        return res;
    }
}


/*
 * Solution 3
 * 2019-10-10  Runtime: 2 ms
 * Algorithm: => Backtracking and dp. Same as DFS.
 * Time Complexity: ?, Space Conplexity: O(1)
 */

class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
            }
        }
        List<String> list = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        return partitionRecursion(s, 0, dp, list, res);
    }
    
    private List<List<String>> partitionRecursion(String s, int start, boolean[][] dp, List<String> list, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
        }
        
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                String leftPart = s.substring(start, i + 1);
                list.add(leftPart);
                partitionRecursion(s, i + 1, dp, list, res);
                list.remove(list.size() - 1);
            }
        }
        return res;
    }
}
