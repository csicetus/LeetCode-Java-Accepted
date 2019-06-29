/*
 * 78. Subsets
 * Target: Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Difficulty：Medium
 * Classification：String, Backtracking
 */

/*
 * Solution 1
 * 2019-06-28  Runtime: 1 ms
 * Algorithm: => Iteration. The first loop, subarray length from 1 to n;
 *               The second loop, traversing all previous results;
 *               The third loop, expanding each result.
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> tmpRes = new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        tmpRes.add(new ArrayList<Integer>());
        res.add(new ArrayList<Integer>());
        for (int i = 1; i <= nums.length; i++) {
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            for (List<Integer> list : tmpRes) {
                for (int j = 0; j < nums.length; j++) {
                    // Add numbers larger than the last digit to prevent duplication
                    if (list.size() > 0 && list.get(list.size() - 1) >= nums[j]) {  
                        continue; 
                    }
                    List<Integer> newList = new ArrayList<Integer>(list);
                    newList.add(nums[j]);
                    tmp.add(newList);
                    res.add(newList);
                }
            }
            
            tmpRes = tmp;
        }
        return res;
    }
}


/*
 * Solution 2
 * 2019-06-28  Runtime: 1 ms
 * Algorithm: => Iteration (optimal solution 1)
 */
 
 class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tmpRes = new ArrayList<List<Integer>>();
            for (List<Integer> list : res) {
                List<Integer> tmp = new ArrayList<Integer>(list);
                tmp.add(nums[i]);
                tmpRes.add(tmp);
            }
            
            res.addAll(tmpRes);
        }
        return res;
    }
}


/*
 * Solution 3
 * 2019-06-28  Runtime: 1 ms
 * Algorithm: => Backtracking
 */
 
 
