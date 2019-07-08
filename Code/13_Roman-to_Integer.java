/*
 * 13. Roman to Integer
 * Target: Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * Difficulty：Easy
 * Classification：Math, String
 */

/*
 * Solution 1
 * 2019-07-08  Runtime: 7 ms
 * Algorithm: => List all possible situations and search two str first, then one str in a loop.
 *               Note that we should add one more special signal "#" with value 0 at the end of string to 
 *               deal with the s.substring(i, i + 2).
 * Time Complexity: O(n), n is the length of string. Space Conplexity: O(1)
 */
 
 class Solution {
    public int romanToInt(String s) {
        int res = 0;
        int[] values = {0, 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] symbols = {"#", "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        List<String> sym = Arrays.asList(symbols);
        int i = 0;
        s += "#";
        while (i < s.length() - 1) {
            String st1 = s.substring(i, i + 1);
            String st2 = s.substring(i, i + 2);
            if (sym.contains(st2)) {
                res += values[sym.indexOf(st2)];
                i += 1;
            } else if (sym.contains(st1)) {
                res += values[sym.indexOf(st1)];
            }
            i += 1;
        }
        return res;
    }
}
 
 
/*
 * Solution 2
 * 2019-07-08  Runtime: 4 ms
 * Algorithm: => Search from the end of string and list all of possible situations.
 * Time Complexity: O(n), n is the length of string. Space Conplexity: O(1)
 */
 
 class Solution {
    public int romanToInt(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'I') {
                res += (res < 5) ? 1 : -1;
            }
            else if (s.charAt(i) == 'V') {
                res += 5;
            }
            else if (s.charAt(i) == 'X') {
                res += (res < 50) ? 10 : -10;
            }
            else if (s.charAt(i) == 'L') {
                res += 50;
            }
            else if (s.charAt(i) == 'C') {
                res += (res < 500) ? 100 : -100;
            }
            else if (s.charAt(i) == 'D') {
                res += 500;
            }
            else if (s.charAt(i) == 'M') {
                res += 1000;
            }
        }
        return res;
    }
}
