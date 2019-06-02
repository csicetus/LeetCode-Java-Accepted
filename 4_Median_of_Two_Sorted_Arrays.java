/*
 * 4. Median of Two Sorted Arrays
 * 2019-06-02  Runtime: 3 ms
 * Target:  Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * Difficulty：Hard
 * Classification：Array, Binary Search, Divide and Conquer
 * Algorithm: Two sorted arrays nums1 and nums2 of size m and n respectively. 
 * Use getNum(int[] nums, int i) function to deal with boundary problems, so don't need to consider special case.
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, k = (m + n)/2;
        int i = 0, j = k;
        int low = 0, high = Math.min(j, m);
        
        if(nums1.length == 1 && nums2.length == 1){
            return (double)(nums1[0] + nums2[0])/2;
        }
        
        while(true){
            i = low + (high - low)/2;
            j = k - i;
            if(getNum(nums1, i) >= getNum(nums2, j - 1)){
                if(getNum(nums2, j) >= getNum(nums1, i - 1)) break;
                else high = i - 1; 
            }
            else low = i + 1;
        }
        
        if((m + n) % 2 == 1) return Math.min(getNum(nums1, i), getNum(nums2, j));
        return (double)(Math.min(getNum(nums1, i), getNum(nums2, j)) + Math.max(getNum(nums1, i - 1), getNum(nums2, j - 1)))/2; 
    }
    
    private int getNum(int[] nums, int i){
        if(i < 0) return Integer.MIN_VALUE;
        if(i >= nums.length) return Integer.MAX_VALUE;
        return nums[i];
    }
}
