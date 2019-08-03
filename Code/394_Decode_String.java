/*
 * 394. Decode String
 * Target: Given an encoded string, return its decoded string. Note that k is guaranteed to be a positive integer.
 *         The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. 
 *         You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *         Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. 
 * Difficulty：Medium
 * Classification：Greedy
 */

 /*
 * Solution 1
 * 2019-08-03  Runtime: 0 ms
 * Algorithm: => Stack. Use one stack to store int and string.
 * Time Complexity: ?. Space Conplexity: O(n). 
 */
 
 class Solution {
    public String decodeString(String s) {
        String res = "";
        Deque<String> stack = new ArrayDeque<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                stack.push(res);
                int start = i;
                while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
                stack.push(s.substring(start, i + 1));
            } else if (s.charAt(i) == '[') {
                res = "";
            } else if (s.charAt(i) == ']') {
                int times = Integer.parseInt(stack.pop());
                StringBuilder sb = new StringBuilder(stack.pop());
                for (int j = 0; j < times; j++) {
                    sb.append(res);
                }
                res = sb.toString();
            } else {
                res += s.charAt(i);
            }
            i++;
        }
        return res;
    }
}


 /*
 * Solution 2
 * 2019-08-03  Runtime: 1 ms
 * Algorithm: => Stack. Use two stack to store int and string separately.
 * Time Complexity: ?. Space Conplexity: O(n). 
 */
 
 class Solution {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Deque<Integer> intStack = new ArrayDeque<>();
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        int i = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                i = i * 10 + ch - '0';
            } else if (ch == '[') {
                intStack.push(i);
                strStack.push(res);
                res = new StringBuilder();
                i = 0;
            } else if (ch == ']') {
                StringBuilder sb = res;
                res = strStack.pop();
                int start = intStack.pop();
                for (int j = start; j > 0; j--) {
                    res.append(sb);
                }
            } else {
                res.append(ch);
            }
        }
        return res.toString();
    }
}


 /*
 * Solution 3
 * 2019-08-03  Runtime: 0 ms
 * Algorithm: => DFS. Use a global variable k.
 * Time Complexity: ?. Space Conplexity: ?. 
 */
 
class Solution {
    private int k = 0;
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        for (; k < s.length(); k++) {
            if (Character.isDigit(s.charAt(k))) {
                i = i * 10 + s.charAt(k) - '0';
            } else if (s.charAt(k) == '[') {
                k++;
                String tmp = decodeString(s);
                for (int j = 0; j < i; j++) {
                    res.append(tmp);
                }
                i = 0;
            } else if (s.charAt(k) == ']') {
                return res.toString();
            } else {
                res.append(s.charAt(k));
            }
        }
        return res.toString();
    }
}
 
