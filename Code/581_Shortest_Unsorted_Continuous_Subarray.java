/*
 * 581. Shortest Unsorted Continuous Subarray
 * Target: Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, 
 *         then the whole array will be sorted in ascending order, too.
 *         You need to find the shortest such subarray and output its length.
 * Difficulty：Easy
 * Classification：Array
 * Best solution: sol 3.
 */

/*
 * Solution 1
 * 2019-07-27  Runtime: 815 ms
 * Algorithm: => Brutal.
 * Time Complexity: O(n^2). Space Conplexity: O(1)
 */
 
 class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums[0] > nums[nums.length - 1]) return nums.length;
        int r = 0, l = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    r = Math.max(r, j);
                    l = Math.min(l, i);
                }
            }
        }
        return r - l >= 0 ? r - l + 1 : 0;
    }
}


/*
 * Solution 2
 * 2019-07-27  Runtime: 8 ms
 * Algorithm: => Sorted Array.
 * Time Complexity: O(nlogn). Space Conplexity: O(n)
 */

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 0) return 0;
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int end = 0, start = snums.length;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                end = Math.max(end, i);
                start = Math.min(start, i);
            }
        }
        return end - start >= 0 ? end - start + 1 : 0;
    }
}


/*
 * Solution 3
 * 2019-07-27  Runtime: 49 ms
 * Algorithm: => Stack.
 * Time Complexity: O(n). Space Conplexity: O(n)
 */
 
 class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int r = 0, l = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                l = Math.min(l, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                r = Math.max(r, stack.pop());
            }
            stack.push(i);
        }
        return r - l >= 0 ? r - l + 1 : 0;
    }
}


/*
 * Solution 4
 * 2019-07-27  Runtime: 3 ms
 * Algorithm: => Without Using Extra Space.
 *               Scan the array numsnums in the reverse order and when the slope becomes rising instead of falling, 
 *               we start looking for the maximum element till we reach the beginning of the array, given by max. The same as max.
 *               Traverse over numsnums and determine the correct position of minmin and maxmax by comparing these elements with the other array elements.
 * Time Complexity: O(n). Space Conplexity: O(1)
 */
 
 class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 0) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                flag = true;
            }
            if (flag) {
                min = Math.min(min, nums[i]);
            }
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                flag = true;
            }
            if (flag) {
                max = Math.max(max, nums[i]);
            }
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l]) break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r]) break;
        }
        return r - l >= 0 ? r - l + 1 : 0;
    }
}
