/*
 * 55. Jump Game
 * Target: The maximum number of steps that can be taken in the array, 
 *         ask if you can go from the beginning of the array to the end of the array.
 * Difficulty：Medium
 * Classification：Array, Greedy
 */

/*
 * Solution 1
 * 2019-06-25  Runtime: 1371 ms
 * Algorithm: => DP Top-down.
 * Time complexity: O(n^2). Space complexity: O(n).
 */

enum Index {
        GOOD, BAD, UNKNOWN
}

class Solution {
    Index[] memo;
    
    public boolean canJumpFromPosition(int pos, int[] nums) {
        if (memo[pos] != Index.UNKNOWN) {
            return memo[pos] == Index.GOOD ? true : false;
        }
        
        int furthestJump = Math.min(pos + nums[pos], nums.length - 1);
        for (int nextPos = pos + 1; nextPos <= furthestJump; nextPos++) {
            if (canJumpFromPosition(nextPos, nums)) {
                memo[pos] = Index.GOOD;
                return true;
            }
        }
        memo[pos] = Index.BAD;
        return false;
    }
    
    public boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition(0, nums);
    }
}


/*
 * Solution 2
 * 2019-06-25  Runtime: 1 ms
 * Algorithm: => Divide and Conquer.
 * Time complexity: O(n^2). Space complexity: O(n).
 */
 
 
 
 /*
 * Solution 3
 * 2019-06-25  Runtime: 1 ms
 * Algorithm: => Divide and Conquer.
 * Time complexity: O(n^2). Space complexity: O(n).
 */
