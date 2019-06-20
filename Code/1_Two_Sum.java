/*
 * 1. Two Sum
 * 2019-05-30  Runtime: 2 ms
 * Target:  Return the index in the array and the given number
 * Difficulty：Easy
 * Classification：Array, HashTable
 * Algorithm: The title shows that there must be a unique solution in the array, 
 *            so we can use the hash table to record the elements that have been traversed.
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int res = target - nums[i];
            if(map.containsKey(res)){
                return new int[]{map.get(res), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }
}
