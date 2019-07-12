Question classification and idea
===
This is the question classification and idea of Leetcode problems.

Details
===
### 1. Two Pointers
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
#### LeetCode Problems & Solutions

| \# | Problems | Difficulty | Solution |
|----|----------|-----------|------|
| 003  | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | Medium | [Java](./Code/3_Longest_Substring_Without_Repeating_Characters.java)
| 026  | [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | Easy| [Java](./Code/26_Remove_Duplicates_from_Sorted_Array.java)
| 076  | [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/) | Hard| [Java](./Code/76_Minimum_Window_Substring.java)
| 209  | [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/) | Medium| [Java](./Code/209_Minimum_Size_Subarray_Sum.java)
| 395  | [Longest Substring with At Least K Repeating Characters](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/) | Medium| [Java]

### 2. Other
