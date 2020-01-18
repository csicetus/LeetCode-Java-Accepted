///////////////// sol 1: DP

// Time: O(nlogn); Space: O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            //System.out.println("num " + num);
            int i = 0, j = size;
            while (i != j) {
                int mid = (i + j) / 2;
                //System.out.print("i " + i);
                //System.out.print("  j " + j);
                //System.out.println("  mid " + mid);
                if (tails[mid] < num) {
                    i = mid + 1;
                    //System.out.println("i change to " + i);
                } else {
                    j = mid;
                    //System.out.println("j change to " + j);
                }
            }
            tails[i] = num;
            if (i == size) {
                size++;
            }
            //System.out.println("tails[" + i+ "] "+ tails[i]);
            //System.out.println("size " + size);
        }
        return size;
    }
}
