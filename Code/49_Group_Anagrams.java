/*
 * 49. Group Anagrams
 * Target: Given an array of strings, group anagrams together.
 * Difficulty：Medium
 * Classification：Hash Table, String
 */
 
/*
 * Solution 1
 * 2019-06-23  Runtime: 9 ms
 * Algorithm: => Use Hashmap and sort the string.
 * Time complexity: O(n*K*logK). Space complexity: O(n*K).  K is the length of string.
 */
 
 class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            }
            else {
                List<String> tmp = new ArrayList<>();
                tmp.add(s);
                map.put(key, tmp);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}


/*
 * Solution 2
 * 2019-06-15  Runtime: 322 ms
 * Algorithm: => Compare one by one.
 * Time complexity: O(k*n). Space complexity: O(1).
 */
