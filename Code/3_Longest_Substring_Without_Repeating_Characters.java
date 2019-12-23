/*
 * 3. Longest Substring Without Repeating Characters
 * 2019-05-31  Runtime: 8 ms
 * Target: Find the length of the longest substring without repeating characters.
 * Difficulty：Medium
 * Classification：Hash Table, Two Pointers, String
 * Algorithm: A pointer as substring start, use the hash table to record the elements that have been traversed. 
 *            If repeatable, reset start pointer. If not, refresh max length of substring.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i)) && start <= map.get(s.charAt(i))){           
                start = map.get(s.charAt(i)) + 1;
            }
            else{
                maxLen = Math.max(maxLen, i - start + 1);
            }
            map.put(s.charAt(i), i);
        }
        return maxLen;
    }
}

////////// sol 2: Hash set

// Time: O(n); Space: O(min(m, n)), n is the length of set
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int res = 0, i = 0, j = 0;
        while (i < len && j < len) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                res = Math.max(res, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }
}


////////// sol 3: str[]

// Time: O(n); Space: O(m), m is the length of str[]
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int str[] = new int[128];
        int res = 0, i = 0, j = 0;
        for (; j < len; j++) {
            i = Math.max(str[s.charAt(j)], i); 
            // the position of i should set
            str[s.charAt(j)] = j + 1;
            res = Math.max(res, j + 1 - i);
        }
        return res;
    }
}
