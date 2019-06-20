/*
 * 20. Valid Parentheses
 * Target: Valid Parentheses.
 * Difficulty：Easy
 * Classification：String, Stack
 */

/*
 * Solution 1
 * 2019-06-10  Runtime: 1 ms
 * Algorithm: => Use stack.
 * Time complexity: O(n), Space complexity: O(n).
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


/*
 * Solution 2
 * 2019-06-10  Runtime: 83 ms
 * Algorithm: => Replace from middle.
 */

class Solution {
    public boolean isValid(String s) {
         while (s.contains("{}") || s.contains("[]") || s.contains("()")){
            if (s.contains("{}")) s = s.replace("{}", "");
            if (s.contains("[]")) s = s.replace("[]", "");
            if (s.contains("()")) s = s.replace("()", "");
        }     
        return s.isEmpty();
    }
}

