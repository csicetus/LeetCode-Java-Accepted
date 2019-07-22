/*
 * 12. Integer to Roman
 * Target: Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 * Difficulty：Medium
 * Classification：Math, String
 */

/*
 * Solution 1
 * 2019-07-21  Runtime: 4 ms
 * Algorithm: => Math
 * Time Complexity: ?. Space Conplexity: O(1)
 */

class Solution {
    public String intToRoman(int num) {
        String res = "";
        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] symbols = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int i = values.length - 1;
        while (num > 0) {
            for (; i >= 0; i--) {
                if (num >= values[i]) break;
            }
            res += symbols[i];
            num -= values[i];
        }    
        return res;  
    }
}

