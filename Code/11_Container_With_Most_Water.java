/*
 * 11. Container With Most Water
 * Target: The array subscript represents the abscissa, the value in the array represents the ordinate, and calculate the maximum area.
 * Difficulty：Medium
 * Classification：Array, Two Pointers
 */

 /*
 * Solution 1
 * 2019-06-07  Runtime: 204 ms
 * Algorithm: => Two loops, Violent search
 * Time Conplexity: O(n^2)
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


/*
 * Solution 2
 * 2019-06-07  Runtime: 2 ms
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
