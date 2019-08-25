/*
 * 350. Intersection of Two Arrays II
 * Target: Given two arrays, write a function to compute their intersection.
 *         Each element in the result should appear as many times as it shows in both arrays.
 *         The result can be in any order.
 * Difficulty：Easy
 * Classification：HashTable, Two pointers, Binary Search, Sort
 */

/*
 * Solution 1
 * 2019-08-24  Runtime: 2 ms
 * Algorithm: => HashMap stores the numbers.
 * Time Complexity: O(n+m)?. Space Conplexity: O(n)
 */
 
 class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n1 : nums1) {
            map.put(n1, map.getOrDefault(n1, 0) + 1);
        }
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int n2 : nums2) {
            if (map.get(n2) != null && map.get(n2) > 0) {
                tmp.add(n2);
                map.put(n2, map.get(n2) - 1);
            }
        }
        int[] res = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }
}


/*
 * Solution 2 Follow Up: Sorted arrays
 * 2019-08-24  Runtime: 2 ms
 * Algorithm: => Two pointers. i points to nums1, j points to nums2.
 * Time Complexity: O(max(n, m)). Space Conplexity: O(n)
 */
 
 class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> tmp = new ArrayList<>();
        int i = 0, j = 0, m = nums1.length, n = nums2.length;
        while (i < m && j < n) {
            int n1 = nums1[i];
            int n2 = nums2[j];
            if (n1 == n2) {
                tmp.add(n1);
                i++;
                j++;
            } else if (n1 < n2) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[tmp.size()];
        for (int k = 0; k < tmp.size(); k++) {
            res[k] = tmp.get(k);
        }
        return res;
    }
}


/*
 * Solution 3 Follow Up: What if nums1's size is small compared to nums2's size?
 * 2019-08-24  Runtime: ? ms
 * Algorithm: => Two pointers is best.
 *               https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/282372/Java-solution-with-all-3-follow-up-questions
 */
 
 
/*
 * Solution 4 Follow Up: What if elements of nums2 are stored on disk, 
 *                       and the memory is limited such that you cannot load all elements into the memory at once?
 * 2019-08-24  Runtime: ? ms
 * Algorithm: => https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/282372/Java-solution-with-all-3-follow-up-questions
 *               https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/82243/Solution-to-3rd-follow-up-question
 */
