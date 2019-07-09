/*
 * 14. Longest Common Prefix
 * Target: Write a function to find the longest common prefix string amongst an array of strings.
 * Difficulty：Easy
 * Classification：String
 */

/*
 * Solution 1
 * 2019-07-09  Runtime: 1 ms
 * Algorithm: => Vertical comparison.
 * Time complexity: O(S), where S is the sum of all characters in all strings. Space complexity: O(1).
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}


/*
 * Solution 2
 * 2019-07-09  Runtime: 0 ms
 * Algorithm: => Level comparison.
 * Time complexity: O(S), where S is the sum of all characters in all strings. Space complexity: O(1).
 */
 
 class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
