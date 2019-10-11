/*
 * 91. Decode Ways
 * Target: A message containing letters from A-Z is being encoded to numbers using the following mapping: 'A' -> 1, 'B' -> 2 ...'Z' -> 26
 *         Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * Difficulty：Medium
 * Classification：String, DP
 */

/*
 * Solution 1
 * 2019-10-11  Runtime: 492 ms
 * Algorithm: => Recursion. Divide problem. 
 * Time Complexity: ?, Space Conplexity: O(1)
 */
 
 class Solution {
    public int numDecodings(String s) {
        return decodingsRecursion(s, 0);
    }
    
    private int decodingsRecursion(String s, int start) {
        int res1 = 0, res2 = 0;
        if (start == s.length()) {
            return 1;
        }
        if (s.charAt(start) == '0') {
            return 0;
        }
        res1 = decodingsRecursion(s, start + 1);
        if (start < s.length() - 1) {
            int tenDigit = s.charAt(start) - '0';
            int singleDigit = s.charAt(start + 1) - '0';
            if (tenDigit * 10 + singleDigit <= 26) {
                res2 = decodingsRecursion(s, start + 2);
            }
        }
        return res1 + res2;
    }
}


/*
 * Solution 2
 * 2019-10-11  Runtime: 2 ms
 * Algorithm: => Recursion and memoization. Divide problem. Store res to HashMap.
 * Time Complexity: ?, Space Conplexity: O(1)
 */
 
 class Solution {
    public int numDecodings(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return decodingsRecursion(s, 0, map);
    }
    
    private int decodingsRecursion(String s, int start, HashMap<Integer, Integer> map) {
        int res1 = 0, res2 = 0;
        if (start == s.length()) {
            return 1;
        }
        if (s.charAt(start) == '0') {
            return 0;
        }
        int m = map.getOrDefault(start, -1);
        if (m != -1) {
            return m;
        }
        res1 = decodingsRecursion(s, start + 1, map);
        if (start < s.length() - 1) {
            int tenDigit = s.charAt(start) - '0';
            int singleDigit = s.charAt(start + 1) - '0';
            if (tenDigit * 10 + singleDigit <= 26) {
                res2 = decodingsRecursion(s, start + 2, map);
            }
        }
        map.put(start, res1 + res2);
        return res1 + res2;
    }
}

 
 /*
 * Solution 3
 * 2019-10-11  Runtime: 1 ms
 * Algorithm: => DP and Recursion. Bottom to Top.
 * Time Complexity: ?, Space Conplexity: O(1)
 */
 
 class Solution {
    public int numDecodings(String s) {
        int res1 = 0, res2 = 0;
        int n = s.length();
        // dp[i] stands for substring(i, n - 1)
        int[] dp = new int[n + 1];
        dp[n] = 1;
        if (s.charAt(n - 1) != '0') {
            dp[n - 1] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            res1 = dp[i + 1];
            if (s.charAt(i) == '0') {
                continue;
            }
            res2 = 0;
            int tenDigit = s.charAt(i) - '0';
            int singleDigit = s.charAt(i + 1) - '0';
            if (tenDigit * 10 + singleDigit <= 26) {
                res2 = dp[i + 2];
            }
            dp[i] = res1 + res2;
            /*System.out.println("i: " + i + " ");
            System.out.println(dp[i]);*/
        }
        return dp[0];
    }
}
 
 
  
/*
 * Solution 4
 * 2019-10-11  Runtime: 1 ms
 * Algorithm: => Optimal of sol 3. DP and Recursion. Bottom to Top. When update dp[i], we just need dp[i + 1] and dp[i + 2]
 *               First optimal sol is: int dp0, dp1, dp2 stand for dp[0], dp[i + 1] and dp[i + 2]
 *               Second optimal sol is: int cur, int end. Every time loop ends update cur and end, cur = res1 + res2, end move forward to cur.
 *               Sol 4 is second optimal method.
 * Time Complexity: ?, Space Conplexity: O(1)
 */
 
 class Solution {
    public int numDecodings(String s) {
        int cur = 0, end = 1;
        int n = s.length();
        // dp[i] stands for substring(i, n - 1)
        if (s.charAt(n - 1) != '0') {
            cur = 1;
        }
        /*System.out.println("init cur: " + cur + " ");
        System.out.println("init end: " + end + " ");*/
        for (int i = n - 2; i >= 0; i--) {
            /*System.out.println("s.charAt(i): " + s.charAt(i) + " ");*/
            if (s.charAt(i) == '0') {
                end = cur;
                cur = 0;
                continue;
            }
            int res1 = cur;
            int res2 = 0;
            /*System.out.println("pre cur: " + cur + " ");
            System.out.println("pre end: " + end + " ");*/
            int tenDigit = s.charAt(i) - '0';
            int singleDigit = s.charAt(i + 1) - '0';
            if (tenDigit * 10 + singleDigit <= 26) {
                res2 = end;
            }
            end = cur;
            cur = res1 + res2;
            /*System.out.println("cur: " + cur + " ");
            System.out.println("end: " + end + " ");*/
        }
        return cur;
    }
}
 
