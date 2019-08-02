/*
 * 503. Next Greater Element II
 * Target: Given a circular array (the next element of the last element is the first element of the array),
 *         print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number
 *         to its traversing-order next in the array, which means you could search circularly to find its next greater number.
 *         If it doesn't exist, output -1 for this number.
 * Difficulty：Medium
 * Classification：Stack
 */
 
 /*
 * Solution 1
 * 2019-08-02  Runtime: 26 ms
 * Algorithm: => Extend the original array to twice length without Stack.
 * Time Complexity: O(n^2). Space Conplexity: O(n). 
 */
 
 class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        int[] twoSizeNums = new int[nums.length * 2];
        for(int i = 0; i < nums.length * 2; i++) {
            twoSizeNums[i] = nums[i % nums.length];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length * 2; j++) {
                if (twoSizeNums[j] > nums[i]) {
                    res[i] = twoSizeNums[j];
                    break;
                }
            }
        }
        return res;
    }
}


 /*
 * Solution 2
 * 2019-08-02  Runtime: 7 ms
 * Algorithm: => Extend the original array to twice length without Stack.
 * Time Complexity: O(n). Space Conplexity: O(n). 
 */
 
 class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length * 2; i++) {
            int num = nums[i % nums.length];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                res[stack.pop()] = num;
            }
            if (i < nums.length) stack.push(i);
        }
        return res;
    }
}
