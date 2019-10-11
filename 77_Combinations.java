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
 * 2019-10-11  Runtime: 2 ms
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
 
