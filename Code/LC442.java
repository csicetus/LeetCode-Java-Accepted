////////// sol 1: use the way setting num negative as boolean

// Time: O(n); Space: O(1)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            // duplicate num has same index
            int index = Math.abs(nums[i]) - 1;
            // System.out.println("index: "+index);
            // System.out.println("num[index]: "+nums[index]);
            if (nums[index] < 0) {
                //System.out.println("index in res: "+index);
                res.add(Math.abs(index + 1));
            }
            nums[index] = -nums[index];
            
            // for (int n : nums) {
            //     System.out.print(n + " ");
            // }
            // System.out.println("");
            // for (int r : res) {
            //     System.out.print("res "+r + " ");
            // }
            // System.out.println("");
        }
        return res;
    }
}
