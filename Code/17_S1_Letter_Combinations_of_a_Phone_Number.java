/*
 * 17. Letter Combinations of a Phone Number solution 1
 * 2019-06-08  Runtime: 0 ms
 * Target: Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Difficulty：Medium
 * Classification：String, Backtracking
 * Algorithm: => Queue iteration
 *               If digits == "236", first loop: res = [a, b, c], second loop: res = [b, c, ad, af, ae]...
 *               Until i == 2, res = [ad, ae, af, bd, be, bf, cd, ce, cf]
 */

class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if(digits.isEmpty()) return res;
        String[] letters = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        res.add("");
        for (int i = 0; i < digits.length(); i++){
            int j = Character.getNumericValue(digits.charAt(i));
            while (res.peek().length() == i){
                String first = res.remove();
                for (char ch : letters[j].toCharArray()){
                    res.add(first + ch);
                }
            }
        }
        return res;
    }
}
