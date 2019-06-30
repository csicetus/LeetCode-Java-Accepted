/*
 * 96. Unique Binary Search Trees
 * Target: Given n, find the number of structurally unique BST's (binary search trees) that store values 1 ... n.
 * Difficulty：Medium
 * Classification：DP, Tree
 */
 
/*
 * Solution 1
 * 2019-06-29  Runtime: 2 ms
 * Algorithm: => Recursion with Memoization.
 * Time complexity: ? , Space complexity: ?
 */
 
class Solution {
    Map<Integer, Map<Integer, Integer>> dp;
    public int numTrees(int n) {
        dp = new HashMap();
        int[] store = new int[n];
        for(int i = 0; i < n; i++){
            store[i] = i + 1;
        }
        return getTrees(0, store, 0, n-1);
    }
    
    private int getTrees(int index, int[] store, int start, int end) {
        if(dp.containsKey(start) && dp.get(start).containsKey(end)) {
            return dp.get(start).get(end);
        }
        if(index == store.length) {
            return 1;
        }
        if(start > end){
            return 0;
        }
        int count = 0;
        for(int i = start; i <= end && start <= end; i++) {

            int l = getTrees(index + 1, store, start, i - 1);
            int r = getTrees(index + 1, store, i + 1, end);
            if(l == 0 || r == 0) {
                l = Math.max(l, 1);
                r = Math.max(r, 1);
            } 
            count += (l * r);
        }
        Map<Integer, Integer> endToC = dp.getOrDefault(start, new HashMap());
        endToC.put(end, count);
        dp.put(start, endToC);
            
        return count;
    }
}


/*
 * Solution 2
 * 2019-06-29  Runtime: 0 ms
 * Algorithm: => DP.
 * Time complexity: ? , Space complexity: ?
 */

 class Solution {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = G[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
 

/*
 * Solution 3
 * 2019-06-10  Runtime: 0 ms
 * Algorithm: => Cantalan tree
 * Time complexity: ?, Space complexity: ?
 */

class Solution {
    public int numTrees(int n) {
        //cantalan树
        //C(2n,n)/(n+1)
        
        // long long res = 1, i;
        // for (i = 1; i <= n; i++) {
        //     res *= (i + n) / i;
        // }
        // return (int)(res / i);
        
        long ans =1;
        for(int i=n+1;i<=2*n;i++){
            ans = ans*i/(i-n);
        }
        return (int)(ans/(n+1));
    }
}
