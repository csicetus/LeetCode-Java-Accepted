////////// sol 1: backtrack

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) return res;
        backtrack(s, res, new ArrayList<String>(), 0);
        return res;
    }
    
    private void backtrack(String s, List<List<String>> res, List<String> tempList, int start) {
        if (s.length() == start) {
            res.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    tempList.add(s.substring(start, i + 1));
                    backtrack(s, res, tempList, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
    
    private boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
