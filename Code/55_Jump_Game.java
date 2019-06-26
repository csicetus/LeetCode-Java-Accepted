/*
 * 55. Jump Game
 * Target: The maximum number of steps that can be taken in the array, 
 *         ask if you can go from the beginning of the array to the end of the array.
 * Difficulty：Medium
 * Classification：Array, Greedy
 * Best solution: solution 3.
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
 * 2019-06-25  Runtime: 171 ms
 * Algorithm: => DP Bottom-up.
 * Time complexity: O(n^2). Space complexity: O(n).
 */
 
 enum Index {
        GOOD, BAD, UNKNOWN
}

class Solution {
    public boolean canJump(int[] nums) {
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        for (int i = memo.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], memo.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        return memo[0] == Index.GOOD;
    }
}

 
/*
 * Solution 3 BEST SOL!
 * 2019-06-25  Runtime: 1 ms
 * Algorithm: => Greedy.
 * Time complexity: O(n). Space complexity: O(1).
 */

class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
