////////// sol 1: Two pointers, fast and slow -> cycle

// Time: Space: O(n); Space: O(1)
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        if (n == 1) return false;
        // i stands for cycle start position
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            int slow = i, fast = nextPosition(i, nums);
            while (nums[fast] * nums[i] > 0 && nums[nextPosition(fast, nums)] * nums[i] > 0) {
                // fast == slow
                if (fast == slow) {
                    // confirm if not forward or backward
                    if (slow == nextPosition(slow, nums)) {
                        break;
                    }
                    return true;
                }
                slow = nextPosition(slow, nums);
                fast = nextPosition(nextPosition(fast, nums), nums);
            }
            
            // no loop, set all elem along the way to 0
            slow = i;
            while (nums[i] * nums[slow] > 0) {
                int next = nextPosition(slow, nums);
                nums[slow] = 0;
                slow = next;
            }     
        }
        return false;
    }
    
    private int nextPosition(int k, int[] nums) {
        int n = nums.length;
        return nums[k] + k >= 0 ? (nums[k] + k) % n : n + (nums[k] + k) % n;
    }
}
