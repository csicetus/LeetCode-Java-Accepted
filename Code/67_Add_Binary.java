/*
 * 67. Add Binary
 * Target: Given two binary strings, return their sum (also a binary string).
*          The input strings are both non-empty and contains only characters 1 or 0.
 * Difficulty：Easy
 * Classification：Math, String
 * Note: same as lc2.
 */

/*
 * Solution 1
 * 2019-07-23  Runtime: 0 ms
 * Algorithm: => Math
 * Time Complexity: ?. Space Conplexity: ?
 */

class Solution {
    public String addBinary(String a, String b) {
        int carry = 0, sum = 0;
        int i = a.length() - 1, j = b.length() - 1;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int aNum = i >= 0 ? a.charAt(i) - '0' : 0;
            int bNum = j >= 0 ? b.charAt(j) - '0' : 0;
            sum = aNum + bNum + carry;
            carry = 0;
            if (sum >= 2) {
                sum %= 2;
                carry = 1;
            }
            res.append(sum);
            i--;
            j--;
        }
        if (carry != 0) {
            res.append(1);
        }
        return res.reverse().toString();
    }
}
