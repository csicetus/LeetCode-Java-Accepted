/*
 * 9. Palindrome Number
 * Target: Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * Difficulty：Easy
 * Classification：Math
 */

/*
 * Solution 1
 * 2019-07-25  Runtime: 0 ms
 * Algorithm: => Math
 * Time Complexity: O(logx). Space Conplexity: O(1)
 */
 
 class Solution {
    public boolean isPalindrome(int x) {
        if(x == 0) {
            return true; 
        }
        int rev = 0;
        if(x % 10 == 0 || x < 0 ) return false;               
        else{
            while(rev < x){
                int pop = x % 10; 
                x = x / 10;
                rev = rev * 10 + pop; 
            }
        if(x == rev / 10 || x == rev) return true;
        else return false;
        }  
    }
}
