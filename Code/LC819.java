////////// sol 1

// Time: O(m + n); Space: O(m + n). m is size of paragraph, n is size of banned
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // set lower case and split string
        String[] newParag = paragraph.toLowerCase().split("\\W+");
        
        // store banned to hash set
        Set<String> set = new HashSet<>();
        for (String b : banned) {
            set.add(b);
        }
        
        // store newParag to hash map (not in set)
        HashMap<String, Integer> map = new HashMap<>();
        for (String p : newParag) {
            if (!set.contains(p)) {
                map.put(p, map.getOrDefault(p, 0) + 1);
            }
        }
        
        // find most common
        int maxN = 0;
        String res = "";
        for (String st : map.keySet()) {
            if (map.get(st) > maxN) {
                maxN = map.get(st);
                res = st;
            }
        }
        return res;
    }
}
