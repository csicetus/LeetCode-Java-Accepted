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
 * 2019-06-28  Runtime: 0 ms
 * Algorithm: => Backtracking
 */
 
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtracking(nums, 0, new ArrayList<>(), res);
        return res;
    }
    
    public void backtracking(int[] nums, int start, ArrayList<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtracking(nums, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}


/*
 * Solution 4
 * 2019-06-28  Runtime: 1 ms
 * Algorithm: => Bits
 */
 
 class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int groups = 1 << nums.length;  // exists 2^nums.length groups
        for (int i = 0; i < groups; i++) {
            List<Integer> tmp = new ArrayList<>();
            int count = 0;  // corresponse to nums[count]
            int i_copy = i;  // aimed for moving bits. 
            while (i_copy != 0) {
                if ((i_copy & 1) == 1) {    // check if it is 1
                    tmp.add(nums[count]);
                }
                count++;
                i_copy = i_copy >> 1;
            }
            res.add(tmp);
        }
        return res;
    }
}
