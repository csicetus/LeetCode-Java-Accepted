/*
 * 213. House Robber II
 * Target: Given a list of non-negative integers representing the amount of money of each house, 
 *         determine the maximum amount of money you can rob tonight without alerting the police.
 *         All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. 
 *         it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Difficulty：Medium
 * Classification：DP
 */

/*
 * Solution 1
 * 2019-08-05  Runtime: 0 ms
 * Algorithm: => Iteration. The diff between House Robber I and House Robber II is we shouldn't peek both the start and the end of cycle.
 *               So we can separate int[] nums to int[] sub1 and sub2, which means the start and end don't show up at the same calculation. 
 *               Then return the max money of them.
 *               The helperRob() function is the same as rob() function in House Robber I.
 * Time Complexity: ?. Space Conplexity: O(n). 
 */
 
 class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length < 2) return nums[0];
        int[] sub1 = Arrays.copyOfRange(nums, 1, nums.length);
        int[] sub2 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        return Math.max(helperRob(sub1), helperRob(sub2));
    }
    
    private int helperRob(int[] subNums) {
        if (subNums.length == 0) return 0;
        if (subNums.length < 2) return subNums[0];
        int[] res = new int[subNums.length + 1];
        Arrays.fill(res, 0);
        res[0] = subNums[0];
        res[1] = Math.max(subNums[0], subNums[1]);
        for (int i = 2; i < subNums.length; i++) {
            res[i] = Math.max(res[i - 1], res[i - 2] + subNums[i]);
        }
        return res[subNums.length - 1];
    }
}


/*
 * Solution 2
 * 2019-08-05  Runtime: 0 ms
 * Algorithm: => Iteration + 2 variables.
 * Time Complexity: ?. Space Conplexity: O(1). 
 */

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length < 2) return nums[0];
        int[] sub1 = Arrays.copyOfRange(nums, 1, nums.length);
        int[] sub2 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        return Math.max(helperRob(sub1), helperRob(sub2));
    }
    
    private int helperRob(int[] subNums) {
        if (subNums.length == 0) return 0;
        if (subNums.length < 2) return subNums[0];
        int pre1 = 0;
        int pre2 = 0;
        for (int subNum : subNums) {
            int tmp = pre1;
            pre1 = Math.max(pre1, pre2 + subNum);
            pre2 = tmp;
        }
        return pre1;
    }
}


/*
 * Solution 3
 * 2019-08-05  Runtime: 0 ms
 * Algorithm: => Iteration. Scrolling array.
 * Time Complexity: ?. Space Conplexity: O(1). 
 */

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length < 2) return nums[0];
        int[] sub1 = Arrays.copyOfRange(nums, 1, nums.length);
        int[] sub2 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        return Math.max(helperRob(sub1), helperRob(sub2));
    }
    
    private int helperRob(int[] subNums) {
        if (subNums.length == 0) return 0;
        if (subNums.length < 2) return subNums[0];
        int[] res = new int[2];
        Arrays.fill(res, 0);
        res[0] = subNums[0];
        res[1] = Math.max(subNums[0], subNums[1]);
        for (int i = 2; i < subNums.length; i++) {
            res[i % 2] = Math.max(res[(i - 1) % 2], res[(i - 2) % 2] + subNums[i]);
        }
        return Math.max(res[0], res[1]);
    }
}
