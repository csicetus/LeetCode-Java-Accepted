/*
 * 374. Guess Number Higher or Lower
 * Target: I pick a number from 1 to n. You have to guess which number I picked. Every time you guess wrong, I'll tell you whether the number is higher or lower.
 *          You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 *          -1 : My number is lower; 1 : My number is higher; 0 : Congrats! You got it!
 * Difficulty：Easy
 * Classification：Binary Search
 */

/*
 * Solution 1
 * 2019-08-06  Runtime: ? ms
 * Algorithm: => Brute Force.
 * Time Complexity: O(n). Space Conplexity: O(1). 
 */
 
 public class Solution extends GuessGame {
    public int guessNumber(int n) {
        for (int i = 1; i < n; i++) {
            if (guess(i) == 0) return i;
        }
        return n;
    }
}


/*
 * Solution 2
 * 2019-08-06  Runtime: 21 ms
 * Algorithm: => Brute Force.
 * Time Complexity: O(n). Space Conplexity: O(1). 
 */
