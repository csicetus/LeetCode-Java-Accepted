/*
 * 300. Longest Increasing Subsequence
 * Target: Given an unsorted array of integers, find the length of longest increasing subsequence.
 * Difficulty：Medium
 * Classification：Binary Search, DP
 */

/*
 * Solution 1
 * 2019-07-31  Runtime: 0 ms
 * Algorithm: => Binary Search.
 * Time Complexity: ?. Space Conplexity: O(n)
 */
 
 class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n= nums.length, len = 0;
        int[] LIS = new int[n];
        LIS[len++] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > LIS[len - 1]) {
                LIS[len++] = nums[i];
            } else {
                int pos = findPosition(LIS, 0, len - 1, nums[i]);
                LIS[pos] = nums[i];
            }
        }
        return len;
    }
    
    private int findPosition(int[] nums, int lo, int hi, int tar) {
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == tar) {
                return mid;
            } else if (nums[mid] > tar) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}


/*
 * Solution 2
 * 2019-07-31  Runtime: 1 ms
 * Algorithm: => DP
 * Time Complexity: ?. Space Conplexity: O(n)
 */
 
 import javafx.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length, len = 0;
        int[] dp = new int[n];
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) i = -(i + 1);
            dp[i] = num;
            if (i == len) len++;
        }
        return len;
    }
}


/*
 * Solution 3
 * 2019-07-31  Runtime: 1 ms
 * Algorithm: => DP without Arrays.binarySearch().
 * Time Complexity: ?. Space Conplexity: O(n)
 */
 
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length, res = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
 
 
/*
 * Solution 4
 * 2019-07-31  Runtime: 1 ms
 * Algorithm: => Binary Search
 * Time Complexity: ?. Space Conplexity: O(n)
 */
 
 class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length, res = 0;
        int[] dp = new int[n];
        for (int num : nums) {
            int i = 0, j = res;
            while (i != j) {
                int m = i + (j - i) / 2;
                if (dp[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            dp[i] = num;
            if (i == res) res++;
        }
        return res;
    }
}
