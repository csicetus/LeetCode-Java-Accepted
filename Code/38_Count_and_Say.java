/*
 * 38. Count and Say
 * Target: Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * Difficulty：Easy
 * Classification：String
 */

/*
 * Solution 1
 * 2019-07-22  Runtime: 1 ms
 * Algorithm: => Recursion
 * Time Complexity: ?. Space Conplexity: O(1)
 */

class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String pre = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < pre.length()) {
            char cur = pre.charAt(i);
            int j = 0;
            while (i + j < pre.length() && pre.charAt(i + j) == cur) {
                j++;

            }
            res.append(j);
            res.append(cur);
            i += j;
        }
        return res.toString();
    }
}



/*
 * Solution 2
 * 2019-07-22  Runtime: 8 ms
 * Algorithm: => Iteration
 * Time Complexity: ?. Space Conplexity: O(1)
 */

class Solution {
    public String countAndSay(int n) {
        String res = "1";
        while (n > 1) {
            String tmp = "";
            for (int i = 0; i < res.length(); i++) {
                int num = countRepeatNum(res.substring(i));
                tmp = tmp + num + "" + res.charAt(i);
                i = i + num - 1;
            }
            n--;
            res = tmp;
        }
        return res;
    }
    
    private int countRepeatNum(String str) {
        int cnt = 1;
        char first = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (first == str.charAt(i)) {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }
}
