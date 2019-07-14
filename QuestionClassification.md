Question classification and idea
===
This is the question classification and idea of Leetcode problems.

Details
===
### 1. Two Pointers
1.1 Same direction

1.1.1 Pointers does not look back. Time complexity: O(n)
```Java
public int twoPointers() {
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && Current Subarray Not Meet the Criteria) {
                j++;
                Broaden the Current Subarray
            }
            if (Current Subarray Not Meet the Criteria) {
                Compare, determine whether it is the Optimal Solution
            }
            Remove Current nums[i] from Current Subarray;
        }
        return res;
    }
```
LeetCode Problems & Solutions

| \# | Problems | Difficulty | Solution |
|----|----------|-----------|------|
| 003  | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | Medium | [Java](./Code/3_Longest_Substring_Without_Repeating_Characters.java)
| 026  | [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | Easy| [Java](./Code/26_Remove_Duplicates_from_Sorted_Array.java)
| 076  | [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/) | Hard| [Java](./Code/76_Minimum_Window_Substring.java)
| 209  | [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/) | Medium| [Java](./Code/209_Minimum_Size_Subarray_Sum.java)
| 395  | [Longest Substring with At Least K Repeating Characters](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/) | Medium| [Java]

1.1.2 Pointers look back. Time Conplexity: O(n^2)


1.2 Reverse direction. Time Conplexity: O(n^2)
```Java
public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  // sort the array
        // note that the diff target has diff end of i(nums.length || nums.length - 2), which depends on the pointers l and r.
        for (int i = 0; i < nums.length - 2; i++){  
            // this if condition is aimed to remove the same res with diff types.
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                int l = i + 1, r = nums.length - 1;  // initial l, r and other variable we need
                while (l < r){
                    if (Current sum of pointers Meet the Criteria){
                        Update res or pointers
                    }
                    else if (Current sum less than the Criteria){
                        l++;
                    }
                    else {
                        r--;
                    }
                }
            }
        }
        return res;
}
```
LeetCode Problems & Solutions

| \# | Problems | Difficulty | Solution |
|----|----------|-----------|------|
| 015  | [3Sum](https://leetcode.com/problems/3sum/) | Medium | [Java](./Code/15_3Sum.javaa)
| 016  | [3Sum Closest](https://leetcode.com/problems/3sum-closest/) | Medium | [Java](./Code/16_3Sum_Closest.java)


### 2. Other
