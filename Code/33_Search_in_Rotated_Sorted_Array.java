/*
 * 33. Search in Rotated Sorted Array
 * Target: Find the specified number in the inverted ordered array.
 * Difficulty：Medium
 * Classification：Array, Binary Search
 * Note: Pay attention to the boundary problem!!! Is there an equal sign? Especially two numbers, e.g. [1,3] tar = 3.
 */
 
/*
 * Solution 1
 * 2019-06-17  Runtime: 0 ms
 * Algorithm: => Search by bias.
 * Time complexity: O(logn). Space complexity: O(1).
 */
 
 class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int n = nums.length;
        int end = n - 1;
        
        // find min number index
        while (start < end) {
            int mid = Math.round((start + end) / 2);
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
        
        //int bias = (start + n) - (n - 1);
        
        // (pos + bias) % n = index
        // (n - 1 + bias) % n = start
        int bias = start;
        
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


/*
 * Solution 2
 * 2019-06-17  Runtime: 0 ms
 * Algorithm: => Search by make the other part inf or -inf.
 * Time complexity: O(logn). Space complexity: O(1).
 */

class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[0] == target) {
                return 0;
            }
            
            if ((nums[mid] < nums[0]) != (target < nums[0])) {
                nums[mid] = (target > nums[0]) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            if (nums[mid] > target) {
                hi = mid - 1;
            }
            else if (nums[mid] < target) {
                lo = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
        
    }
}


/*
 * Solution 3
 * 2019-06-17  Runtime: 0 ms
 * Algorithm: => Search by choose ordered part.
 * Time complexity: O(logn). Space complexity: O(1).
 */

class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            
            if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }                
            }
            else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }             
            }
        }
        return -1;
        
    }
}
