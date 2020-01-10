///////////// sol 1: Hash map

// Time: O(n); Space: O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) return 0;
        // HashMap<sum[0, i], freq>
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // sum[0, i - 1] = sum[0, j] - sum[i, j]
        // map.key = sum - k
        int sum = 0, count = 0;
        map.put(0, 1);
        for (int curr : nums) {
            sum += curr;
            if (map.containsKey(sum - k)) {      
                count += map.get(sum - k);
            }       
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
