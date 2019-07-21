/*
 * 60. Permutation Sequence
 * Target: Given n and k, return the kth permutation sequence.
 * Difficulty：Medium
 * Classification：Math, Backtracking
 */
 
/*
 * Solution 1
 * 2019-07-20  Runtime: 1 ms
 * Algorithm: => Math. Using groups.
 */
 
 class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> nums = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i + 1);
            if (i != 0) {
                fact *= i;
            }
        }
        k -= 1;
        fact *= n;
        StringBuilder res = new StringBuilder();
        for (int i = n; i > 0; i--) {
            fact /= nums.size();
            int index = k / fact;
            int num = nums.get(index);
            nums.remove(index);
            k %= fact;
            res.append(num);
        }
        return res.toString();
    }
}
