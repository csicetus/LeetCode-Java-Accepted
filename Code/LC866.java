//////////// sol 1: Brute Force with Mathematical Shortcut

// Time: O(n); Space: O(1)
class Solution {
    public int primePalindrome(int N) {
        while (true) {
            if (isPrime(N) && isPalindrome(N)) {
                return N;
            }
            N++;
            if (10_000_000 < N && N < 100_000_000) {
                N = 100_000_000;
            }
        } 
    }
    
    private boolean isPrime(int N) {
        if (N < 2) return false;
        int R = (int)Math.sqrt(N) + 1;
        for (int i = 2; i < R; i++) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isPalindrome(int N) {
        int K = N, reverse = 0;
        while (N > 0) {
            reverse = 10 * reverse + (N % 10);
            N /= 10;
        }
        return reverse == K;
    }
}
