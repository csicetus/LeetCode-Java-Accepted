/*
 * 167. Two Sum II - Input array is sorted
 * Target: Given an array of integers that is already sorted in ascending order, 
 *         find two numbers such that they add up to a specific target number.
 * Difficulty：Easy
 * Classification：Array, Two points, Binary Search
 */

/*
 * Solution 1
 * 2019-07-15  Runtime: 2 ms
 * Algorithm: => Hash Map, same as Two Sum
 * Time Complexity: O(n), Space Conplexity: O(n)
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int res = target - numbers[i];
            if (map.containsKey(res)) {
                return new int[] {map.get(res) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        throw new IllegalArgumentException();
    }
}
