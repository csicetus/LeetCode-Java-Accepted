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


/*
 * Solution 2
 * 2019-07-15  Runtime: 0 ms
 * Algorithm: => Two pointers with reverse direction. 
 *               As it is a sorted array. We can regard it as a sorted 2D matrix.
 * Time Complexity: O(n), Space Conplexity: O(1)
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) return new int[2];
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                break;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[] {l + 1, r + 1};
    }
}
