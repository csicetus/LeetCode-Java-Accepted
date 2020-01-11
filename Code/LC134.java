/////////////// sol 1

// Time: O(n); Space: O(1)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int sumGas = 0, sumCost = 0, tank = 0;
        // suppose we start from a to c, and when we reach c,
        // (1)totalGas < totalCost, which means we can't make it with start a.
        // suppose there's a point x between a and c
        // from a to x, we have (2)preGas >= preCost
        // combine (1) and (2)
        // we have totalGas - preGas < totalCost - preCost
        // which means there's no point x that can reach to c
        // so we can just set start as i + 1(position after c)
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return sumGas >= sumCost ? start : -1;
    }
}
