////////// sol 1: Boyer-Moore Majority vote algorithm 

// Time: O(n); Space: O(1)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        int minTimes = nums.length / 3;
        // majority elem should appear more than n / 3
        // so there're max two return elems.
        int candidate1 = nums[0], candidate2 = nums[0];
        int count1 = 0, count2 = 0;
        for (int n : nums) {
            if (n == candidate1) {
                count1++;
            } else if (n == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = n;
                count1++;
            } else if (count2 == 0) {
                candidate2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        for (int n : nums) {
            if (n == candidate1) {
                count1++;
            } 
            if (n == candidate2) {
                count2++;
            }
        }
        
        if (count1 > minTimes) {
            res.add(candidate1);
        } 
        if (count2 > minTimes && candidate1 != candidate2) {
            res.add(candidate2);
        }
        return res;
    }
}
