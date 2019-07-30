/*
 * 139. Word Break
 * Target: Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
 *         determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *         The same word in the dictionary may be reused multiple times in the segmentation.
 *         You may assume the dictionary does not contain duplicate words.
 * Difficulty：Medium
 * Classification：DP
 */

/*
 * Solution 1
 * 2019-07-30  Runtime: 2 ms
 * Algorithm: => DP.
 * Time Complexity: ?. Space Conplexity: O(1)
 */
 
 class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (i >= word.length() 
                && dp[i - word.length()] 
                && word.equals(s.substring(i - word.length(), i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}


/*
 * Solution 2
 * 2019-07-30  Runtime: 5 ms
 * Algorithm: => DP. Another version of sol 1.
 * Time Complexity: ?. Space Conplexity: O(1)
 */
 
 class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict.size() == 0) return false;
        int n = s.length();
        boolean[] dp = new boolean[n]; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);
                if ((j == 0 || dp[j - 1]) && wordDict.contains(sub)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}


/*
 * Solution 3
 * 2019-07-30  Runtime: 7 ms
 * Algorithm: => BFS.
 * Time Complexity: O(n^2). Space Conplexity: O(1)
 */
 
 class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict.size() == 0) return false;
        if (wordDict.contains(s)) return true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        while (!q.isEmpty()) {
            int index = q.poll();
            for (int i = index + 1; i <= s.length(); i++) {
                if (visited.contains(i)) continue;
                if (wordDict.contains(s.substring(index ,i))) {
                    if (i == s.length()) return true;
                    q.offer(i);
                    visited.add(i);
                }
            }
        }
        return false;
    }
}
