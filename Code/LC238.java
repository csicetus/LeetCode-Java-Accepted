//////////////// sol 1: first calculate left product, then product *= right product(store with variable R)

// Time: O(n); Space: O(1), no res[] space for this question
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        // start from left, calculate product from left
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        
        // start from right
        // refresh res with left product * right product
        // refresh product with right num
        int product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= product;
            product *= nums[i];
        }
        return res;
    }
}
