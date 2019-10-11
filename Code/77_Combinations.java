/*
 * 77. Combinations
 * Target: Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * Difficulty：Medium
 * Classification：Backtracking
 */

/*
 * Solution 1
 * 2019-10-11  Runtime: 2 ms
 * Algorithm: => Backtracking. 
 * Time Complexity: ?, Space Conplexity: O(1)
 */
 
 class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtracking(1, n, k, list, res);
        return res;
    }
    
    private void backtracking(int start, int n, int k, List<Integer> list, List<List<Integer>> res)
    {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        // x = k - list.size() is the number we need, from i to n there're n - i + 1 numbers, which should more than or equal to x.
        // so we have k - list.size() <= n - i + 1 => i <= n + 1 - (k - list.size())
        for (int i = start; i <= n + 1 - (k - list.size()); i++) {
            list.add(i);
            backtracking(i + 1, n , k, list, res);
            list.remove(list.size() - 1);
        }
    }
}


/*
 * Solution 2
 * 2019-10-11  Runtime: 28 ms
 * Algorithm: => Iteration. 
 * Time Complexity: ?, Space Conplexity: O(1)
 */
 
 class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(0);
        }
        int layer = 0;
        while (layer >= 0) {
            /*System.out.println("The layer: "+layer);*/
            
            // current position's num + 1
            list.set(layer, list.get(layer) + 1);
            // if current num > n, backtracking layer == n + 1
            if (list.get(layer) > n) {
                /*System.out.println(layer);*/
                // back to previous layer
                layer--;
            // reach k nums, add to result
            } else if (layer == k - 1) {
                /*System.out.println(list);*/
                res.add(new ArrayList<>(list));
            // update next num, to next layer
            } else {
                layer++;
                // set next num as last num
                list.set(layer, list.get(layer - 1));
            }
        }
        return res;
    }
}
 

/*
 * Solution 3
 * 2019-10-11  Runtime: 7 ms
 * Algorithm: => Iteration. Find results that length is 1. Then add other possible nums after orginal lists.
 * Time Complexity: ?, Space Conplexity: O(1)
 */

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> res = new ArrayList<>();
        // results that length is 1.
        for (int i = 1; i <= n + 1 - k; i++) {
            res.add(Arrays.asList(i));
        }
        
        // add other possible nums
        // i stands for list length
        for (int i = 2; i <= k; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            /*System.out.println(i);*/
            for (List<Integer> list : res) {
                for (int j = list.get(list.size() - 1) + 1; j <= n + 1 - (k - (i - 1)); j++) {
                    // read the original list and add new possible num j
                    List<Integer> tmp = new ArrayList<>(list);
                    tmp.add(j);
                    /*System.out.println(tmp);*/
                    // add new list to temp result
                    temp.add(tmp);
                }
            }
            // update result, for example, update [1] to [1, 2] for future add 3 => [1,2,3]
            res = temp;
        }
        return res;
    }
}


/*
 * Solution 4
 * 2019-10-11  Runtime: 50 ms
 * Algorithm: => Recusion. C(k, n) = C(k - 1, n - 1) + C(k, n - 1)
 *               For num n, if it is selected, then we need find k - 1 nums in n - 1. If not, then we need find k nums in n - 1.
 * Time Complexity: ?, Space Conplexity: O(1)
 */


class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (k == 0 || n == k) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= k; i++) {
                list.add(i);
            }
            return new ArrayList<>(Arrays.asList(list));
        }
        List<List<Integer>> res = combine(n - 1, k - 1);
        
        res.forEach(e -> e.add(n));
        res.addAll(combine(n - 1, k));
        
        return res;
    }
}


/*
 * Solution 5
 * 2019-10-11  Runtime: 85 ms
 * Algorithm: => DP. Change sol 4 recursion to DP
 *               For num n, if it is selected, then we need find k - 1 nums in n - 1. If not, then we need find k nums in n - 1.
 * Time Complexity: ?, Space Conplexity: O(1)
 */

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> dp[][] = new List[n + 1][k + 1];
        // if k == 0, return empty list
        for (int m = 0; m <= n; m++) {
            dp[m][0] = new ArrayList<>();
            dp[m][0].add(new ArrayList<Integer>());
        }
        // row from 1 to n
        for (int i = 1; i <= n; i++) {
            // col from 1 to k and col <= row
            for (int j = 1; j <= i && j <= k; j++) {
                dp[i][j] = new ArrayList<>();
                // if we didn't select i, then need to select total j nums.
                // if we can select j nums from i - 1
                // so we have j <= i - 1 => j < i
                if (j < i) {
                    dp[i][j].addAll(dp[i - 1][j]);
                }
                // if we select i,
                // then select j - 1 nums from i - 1
                for (List<Integer> list : dp[i - 1][j - 1]) {
                    // obtain the result of selecting j - 1 nums from i - 1
                    // then fro each result add i because we selected i
                    List<Integer> tmp = new ArrayList<>(list);
                    tmp.add(i);
                    // add updated result to dp[i][j]
                    dp[i][j].add(tmp);
                }
            }
        }
        return dp[n][k];
    }
}


/*
 * Solution 6
 * 2019-10-11  Runtime: 85 ms
 * Algorithm: => Optimal sol 5. DP. Change sol 5 DP[i][j] to DP[j], because when update dp[i][*], we only need the previous dp[i - 1][*]
 *               For num n, if it is selected, then we need find k - 1 nums in n - 1. If not, then we need find k nums in n - 1.
 * Time Complexity: ?, Space Conplexity: O(1)
 */

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>[] dp = new List[k + 1];
        // if k == 0, return empty list
        dp[0] = new ArrayList<>();
        dp[0].add(new ArrayList<Integer>());
        // row from 1 to n
        for (int i = 1; i <= n; i++) {
            // col from 1 to k and col <= row
            List<List<Integer>> temp = new ArrayList<>(dp[0]);
            for (int j = 1; j <= i && j <= k; j++) {
                List<List<Integer>> previous = temp;
                if (dp[j] != null) {
                    temp = new ArrayList<>(dp[j]);
                }
                // if we didn't select i, then need to select total j nums.
                // if we can select j nums from i - 1
                // so we have j <= i - 1 => j < i
                // if i <= j, we set dp[j] empty
                if (i <= j) {
                    dp[j] = new ArrayList<>();
                }
                // if we select i,
                // then select j - 1 nums from i - 1
                for (List<Integer> list : previous) {
                    // obtain the result of selecting j - 1 nums from i - 1
                    // then fro each result add i because we selected i
                    List<Integer> tmp = new ArrayList<>(list);
                    tmp.add(i);
                    // add updated result to dp[j]
                    dp[j].add(tmp);
                }
            }
        }
        return dp[k];
    }
}
