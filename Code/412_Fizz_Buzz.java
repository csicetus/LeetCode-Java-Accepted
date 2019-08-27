/*
 * 412. Fizz Buzz
 * Target: Given an integer n, return the number of trailing zeroes in n!.
 *         Note: Your solution should be in logarithmic time complexity.
 * Difficulty：Easy
 * Classification：Math
 */

/*
 * Solution 1
 * 2019-08-26  Runtime: 1 ms
 * Algorithm: => Math.
 * Time Complexity: O(n). Space Conplexity: O(1)
 */

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(Integer.toString(i));
            }
        }
        return res;
    }
}


/*
 * Solution 2
 * 2019-08-26  Runtime: 2 ms
 * Algorithm: => Math. Cut the i % 3 == 0 && i % 5 == 0 condition.
 * Time Complexity: O(n). Space Conplexity: O(1)
 */

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String cur = "";
            if (i % 3 == 0) {
                cur += "Fizz";
            } 
            if (i % 5 == 0) {
                cur += "Buzz";
            } 
            if (cur == "") {
                cur += Integer.toString(i);
            }
            res.add(cur);
        }
        return res;
    }
}


/*
 * Solution 3
 * 2019-08-26  Runtime: 1 ms
 * Algorithm: => HashTable
 * Time Complexity: O(n). Space Conplexity: O(1)
 */
 
 class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        map.put(3, "Fizz");
        map.put(5, "Buzz");
        for (int i = 1; i <= n; i++) {
            String cur = "";
            for (Integer key : map.keySet()) {
                if (i % key == 0) {
                    cur += map.get(key);
                }
            }
            if (cur == "") {
                cur += Integer.toString(i);
            }
            res.add(cur);
        }
        return res;
    }
}
