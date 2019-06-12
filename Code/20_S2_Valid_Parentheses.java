/*
 * 20. Valid Parentheses solution 2
 * 2019-06-10  Runtime: 83 ms
 * Target: Valid Parentheses.
 * Difficulty：Easy
 * Classification：String, Stack
 * Algorithm: => Replace from middle
 *
 
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
