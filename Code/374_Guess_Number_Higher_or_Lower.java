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
 * 2019-08-06  Runtime: 0 ms
 * Algorithm: => Binary Search.
 * Time Complexity: O(logn). Space Conplexity: O(1). 
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (guess(mid) == 0) {
                return mid;
            }
            else if (guess(mid) == 1) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return -1;
    }
}


/*
 * Solution 3
 * 2019-08-06  Runtime: 0 ms
 * Algorithm: => Ternary Search.
 * Time Complexity: O(log_3 n). Space Conplexity: O(1). 
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid1 = l + (r - l) / 3;
            int mid2 = r - (r - l) / 3;
            if (guess(mid1) == 0) {
                return mid1;
            }
            if (guess(mid2) == 0) {
                return mid2;
            }
            else if (guess(mid2) == 1) {
                l = mid2 + 1;
            }
            else if (guess(mid1) == -1) {
                r = mid1 - 1;
            } else {
                l = mid1 + 1;
                r = mid2 - 1;
            }
        }
        return n;
    }
}
