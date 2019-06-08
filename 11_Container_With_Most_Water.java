/*
 * 11. Container With Most Water
 * 2019-06-07  Runtime: 204 ms
 * Target: The array subscript represents the abscissa, the value in the array represents the ordinate, and calculate the maximum area.
 * Difficulty：Medium
 * Classification：Array, Two Pointers
 * Algorithm: => Two loops, O(n)      
 */

class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        for(int i = 0; i < height.length; i++){
            for(int j = i + 1; j < height.length; j++){
                if((j - i)*(Math.min(height[i], height[j])) > maxWater){
                    maxWater = (j - i)*(Math.min(height[i], height[j]));
                }
            }
        }
        return maxWater;
    }
}
