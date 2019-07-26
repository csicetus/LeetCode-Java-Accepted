/*
 * 43. Multiply Strings
 * Target: Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *         You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * Difficulty：Medium
 * Classification：Math, String
 */

/*
 * Solution 1
 * 2019-07-26  Runtime: 4 ms
 * Algorithm: => Math
 * Time Complexity: O(m * n). Space Conplexity: O(m + n). m is the length of num1, n is the length of num2.
 */
 
 class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int[] pos = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = pos[i + j + 1] + mul;
                pos[i + j] += sum / 10;
                pos[i + j + 1] = sum % 10;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < pos.length; i++) {
            if (i == 0 && pos[i] == 0) {
                continue;
            }
            res.append(pos[i]);
        }
        return res.toString();
    }
}
 
