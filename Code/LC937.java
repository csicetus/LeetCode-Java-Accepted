/*
 * 937. Reorder Data in Log Files
 * Target: https://leetcode.com/problems/reorder-data-in-log-files/
 * Difficulty：Easy
 * Classification：String
 */

/*
 * Solution 1
 * 2019-12-18  Runtime: 7 ms
 * Algorithm: => Rewrite compare function
 * Time Complexity: O(NlogN), N is the total content of logs.
 */
 
 // Rewrite compare function
// If both logs are letter logs. Compare second str.
// If both logs are digit logs. Stay in original order
// If first is digit, second is letter. bring letter to forward.
// If first is letter, second is digit. keep them in this order.

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] str1 = log1.split(" ", 2);
            String[] str2 = log2.split(" ", 2);
            /*
            System.out.println("logs");
            for (String s : logs) {
                System.out.println(s);
            }
            
            for (String st : str1) {
                System.out.println("=======s1===========");
                System.out.println(st);
            }
            
            //System.out.println("==================");
            
            for (String st : str2) {
                System.out.println("+++++++s2++++++++++++");
                System.out.println(st);
            }
            */
            
            boolean isDigit1 = Character.isDigit(str1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(str2[1].charAt(0));
            /*
            System.out.println("isDigit1&2");
            System.out.println(isDigit1);
            System.out.println(isDigit2);
            */
            if (!isDigit1 && !isDigit2) {
                // both letter-logs.
                int temp = str1[1].compareTo(str2[1]);
                if (temp != 0) {
                    return temp;
                }
                return str1[0].compareTo(str2[0]);
            }
            /*
            System.out.println((isDigit1 ? (isDigit2 ? 0 : 1) : -1));
            */
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
}
