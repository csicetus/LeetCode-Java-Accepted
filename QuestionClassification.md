Question classification and idea
===
This is the question classification and idea of Leetcode problems.

Details
===
### 1. Two Pointers
1.1 Same direction

1.1.1 Pointers does not look back. Time complexity: O(n)
One for loop
```Java
    public int removeDuplicates(int[] nums) {
        if (Special case) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (Current int Meet the Criteria) {
                i++;  // add count
                Change the pre number to current number
            }   
        }
        return i + 1;
    }
```
LeetCode Problems & Solutions

| \# | Problems | Difficulty | Solution |
|----|----------|-----------|------|
| 026  | [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | Medium | [Java](./Code/26_Remove_Duplicates_from_Sorted_Array.java)
| 027  | [Remove Element](https://leetcode.com/problems/remove-element/) | Medium | [Java](./Code/27_Remove_Element.java)

One for loop contains while loop and if condition
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


1.2 Reverse direction. 

One while loop. For contain water, Time Complexity: O(n).
```Java
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxWater = (end - start) * Math.min(height[end], height[start]);
        while (start < end){
            if (height[start] <= height[end]){
                start ++;
            }
            else {
                end --;
            }
            if (maxWater < (end - start) * Math.min(height[end], height[start])){
                maxWater = (end - start) * Math.min(height[end], height[start]);
            }
        }
        return maxWater;
    }
```
LeetCode Problems & Solutions

| \# | Problems | Difficulty | Solution |
|----|----------|-----------|------|
| 011  | [Container With Most Water](https://leetcode.com/problems/container-with-most-water/) | Medium | [Java](./Code/11_Container_With_Most_Water.java)

One for loop contains while loop. For 3Sum, Time Complexity: O(n^2). For 4Sum, add another for loop, Time complexity: O(n^3).
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
| 015  | [3Sum](https://leetcode.com/problems/3sum/) | Medium | [Java](./Code/15_3Sum.java)
| 016  | [3Sum Closest](https://leetcode.com/problems/3sum-closest/) | Medium | [Java](./Code/16_3Sum_Closest.java)
| 018  | [4Sum](https://leetcode.com/problems/4sum/) | Medium | [Java](./Code/18_4Sum.java)


### 2. Other
