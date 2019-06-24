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
 * 2019-06-23  Runtime: 7 ms
 * Algorithm: => Arrange key as factors of prime numbers.
 * Time complexity: O(k*n). Space complexity: O(1).
 * Note: The basic theorem of arithmeti => each natural number greater than 1, either itself is a prime number, 
 *       or can be written as a product of more than two prime numbers, and after these quality factors are arranged by size, 
 *       there is only one way to write.
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        
        int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };
        for (String s : strs) {
            int key = 1;
            char[] ch = s.toCharArray();
            for (char sc : ch) {
                key *= prime[sc - 'a'];
            }
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
