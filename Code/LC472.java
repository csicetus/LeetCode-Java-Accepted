// Time: O(n^3); Space: O(n^3)
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<String>();
        Set<String> set = new HashSet<String>(Arrays.asList(words));
        for (String s : words) {
            set.remove(s);
            if (dfs(s, set, "")) res.add(s);
            set.add(s);
        }
        return res;
    }
    
    private boolean dfs(String word, Set<String> set, String pre) {
        if (!pre.equals("")) set.add(pre);
        if (set.contains(word)) return true;
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String rest = word.substring(i, word.length());
            if (set.contains(prefix) && dfs(rest, set, pre + prefix)) {
                return true;   
            }
        }
        return false;
    }
}
