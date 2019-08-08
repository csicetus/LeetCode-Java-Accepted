/*
 * 278. First Bad Version
 * Target: Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *         You are given an API bool isBadVersion(version) which will return whether version is bad. 
 *         Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * Difficulty：Easy
 * Classification：Binary Search
 */

/*
 * Solution 1
 * 2019-08-08  Runtime: ? ms
 * Algorithm: => Linear Scan
 * Time Complexity: O(n). Space Conplexity: O(1). 
 * Note: Time Limit Exceeded 
 */
 
 public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
      for (int i = 1; i < n; i++) {
          if (isBadVersion(i)) {
              return i;
          }
      }
      return n;
    }
}


/*
 * Solution 1
 * 2019-08-08  Runtime: 10 ms
 * Algorithm: => Binary Search
 * Time Complexity: O(logn). Space Conplexity: O(1). 
 */
 
 /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (!isBadVersion(mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            } 
        }
        return l;
    }
}
 
