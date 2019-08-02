/*
 * 739. Daily Temperatures
 * Target: Given a list of daily temperatures T, return a list such that, for each day in the input, 
 *         tells you how many days you would have to wait until a warmer temperature. 
 *         If there is no future day for which this is possible, put 0 instead.
 * Difficulty：Medium
 * Classification：Hash Table, Stack
 */
 
 /*
 * Solution 1
 * 2019-08-02  Runtime: 13 ms
 * Algorithm: => Stack. Stack stores pre numbers and compare the top number with current T[i].
 * Time Complexity: O(n). Space Conplexity: O(n). 
 */
 
 class Solution {
    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;
    }
}

 
  /*
 * Solution 2
 * 2019-08-02  Runtime: 4 ms
 * Algorithm: => Array. Same as sol 1.
 * Time Complexity: O(n). Space Conplexity: O(n). 
 */
 
 class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] stack = new int[T.length];
        int[] res = new int[T.length];
        int top = -1;
        for (int i = 0; i < T.length; i++) {
            while (top > -1 && T[i] > T[stack[top]]) {
                int idx = stack[top];
                top--;
                res[idx] = i - idx;
            }
            top++;
            stack[top] = i;
        }
        return res;
    }
}
