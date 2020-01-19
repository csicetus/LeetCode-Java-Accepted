/////////////// sol 1: List + formula

// Time&Space: O(n)
class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> nums = new ArrayList<Integer>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            nums.add(i);
            fact *= i;
        }
        int l = k - 1;
        for (int i = 0; i < n; i++) {
            fact /= (n - i);
            int index = (l / fact);
            sb.append(nums.remove(index));
            l -= index * fact;
        }
        return sb.toString();
    }
}
