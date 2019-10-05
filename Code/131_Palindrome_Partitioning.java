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
 * Algorithm: => Backtracking
 * Time Complexity: ?, Space Conplexity: O(1)
 */
 
 class Solution {
    public List<List<String>> partition(String s) {
         return partitionRecursion(s, 0);
    }
    
    private List<List<String>> partitionRecursion(String s, int start) {
        if (start == s.length()) {
            List<String> list = new ArrayList<>();
            List<List<String>> res = new ArrayList<>();
            res.add(list);
            return res;
        }
        List<List<String>> res = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            if (isPartition(s.substring(start, i + 1))) {
                String leftPart = s.substring(start, i + 1);
                for (List<String> list : partitionRecursion(s, i + 1)) {
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
