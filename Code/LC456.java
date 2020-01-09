/////////// use array as a stack

// Time: O(n); Space: O(n)
class Solution {
    public boolean find132pattern(int[] nums) {
    int n = nums.length, top = n, third = Integer.MIN_VALUE;

    for (int i = n - 1; i >= 0; i--) {
        // assume i < j < thirdIdx and nums[j] > third
        // if nums[i] < third we find a pattern that
        // nums[i] < third < nums[j], return true 
        if (nums[i] < third) return true;
        
        // for the situation nums[i] >= third, regard nums[i] as
        // the second number of "132" pattern
        // we should increased third but keep nums[i] >= third
        // nums[top] < nums[top + 1] < ... < nums[n - 1] -> stack
        while (top < n && nums[top] < nums[i]) {
            third = nums[top++];
        }
        
        // after while loop, nums[top] >= nums[i]
        top--;
        nums[top] = nums[i];
    }
    
    return false;
}
}
