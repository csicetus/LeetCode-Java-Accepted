/*
 * 17. Letter Combinations of a Phone Number solution 2
 * Target: Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Difficulty：Medium
 * Classification：String, Backtracking
 */

/*
 * Solution 1
 * 2019-06-08  Runtime: 0 ms
 * Algorithm: => Recursive
 *               If digits == "23", 
 *               first layer recursive: combination("a", "23", 1, ""), combination("b", "23", 1, ""), combination("c", "23", 1, "");
 *               Start with 'a', then recursively to 'd' , then 'g' , add "adg", then add "adh", then add "adi" ... from left to right, 
 *               recursively after it is added.
 */

class Solution {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", 
                                     "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()){
            return new ArrayList<String>();
        }
        List<String> res = new LinkedList<>();
        combination("", digits, 0, res);
        return res;
    }
    
    private void combination(String prefix, String digits, int offset, List<String> res) {
        if (offset == digits.length()){
            res.add(prefix);
            return;
        }
        String letters = KEYS[digits.charAt(offset) - '0'];
        for (int i = 0; i < letters.length(); i++){
            combination(prefix + letters.charAt(i), digits, offset + 1, res);
        }
    }
}


/*
 * Solution 2
 * 2019-06-08  Runtime: 0 ms
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
 
