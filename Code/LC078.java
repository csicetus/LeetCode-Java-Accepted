////////// sol 1: backtrack 1

// Time: O(n*2^n); Space: O(2^n)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            backtrack(0, new  ArrayList<>(), result, nums, i);
        }
        return result;
    }
    
    private void backtrack(int first, List<Integer> tempList, List<List<Integer>> res, int[] nums, int k) {
        if (tempList.size() == k) {
            res.add(new ArrayList(tempList));
        }
        for (int i = first; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(i + 1, tempList, res, nums, k);
            tempList.remove(tempList.size() - 1);
        }
    }
}

///////// sol 2: backtrack 2 (remember)

// Time: O(n*2^n); Space: O(2^n)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, new ArrayList<>(), result, nums);
        return result;
    }
    
    private void backtrack(int first, List<Integer> tempList, List<List<Integer>> res, int[] nums) {
        res.add(new ArrayList(tempList));
        for (int i = first; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(i + 1, tempList, res, nums);
            tempList.remove(tempList.size() - 1);
        }
    }
}


//////// sol 3: binary sorted, bit manipulation

// Time: O(n*2^n); Space: O(2^n)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;        
        for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); i++) {
            // set bitmask, from 00..00 to 11..11
            String bitmask = Integer.toBinaryString(i).substring(1);
            
            // add subset if bitmask is corresponding to 1
            List<Integer> templist = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (bitmask.charAt(j) == '1') templist.add(nums[j]);
            }
            result.add(templist);
        }
        return result;
    }
}

