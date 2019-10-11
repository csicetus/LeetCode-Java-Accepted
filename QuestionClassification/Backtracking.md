Question classification and idea
===
This is the question classification and idea of Leetcode problems.

Backtracking
===
### Details

One "for" loop
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
| 046  | [Permutations](https://leetcode.com/problems/permutations/) | Medium | [Java](../Code/46_Permutations.java)
| 077  | [Combinations](https://leetcode.com/problems/combinations/submissions/) | Medium | [Java](../Code/77_Combinations.java)
| 091  | []
| 115  | [Distinct Subsequences](https://leetcode.com/problems/distinct-subsequences/) | Hard | [Java](../Code/115_Distinct_Subsequences.java)
| 131  | [Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/) | Medium | [Java](../Code/131_Palindrome_Partitioning.java)

