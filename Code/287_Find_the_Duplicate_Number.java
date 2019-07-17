/*
 * 287. Find the Duplicate Number
 * Target: Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
 *         prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * Difficulty：Medium
 * Classification：Array, Two points, Binary Search
 */

/*
 * Solution 1
 * 2019-07-16  Runtime: 6 ms
 * Algorithm: => Binary Search. Two points with reverse direction
 * Time Complexity: O(n*logn), Space Conplexity: O(1)
 */

class Solution {
    public int findDuplicate(int[] nums) {
        int lo = 1, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }
            if (cnt <= mid) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}


/*
 * Solution 2
 * 2019-07-16  Runtime: 0 ms
 * Algorithm: => Attached the code of Linked List Cycle II.
 * Time Complexity: ?, Space Conplexity: O(1)
 */

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (slow < nums.length && nums[fast] < nums.length) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                slow = 0;
                while (slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        }
        return -1;
    }
}
