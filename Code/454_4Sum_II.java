/*
 * 454. 4Sum II
 * Target: Given four lists A, B, C, D of integer values, 
 *         compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 *         To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
 *         All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 * Difficulty：Easy
 * Classification：Hash Table, Binary Search
 */

/*
 * Solution 1
 * 2019-09-02  Runtime: 81 ms
 * Algorithm: => HashTable. Transfer the question to two 2SUM question, which means we should separately count the sum of A, B and C, D.
 * Time Complexity: O(n^2), n in this piece of code is a 32-bit integer. Space Conplexity: O(n)
 */
 
 class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0, len = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sumAB = A[i] + B[j];
                map.put(sumAB, map.getOrDefault(sumAB, 0) + 1);
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sumCD = C[i] + D[j];
                if (map.containsKey(-sumCD)) {
                    res += map.get(-sumCD);
                }
            }
        }
        return res;
    }
}

 
