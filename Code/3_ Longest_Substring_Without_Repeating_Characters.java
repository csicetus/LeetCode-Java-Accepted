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
