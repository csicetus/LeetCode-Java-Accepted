LeetCode-Java-Accepted
===
This is the Java solutions of Leetcode problems.

Details
===
### Title and answer format
```
/*
 * 17. Letter Combinations of a Phone Number
 * Target: Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Difficulty：Medium
 * Classification：String, Backtracking
 */

/*
 * Solution 1
 * 2019-06-08  Runtime: 0 ms
 * Algorithm: => Recursive
 *               If digits == "23", 
 *               first layer recursive: combination("a", "23", 1, ""), combination("b", "23", 1, ""), combination("c", "23", 1, "");
 *               Start with 'a', then recursively to 'd' , then 'g' , add "adg", then add "adh", then add "adi" ... from left to right, 
 *               recursively after it is added.
 * Time Complexity: O(logn), Space Conplexity: O(1)
 */

class Solution {
    ...
}


/*
 * Solution 2
 * 2019-06-08  Runtime: 0 ms
 * Algorithm: => Queue iteration
 *               If digits == "236", first loop: res = [a, b, c], second loop: res = [b, c, ad, af, ae]...
 *               Until i == 2, res = [ad, ae, af, bd, be, bf, cd, ce, cf]
 * Time Complexity: O(n), Space Conplexity: O(n)
 */

class Solution {
    ...
}
```
### Map
* [Top 100 Liked Questions](./Top100.md)
* [Top Interview Questions](./Top100.md)
* [Question classification and idea](./Top100.md)

### LeetCode Problems & Solutions

001 [Java](./Code/1_Two_Sum.java)
| 002 [Java](./Code/2_Add_Two_Numbers.java)
| 003 [Java](./Code/3_Longest_Substring_Without_Repeating_Characters.java)
| 004 [Java](./Code/4_Median_of_Two_Sorted_Arrays.java)
| 005 [Java](./Code/5_Longest_Palindromic_Substring.java)
| 007 [Java](./Code/7_Reverse_Integer.java)
| 008 [Java](./Code/8_String_to_Integer(atoi).java)
| 009 Java
| 010 [Java](./Code/10_Regular_Expression_Matching.java)
| 011 [Java](./Code/11_Container_With_Most_Water.java)
| 013 [Java](./Code/13_Roman-to_Integer.java)
| 014 Java
| 015 [Java](./Code/15_3Sum.java)
| 016 Java
| 017 [Java](./Code/17_Letter_Combinations_of_a_Phone_Number.java)
| 019 [Java](./Code/19_Remove_Nth_Node_From_End_of_List.java)
| 020 [Java](./Code/20_Valid_Parentheses.java)
| 021 [Java](./Code/21_Merge_Two_Sorted_Lists.java)
| 022 [Java](./Code/22_Generate_Parentheses.java)
| 023 [Java](./Code/23_Merge_k_Sorted_Lists.java)
| 024 Java
| 026 Java
| 027 Java
| 028 Java
| 029 Java
| 031 [Java](./Code/31_Next_Permutation.java)
| 032 Java
| 033 [Java](./Code/33_Search_in_Rotated_Sorted_Array.java)
| 034 [Java](./Code/34_Find_First_and_Last_Position_of_Element_in_Sorted_Array.java)
| 035 Java
| 036 Java
| 038 Java
| 039 [Java](./Code/39_Combination_Sum.java)
| 041 Java
| 042 Java
| 043 Java
| 044 Java
| 046 [Java](./Code/46_Permutations.java)
| 048 [Java](./Code/48_Rotate_Image.java)
| 049 [Java](./Code/49_Group_Anagrams.java)
| 050 Java
| 051 Java
| 053 [Java](./Code/53_Maximum_Subarray.java)
| 054 Java
| 055 [Java](./Code/55_Jump_Game.java)
| 056 [Java](./Code/56_Merge_Intervals.java)
| 058 Java
| 062 [Java](./Code/62_Unique_Paths.java)
| 063 Java
| 064 [Java](./Code/64_Minimum_Path_Sum.java)
| 066 Java
| 069 Java
| 070 [Java](./Code/70_Climbing_Stairs.java)
| 072 Java
| 073 Java
| 075 [Java](./Code/75_Sort_Colors.java)
| 076 Java
| 078 [Java](./Code/78_Subsets.java)
| 079 [Java](./Code/79_Word_Search.java)
| 084 Java
| 085 Java
| 088 Java
| 091 Java
| 094 [Java](./Code/94_Binary_Tree_Inorder_Traversal.java)
| 095 Java
| 096 [Java](./Code/96_Unique_Binary_Search_Trees.java)
| 098 Java
| 100 Java
| 101 [Java](./Code/101_Symmetric_Tree.java)
