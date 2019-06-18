/*
 * 31. Next Permutation
 * 2019-06-16  Runtime: 0 ms
 * Target: Implement next permutation.
 * Difficulty：Medium
 * Classification：Array
 * Algorithm: => Look for the first smaller number x from the back, find the first number y larger than x from the number 
 *               after this number, exchange, and then reverse numbers after the number y.
 * Time complexity: O(n), Space complexity: O(1)
 */
 
class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int n = nums.length;
        int end = n - 1;
        
        // find min number index
        while (start < end) {
            int mid = Math.round((start + end) / 2);
            System.out.print(mid);
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        
        // find max number index
        // while (start < end) {
        //     int mid = (start + end) / 2;
        //     if (nums[mid] < nums[start]) {
        //         end = mid + 1;
        //     }
        //     else {
        //         start = mid;
        //     }
        // }
        
        
        // (pos + bias) % n = index
        // (n - 1 + bias) % n = start
        int bias = (start + n) - (n - 1);
        System.out.println(bias);
        start = 0;
        end = n - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            int mid_index = (mid + bias) % n;
            System.out.println(mid_index);
            if (target == nums[mid_index]) {
                return mid_index;
            }
            if (target > nums[mid_index]) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
