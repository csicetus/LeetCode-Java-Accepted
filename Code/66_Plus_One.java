/*
 * 66. Plus One
 * Target: Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
*          The digits are stored such that the most significant digit is at the head of the list, 
*          and each element in the array contain a single digit.
 * Difficulty：Easy
 * Classification：Array
 */

/*
 * Solution 1
 * 2019-07-23  Runtime: 0 ms
 * Algorithm: => Math
 * Time Complexity: O(n). Space Conplexity: O(n)
 */

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length - 1;
        int carry = 0;
        if (digits[n] == 9) {
            digits[n] = 0;
            carry++;
        } else {
            digits[n] += 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            int tmp = digits[i] + carry;
            digits[i] = tmp % 10;
            carry = tmp / 10;
        }
        if (carry != 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = carry;
            for (int j = 1; j < newDigits.length; j++) {
                newDigits[j] = digits[j - 1];
            } 
            return newDigits;
        }
        return digits;
    }
}


/*
 * Solution 2
 * 2019-07-23  Runtime: 0 ms
 * Algorithm: => Recursion
 * Time Complexity: O(n). Space Conplexity: ?
 */
 
class Solution {
    public int[] plusOne(int[] digits) {
        return plusDigits(digits, digits.length - 1);
    }
    
    private int[] plusDigits(int[] digits, int index) {
        if (index < 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            return newDigits;
        }
        
        if (digits[index] < 9) {
            digits[index] += 1;
            return digits;
        }
        digits[index] = 0;
        return plusDigits(digits, index - 1);
    } 
}


/*
 * Solution 3
 * 2019-07-23  Runtime: 0 ms
 * Algorithm: => Iteration
 * Time Complexity: O(n). Space Conplexity: ?
 */
