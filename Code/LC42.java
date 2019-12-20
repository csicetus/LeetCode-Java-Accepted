////////// sol 1
class Solution {
    // Time: O(n^2); Space: O(1)
    public int trap(int[] height) {
        int res = 0;
        int len = height.length;
        for (int i = 0; i < len; i++) {
            // int temp = 0;
            int minLine = 0;
            int leftMax = findMax(0, i, height);
            int rightMax = findMax(i + 1, len, height);
            // if (leftMax < rightMax) {
            //     minLine = leftMax;
            // } else {
            //     minLine = rightMax;
            // }
            minLine = Math.min(leftMax, rightMax);
            if (height[i] < minLine) {
                // temp = minLine - height[i];
                // res += temp;
                res += minLine - height[i];
            }
        }
        return res;
    }
    
    private int findMax(int start, int end, int[] height) {
        int tmp = 0;
        for (int i = start; i < end; i++) {
            if (height[i] > tmp) {
                tmp = height[i];
            }
        }
        return tmp;
    }
}


////////// sol 2
class Solution {
    // Time: O(n); Space: O(n)
    public int trap(int[] height) {
        int res = 0;
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        for (int j = 1; j < len - 1; j++) {
            leftMax[j] = Math.max(leftMax[j - 1], height[j - 1]);
        }
        for (int j = len - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], height[j + 1]);
        }
        for (int i = 0; i < len; i++) {
            int minLine = 0;
            minLine = Math.min(leftMax[i], rightMax[i]);
            if (height[i] < minLine) {
                res += minLine - height[i];
            }
        }
        return res;
    }
}
