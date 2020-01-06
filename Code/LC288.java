////////// sol 1: two pointers 1

// Time: O(n); Space: O(1)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            int startNum = nums[i];
            while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
                i++;
            }
            if (startNum != nums[i]) {
                res.add(startNum + "->" + nums[i]);
            } else {
                res.add(startNum + "");
            }
        }
        return res;
    }
}

////////// sol 2: two pointers 2

/////////  27 / 28 test cases passed.

// Input:     [-2147483648,-2147483647,2147483647]
// Output:    ["-2147483648->2147483647"]
// Expected:  ["-2147483648->-2147483647","2147483647"]


// Follow up 1: better than O(n)
// Time: O(nlogn)?; Space: O(1)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            int lo = i + 1, hi = nums.length - 1;
            int last = -1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                // System.out.println("lo " + lo);
                // System.out.println("hi " + hi);
                // System.out.println("mid " + mid);
                // System.out.println("i " + i);
                // System.out.println("last " + last);
                // System.out.println("--------");

                if (nums[mid] - nums[i] <= mid - i) {
                    last = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            
            // System.out.println("******************");
            // System.out.println("lo " + lo);
            //     System.out.println("hi " + hi);
            //     System.out.println("i " + i);
            //     System.out.println("last " + last);
            //     System.out.println("*************");

            
            if (last != -1) {
                res.add(nums[i] + "->" + nums[last]);
                i = last;
            } else {
                res.add(nums[i] + "");
            }
        }
        return res;
    }
}
