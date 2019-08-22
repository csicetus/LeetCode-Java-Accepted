/*
 * 344. Reverse String
 * Target: Write a function that reverses a string. The input string is given as an array of characters char[].
 *         Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * Difficulty：Easy
 * Classification：Two pointers, String
 */

/*
 * Solution 1
 * 2019-08-21  Runtime: 1 ms
 * Algorithm: => Two Pointers. Swap method
 * Time Complexity: O(n). Space Conplexity: O(1). 
 */
 
 class Solution {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        for (int i = l, j = r; i < j; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}
 
 

/*
 * Solution 2
 * 2019-08-21  Runtime: 1 ms
 * Algorithm: => Two Pointers. Swap method
 * Time Complexity: O(n). Space Conplexity: O(1). 
 */
 
 class Solution {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l <= r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }
}


/*
 * Solution 3
 * 2019-08-21  Runtime: ? ms
 * Algorithm: => StringBuilder
 * Time Complexity: ?. Space Conplexity: O(1). 
 */
 
 class Solution {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
 
