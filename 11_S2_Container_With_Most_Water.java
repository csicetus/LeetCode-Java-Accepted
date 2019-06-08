/*
 * 11. Container With Most Water solution 2(best one)
 * 2019-06-07  Runtime: 2 ms
 * Target: The array subscript represents the abscissa, the value in the array represents the ordinate, and calculate the maximum area.
 * Difficulty：Medium
 * Classification：Array, Two Pointers
 * Algorithm: => Set two points as the beginning and end of array. 
 *               Everytime move the shortest one(If move longest one, area wouldn't be larger because the area depends on shortest one)
 * Time Conplexity: O(n)
 */

class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxWater = (end - start) * Math.min(height[end], height[start]);
        while (start < end){
            if (height[start] <= height[end]){
                start ++;
            }
            else {
                end --;
            }
            if (maxWater < (end - start) * Math.min(height[end], height[start])){
                maxWater = (end - start) * Math.min(height[end], height[start]);
            }
        }
        return maxWater;
    }
}
