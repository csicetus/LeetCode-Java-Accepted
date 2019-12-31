////////// sol 1 Recursion

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            String str = wordDict.get(i);
            for (int j = 0; j < str.length(); j++) {
                set.add(str.charAt(j));
            }
        }
        
        // check whether each letter of s exists in the set
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                return false;
            }
        }
        
        return wordBreakHelper(s, wordDict, "", new HashMap<String, Boolean>());
    }
    
    private boolean wordBreakHelper(String s, List<String> wordDict, String temp, HashMap<String, Boolean> map) {
        if (temp.length() > s.length()) return false;
        
        for (int j = 0; j < temp.length(); j++) {
            if (temp.charAt(j) != s.charAt(j)) {
                return false;
            }
        }
        
        if (map.containsKey(temp)) {
            return map.get(temp);
        }
        if (s.length() == temp.length()) {
            if (s.equals(temp)) return true;
            return false;
        }
        
        
        for (int i = 0; i < wordDict.size(); i++) {
            if (wordBreakHelper(s, wordDict, temp + wordDict.get(i), map)) {
                map.put(temp, true);
                return true;
            }
        }
        map.put(temp, false);
        return false;
    }
}


////////// sol 2 D&C

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        // get each word from wordDict to set
        for (int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
        }
        return wordBreakHelper(s, set, new HashMap<String, Boolean>());
    }
    
    private boolean wordBreakHelper(String s, HashSet<String> set, HashMap<String, Boolean> map) {
        if (s.length() == 0) {
            return true;
        }
        
        if (map.containsKey(s)) {
            return map.get(s);
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.substring(i, s.length())) && wordBreakHelper(s.substring(0, i), set, map)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}


////////// sol 3 DP

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        // get each word from wordDict to set
        for (int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
        }
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[j] && set.contains(s.substring(j, i));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
