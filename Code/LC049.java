/////////////// sol 1: hash map

// Time: O(nk); Space: O(nk)
// n is the length of strs, k is the maximum length of string in strs.
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> map = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            // count num of char of each string
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            
            // turn count num to string builder
            // the num divide by #
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }
            
            // add string to map
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
