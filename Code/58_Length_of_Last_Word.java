/*
 * 58. Length of Last Word
 * Target: Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 *         return the length of last word in the string.
 *         If the last word does not exist, return 0.
 * Difficulty：Easy
 * Classification：String
 */

/*
 * Solution 1
 * 2019-07-22  Runtime: 0 ms
 * Algorithm: => String. Firstly abandon ' ' from the end of string, then keep searching until meet ' '.
 * Time Complexity: O(n). Space Conplexity: O(1)
 */

class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        int res = 0;
        int i = s.length() - 1;
        while (i >= 0)  {
            if (s.charAt(i) == ' ') {
                i--;
            } else {
                break;
            }
        }
        for (int j = i; j >= 0; j--) {
            if (s.charAt(j) != ' ') {
                res++;
                i--;

            } else {
                break;
            }
        }
        return res;
    }
}
