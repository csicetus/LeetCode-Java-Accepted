///////////// sol 1: DP

// Time: O(M*2^M), O(2^M) sub problem, each problem takes M time; Space: O(2^M)
// Memoization
// Use 1 byte to store a solution
// Use an integer to represent the numbers used(Bit operation)
public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;
        int sum = (maxChoosableInteger + 1) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        return canIWin(maxChoosableInteger, desiredTotal, 0, new HashMap<>());
    }

    private boolean canIWin(int maxN, int total, int state, HashMap<Integer, Boolean> map) {
        if (total <= 0) return false;
        if (map.containsKey(state)) return map.get(state);
        for (int i = 0; i < maxN; i++) {
            // check if each num in state is used
            // if i + 1 used, continue
            if ((state & (1 << i)) > 0) continue;
            // total - (i + 1) -> we choose current i+1(i start from 0 so we selece i + 1)
            // use recursion to check the other player result
            // state | (1 << i) -> set ith state to 1
            // | oprator only 0 | 0 = 0, otherwise = 1
            if (!canIWin(maxN, total - (i + 1), (state | (1 << i)), map)) {
                map.put(state, true);
                return true;
            }
        }
        map.put(state, false);
        return false;
    }
}
