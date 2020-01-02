////////// sol 1: Brute force -> Sort

// Time: O(nlogn); Space: O(n)
class Solution {
    public int[] sortedSquares(int[] A) {
        int[] arr = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            arr[i] = A[i] * A[i];
        }
        Arrays.sort(arr);
        return arr;
    }
}

////////// sol 2: Two pointers

// Time: O(n); Space: O(n)
class Solution {
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int l = 0, r = len - 1;
        int[] res = new int[len];
        for (int k = len - 1; k >= 0; k--) {
            if (Math.abs(A[l]) > Math.abs(A[r])) {
                res[k] = A[l] * A[l];
                l++;
            } else {
                res[k] = A[r] * A[r];
                r--;
            }
        }
        return res;
    }
}
