//////////// sol 1: graph

// Time: O(T + N); Space: O(N)
class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N + 1];
        // Town judge trusts nobody so sendCount = 0
        // Everybody (except for the town judge) trusts the town judge.
        // so getCount = N - 1
        // we can use getCount - sendCount == N - 1 to check town judge
        for (int i = 0; i < trust.length; i++) {
            int curSend = trust[i][0];
            int curGet = trust[i][1];
            count[curSend]--;
            count[curGet]++;
        }
        for (int i = 1; i <= N; i++) {
            if (count[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}
