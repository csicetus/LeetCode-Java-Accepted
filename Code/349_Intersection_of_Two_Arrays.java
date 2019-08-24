/*
 * 349. Intersection of Two Arrays
 * Target: Given two arrays, write a function to compute their intersection.
 *         Each element in the result must be unique.
 *         The result can be in any order.
 * Difficulty：Easy
 * Classification：HashTable, Two pointers, Binary Search, Sort
 */

/*
 * Solution 1
 * 2019-08-24  Runtime: 3 ms
 * Algorithm: => Use two HashSet contains unique numbers from nums1 and nums2, then compare and select same one.
 *               Note that that may appear the same number twice or many times so use another HashSet to record.
 * Time Complexity: O(n+m), where n and m are arrays' lengths. Space Conplexity: O(m+n) is worst.
 */
 
 class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> t1 = new HashSet<>();
        Set<Integer> t2 = new HashSet<>();
        Set<Integer> t = new HashSet<>();
        for (int n1 : nums1) {
            if (!t1.contains(n1)) {
                t1.add(n1);
            }
        }
        for (int n2 : nums2) {
            if (!t2.contains(n2)) {
                t2.add(n2);
            }
        }
        int idx = 0;
        int[] res = new int[Math.max(nums1.length, nums2.length)];
        for (int n1 : nums1) {
            if (t2.contains(n1) && !t.contains(n1)) {
                res[idx++] = n1;
                t.add(n1);
            }
        }
        return Arrays.copyOf(res, idx);
    }
}


/*
 * Solution 2
 * 2019-08-24  Runtime: 3 ms
 * Algorithm: => Use two HashSet contains unique numbers from nums1 and nums2, then take their intersection.
 *               Note that a.retainAll(b) function is aimed to take intersection of a and b.
 * Time Complexity: O(n+m), where n and m are arrays' lengths. Space Conplexity: O(m+n) is worst.
 */
 
 class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for (int n1 : nums1) {
            if (!s1.contains(n1)) {
                s1.add(n1);
            }
        }
        for (int n2 : nums2) {
            if (!s2.contains(n2)) {
                s2.add(n2);
            }
        }
        s1.retainAll(s2);
        int idx = 0;
        int[] res = new int[s1.size()];
        for (int n1 : s1) {
            res[idx++] = n1;
        }
        return res;
    }
}
 
