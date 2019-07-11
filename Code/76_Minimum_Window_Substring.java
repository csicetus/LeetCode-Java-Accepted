/*
 * 76. Minimum Window Substring
 * Target: Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * Difficulty：Hard
 * Classification：Hash Table, Two Pointers, String, Sliding Window
 */

/*
 * Solution 1
 * 2019-07-11  Runtime: 2 ms
 * Algorithm: => Hash Table + Two Pointers(same direction)
 * Time Complexity: O(n), Space Conplexity: ?
 */

class Solution {
    public String minWindow(String s, String t) {
        String subArray = "";
        String res = "";
        if (t.length() == 0) return res;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        
        int[] cntS = new int[256];
        int[] cntT = new int[256];
        int K = 0;
        for (int i = 0; i < 256; ++i) {
            cntS[i] = cntT[i] = 0;
        }
        
        for (char c : tt) {
            ++cntT[c];
            if (cntT[c] == 1) {
                ++K;
            }
        }
        
        int now = 0; 
        int ansl = -1, ansr = -1;
        int l, r = 0;
        
        for (l = 0; l < ss.length; ++l) {
            while (r < ss.length && now < K) {
                ++cntS[ss[r]];
                if (cntS[ss[r]] == cntT[ss[r]]) {
                    ++now;
                }
                
                ++r;
            }
            
            if (now == K) {
                if (ansl == -1 || r - l < ansr - ansl) {
                    ansl = l;
                    ansr = r;
                }
            }
            
            --cntS[ss[l]];
            if (cntS[ss[l]] == cntT[ss[l]] - 1) {
                --now;
            }
        }
        
        if (ansl == -1) {
            return "";
        }
        else {
            return s.substring(ansl, ansr);
        }
    }
}
