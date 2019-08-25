/*
 * 387. First Unique Character in a String
 * Target: Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *         You may assume the string contain only lowercase letters.
 * Difficulty：Easy
 * Classification：HashTable, String
 */

/*
 * Solution 1
 * 2019-08-25  Runtime: 55 ms
 * Algorithm: => HashMap stores the numbers.
 * Time Complexity: O(n). Space Conplexity: Constant O(26) ~ O(1) for any length of string
 */
 
 class Solution {
    public int firstUniqChar(String s) {
        if (s.length() == 1) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            } 
        }
        return -1;
    }
}


/*
 * Solution 2
 * 2019-08-25  Runtime: 59 ms
 * Algorithm: => Two HashMap, one stores the numbers, the other stores the index.
 * Time Complexity: O(n). Space Conplexity: Constant O(26) ~ O(1) for any length of string
 */
 

class Solution {
    public int firstUniqChar(String s) {
        if (s.length() == 1) return 0;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> idx = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            idx.put(s.charAt(i), i);
        }
        int res = Integer.MAX_VALUE;
        for (char c : map.keySet()) {
            if (map.get(c) == 1) {
                res = Math.min(res, idx.get(c));
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}


/*
 * Solution 3
 * 2019-08-25  Runtime: 7 ms
 * Algorithm: => Two pointers, fast and slow. Same direction.
 * Time Complexity: ?. Space Conplexity: O(n)
 */
 
class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        if (s.length() == 1) return 0;
        char[] c = s.toCharArray();
        int[] count = new int[256];
        int n = c.length;
        int slow = 0, fast = 0;
        while (fast < n) {
            count[c[fast]]++;
            while (slow < n && count[c[slow]] > 1) slow++;
            if (slow == n) return -1;
            fast++;
        }
        return slow;
    }
}
