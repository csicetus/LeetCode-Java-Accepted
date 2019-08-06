/*
 * 125. Valid Palindrome
 * Target: Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *         For the purpose of this problem, we define empty string as valid palindrome.
 * Difficulty：Easy
 * Classification：Two Pointers, String
 */

/*
 * Solution 1
 * 2019-08-06  Runtime: 21 ms
 * Algorithm: => Filter String and compare it with reverse string.
 * Time Complexity: ?. Space Conplexity: ?. 
 */
 
 class Solution {
    public boolean isPalindrome(String s) {
        if (s == "") return true;
        String newS = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reverS = new StringBuffer(newS).reverse().toString();
        if (newS.length() != reverS.length()) return false;
        for (int i = 0; i < newS.length(); i++) {
            if (newS.charAt(i) != reverS.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}


/*
 * Solution 2
 * 2019-08-06  Runtime: 3 ms
 * Algorithm: => Two Pointers. Compare it one by one.
 * Time Complexity: ?. Space Conplexity: O(n). 
 */
 
 class Solution {
    public boolean isPalindrome(String s) {
        if (s == "") return true;
        int l = 0, r = s.length() - 1;
        char[] ch = s.toCharArray();
        while (l <= r) {
            if (!Character.isLetterOrDigit(ch[l])) l++;
            else if (!Character.isLetterOrDigit(ch[r])) r--;
            else if(Character.toLowerCase(ch[l]) != Character.toLowerCase(ch[r])) {
                l++;
                r--;
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }
}


/*
 * Solution 3
 * 2019-08-06  Runtime: 1 ms
 * Algorithm: => Array and Two Pointers. Compare it one by one.
 * Time Complexity: ?. Space Conplexity: ?. 
 */
 
 class Solution {
    private static char[] charMap = new char[256];
    static {
        for (int i = 0; i < 10; i++) {
            charMap[i + '0'] = (char)(i + 1);
        }
        for (int i = 0; i < 26; i++) {
            charMap[i + 'a'] = (char)(i + 11);
            charMap[i + 'A'] = (char)(i + 11);
        }
    }
    public boolean isPalindrome(String s) {
        if (s == "") return true;
        int l = 0, r = s.length() - 1;
        char[] ch = s.toCharArray();
        char cl, cr;
        while (l < r) {
            cl = charMap[ch[l]];
            cr = charMap[ch[r]];
            if (cl != 0 && cr != 0) {
                if (cl != cr) return false;
                l++;
                r--;
            } else {
                if (cl == 0) l++;
                if (cr == 0) r--;
            }
        }
        return true;
    }
}
