/*
 * 438. Find All Anagrams in a String
 * Target: Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *         Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100. 
 *         The order of output does not matter.
 * Difficulty：Medium
 * Classification：HashTable
 */

/*
 * Solution 1
 * 2019-07-31  Runtime: 759 ms
 * Algorithm: => brute force.
 * Time Complexity: ?. Space Conplexity: O(1)
 */
 
 class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<Integer>();
        if (s == null || s.length() == 0) return res;
        if (s.length() < p.length()) return res;
        int m = s.length(), n = p.length();
        for (int i = 0; i < m - n + 1; i++) {
            String sub = s.substring(i, i + n);
            if (isMatch(sub, p)) res.add(i);
        }
        return res;
    }
    
    private boolean isMatch(String x, String y) {
        if (x == null || y == null) return false;
        if (x.length() != y.length()) return false;
        int[] dict = new int[26];
        for (int i = 0; i < x.length(); i++) {
            char c1 = x.charAt(i);
            dict[c1 - 'a']++; 
        }
        for (int i = 0; i < y.length(); i++) {
            char c2 = y.charAt(i);
            dict[c2 - 'a']--;
            if (dict[c2 - 'a'] < 0) return false;
        }
        return true;
    }
}


/*
 * Solution 2
 * 2019-07-31  Runtime: 27 ms
 * Algorithm: => Sliding Window and HashTable.
 * Time Complexity: ?. Space Conplexity: O(1)
 */
 
 class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<Integer>();
        if (s == null || s.length() == 0) return res;
        if (s.length() < p.length()) return res;
        Map<Character, Integer> map = new HashMap<>();
        int match = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    match++;
                }
            }
            if (i >= p.length()) {
                c = s.charAt(i - p.length());
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) == 1) {
                        match--;
                    }
                }
            }
            if (match == map.size()) {
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
}


/*
 * Solution 3
 * 2019-07-31  Runtime: 27 ms
 * Algorithm: => Sliding Window and HashTable. Same as sol 2.
 * Time Complexity: ?. Space Conplexity: O(1)
 */
 
 class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<Integer>();
        if (s == null || s.length() == 0) return res;
        if (s.length() < p.length()) return res;
        Map<Character, Integer> map = new HashMap<>();       
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int start = 0, end = 0, len = Integer.MAX_VALUE, cnt = map.size();
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    cnt--;
                }
            }
            end++;
            
            while (cnt == 0) {
                char tmpc = s.charAt(start);
                if (map.containsKey(tmpc)) {
                    map.put(tmpc, map.get(tmpc) + 1);
                    if (map.get(tmpc) == 1) {
                        cnt++;
                    }
                }
                if (end - start == p.length()) {
                    res.add(start);
                }
                start++;
            }
        }
        return res;
    }
}
