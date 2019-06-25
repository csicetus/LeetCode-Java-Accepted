/*
 * 53. Maximum Subarray
 * Target: Find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * Difficulty：Easy
 * Classification：Array, Divide and Conquer, Dynamic Programming
 */

/*
 * Solution 1
 * 2019-06-23  Runtime: 1 ms
 * Algorithm: => DP.
 * Time complexity: O(n). Space complexity: O(n).
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int num_pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num_pre = Math.max(num_pre + nums[i], nums[i]);
            max = Math.max(max, num_pre);
        }
        return max;
    }
}


/*
 * Solution 2
 * 2019-06-24  Runtime: 1 ms
 * Algorithm: => Divide and Conquer.
 * Time complexity: O(n*logn).
 */

class Solution {
    public int maxSubArray(int[] nums) {
        return SubArr(nums, 0, nums.length - 1);
    }
    
    private int SubArr(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }
        int mid = (lo + hi) / 2;
        return Math.max(Math.max(SubArr(nums, lo, mid), SubArr(nums, mid + 1, hi)), maxSubArrCross(nums, lo, mid, hi));
    }
    
    private int maxSubArrCross(int[] nums, int lo, int mid, int hi) {
        int sum = 0, sum_l = Integer.MIN_VALUE, sum_r = Integer.MIN_VALUE;
        for (int i = mid; i >= lo; i--) {
            sum += nums[i];
            if (sum > sum_l) {
                sum_l = sum;
            }
        }
        sum = 0;
        for (int j = mid + 1; j <= hi; j++) {
            sum += nums[j];
            if (sum > sum_r) {
                sum_r = sum;
            }
        }
        return sum_l + sum_r;
    }
}
