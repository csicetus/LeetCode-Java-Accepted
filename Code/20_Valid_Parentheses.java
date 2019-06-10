/*
 * 20. Valid Parentheses
 * 2019-06-10  Runtime: 1 ms
 * Target: Valid Parentheses.
 * Difficulty：Easy
 * Classification：String, Stack
 * Algorithm: => Use stack
 * Time complexity: O(n), Space complexity: O(n)
 */

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(' ');
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }
            else if (Math.abs(s.charAt(i) - stack.pop()) > 2){
                return false;
            }
        }
        stack.pop();
        return stack.empty();
    }
}
