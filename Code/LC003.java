///////////// sol 1

// Time: O(n); Space: O(m), m is the length of str[]
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int str[] = new int[128];
        int res = 0, i = 0, j = 0;
        for (; j < len; j++) {
            i = Math.max(str[s.charAt(j)], i); 
            // the position of i should set
            str[s.charAt(j)] = j + 1;
            res = Math.max(res, j + 1 - i);
        }
        return res;
    }
}
