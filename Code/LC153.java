//////// sol 1: two pointers

// Time: O(logn); Space: O(1)
class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        if (nums[lo] < nums[hi]) {
            return nums[lo];
        }
        while (hi - lo > 1) {
            int mid = lo + (hi - lo) / 2;
            // int mid = (lo + hi) / 2;
            if (nums[mid] < nums[lo]) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return nums[hi];
    }
}
