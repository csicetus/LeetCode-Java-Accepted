/*
 * 268. Missing Number
 * Target: Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *         Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 * Difficulty：Easy
 * Classification：Array, Math, Bit Manipulation
 */

/*
 * Solution 1
 * 2019-08-28  Runtime: 11 ms
 * Algorithm: => HashSet. 
 * Time Complexity: O(n). Space Conplexity: O(n)
 */
 
 class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int n : nums) {
            if (!set.contains(n)) {
                set.add(n);
            } 
        }
        for (int i = 0; i < len + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}


/*
 * Solution 2
 * 2019-08-28  Runtime: 7 ms
 * Algorithm: => Array sort. 
 * Time Complexity: O(nlogn). 
 * Space Conplexity: O(1) or O(n). If modifying nums is forbidden, we can allocate an O(n) size copy and sort that instead.
 */
 
 class Solution {
    public int missingNumber(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums[0] == 0 && nums.length == 1) return 1;
        if (nums[0] == 1 && nums.length == 1) return 0;
        Arrays.sort(nums);
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return -1;
    }
}


/*
 * Solution 3
 * 2019-08-28  Runtime: 0 ms
 * Algorithm: => Bit Manipulation. Eg input: [9,6,4,2,3,5,7,0,1] with index {0, 1, 2, 3, 4, 5, 6, 7, 8}, nums.length = maxNum = 9.
 *               res = 9 ^ (9 ^ 0) ^ (6 ^ 1) ^ (4 ^ 2) ^ (2 ^ 3) ^ (3 ^ 4) ^ (5 ^ 5) ^ (7 ^ 6) ^ (0 ^ 7) ^ (1 ^ 8)
 *                   = (9 ^ 9) ^(7 ^ 7) ^ (6 ^ 6) ^ (5 ^ 5) ^ (4 ^ 4) ^ (3 ^ 3) ^ (2 ^ 2) ^ (1 ^ 1) ^ (0 ^ 0) ^ 8
 *                   = 0 ^ 0 ^ 0 ^ 0 ^ 0 ^ 0 ^ 0 ^ 0 ^ 0 ^ 8 = 8.
 * Time Complexity: O(n). Space Conplexity: O(1)
 */
 
 class Solution {
    public int missingNumber(int[] nums) {
        if (nums.length == 0) return 0;
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }
}


/*
 * Solution 4
 * 2019-08-28  Runtime: 0 ms
 * Algorithm: => Gauss' Formula. Sum[0 ~ n] = n * (n + 1) / 2.
 * Time Complexity: O(n). Space Conplexity: O(1)
 */
 
 class Solution {
    public int missingNumber(int[] nums) {
        if (nums.length == 0) return 0;
        int sumWithoutMissing = nums.length * (nums.length + 1) / 2;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        return sumWithoutMissing - res;
    }
}


/*
 * Solution 5
 * 2019-08-28  Runtime: 0 ms
 * Algorithm: => Optimal of sol 4. Gauss' Formula. Sum[0 ~ n] = n * (n + 1) / 2.
 *               Eg Input: [0,1,2,3,4] Index[0,1,2,3,4] => Index[i] + 1: [1,2,3,4,5], res = (1+2+3+4+5)-(0+1+2+3+4) = 2.
 *               Eg Input: [0,1,3,4,5] Index[0,1,2,3,4] => Index[i] + 1: [1,2,3,4,5], res = (1+2+3+4+5)-(0+1+3+4+5) = 2.
 * Time Complexity: O(n). Space Conplexity: O(1)
 */
 
 class Solution {
    public int missingNumber(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += i + 1 - nums[i];
        }
        return res;
    }
}
 
 
