/*
 * 189. Rotate Array
 * Target: Given an array, rotate the array to the right by k steps, where k is non-negative.
 *         Eg => Input: [1,2,3,4,5,6,7] and k = 3. Output: [5,6,7,1,2,3,4]
 * Difficulty：Easy
 * Classification：Array
 */

/*
 * Solution 1
 * 2019-08-23  Runtime: 105 ms
 * Algorithm: => Rotate one by one
 * Time Complexity: O(n^k)?. Space Conplexity: O(1)
 */

class Solution {
    public void rotate(int[] nums, int k) {
        while (k > 0) {
            int tmp = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                nums[i + 1] = nums[i];
            }
            nums[0] = tmp;
            k--;
        }
    }
}


/*
 * Solution 2
 * 2019-08-23  Runtime: 1 ms
 * Algorithm: => Separate original array, change the two parts position by using a new array.
 * Time Complexity: O(n). Space Conplexity: O(n)
 */

class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1 || k == nums.length) {
            return;
        }
        if (k > nums.length) {
            k = k % nums.length;
        }
        int[] newNums = new int[nums.length];
        for (int i = nums.length - k; i < nums.length; i++) {
            newNums[i - nums.length + k] = nums[i];
        }
        
        for (int i = 0; i < nums.length - k; i++) {
            newNums[i + k] = nums[i];
        }
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }
    }
}


/*
 * Solution 3
 * 2019-08-23  Runtime: 0 ms
 * Algorithm: => Reverse. [1,2,3,4,5,6,7] and k = 3.
 *               1. [1,2,3,4,5,6,7] => [4,3,2,1,5,6,7]
 *               2. [4,3,2,1,5,6,7] => [4,3,2,1,7,6,5]
 *               3. [4,3,2,1,7,6,5] => [5,6,7,1,2,3,4]
 * Time Complexity: O(n). Space Conplexity: O(1)
 */
 
 class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1 || k == nums.length) {
            return;
        }
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    
    private void reverse(int[] nums, int l, int r) {
        int tmp = 0;
        while (l < r) {
            tmp = nums[r];
            nums[r] = nums[l];
            nums[l] = tmp;
            l++;
            r--;
        }
    }
}


/*
 * Solution 4
 * 2019-08-24  Runtime: 0 ms
 * Algorithm: => Loop.
 * Time Complexity: O(n). Space Conplexity: O(1)
 */
 
 class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1 || k == nums.length || k <= 0) {
            return;
        }
        k %= nums.length;
        int cur = nums[0], idx = k, head = 0;
        for (int i = 0; i < nums.length; i++) {
            if (idx == head) {
                nums[idx] = cur;
                head++;
                idx++;
                cur = nums[idx];
                idx = (idx + k) % nums.length;
            } else {
                int tmp = nums[idx];
                nums[idx] = cur;
                cur = tmp;
                idx = (idx + k) % nums.length;
            }
        }
    }
}
