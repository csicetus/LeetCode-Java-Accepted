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
| 005 blank
| 007 [Java]
| 008 [Java]
| 009 [Java]
| 010 [Java](./Code/10_Regular_Expression_Matching.java)
| 011 [Java](./Code/11_Container_With_Most_Water.java)
| 013 [Java]
| 014 [Java](./code/lc14.java)
| 015 [Java](./Code/15_3Sum.java)
| 016 [Java](./code/lc16.java)
| 017 [Java](./Code/17_Letter_Combinations_of_a_Phone_Number.java)
| 019 [Java](./Code/19_Remove_Nth_Node_From_End_of_List.java)
| 020 [Java](./Code/20_Valid_Parentheses.java)
| 021 [Java](./Code/21_Merge_Two_Sorted_Lists.java)
| 022 [Java](./Code/22_Generate_Parentheses.java)
| 023 [Java](./Code/23_Merge_k_Sorted_Lists.java)
| 024 [Java](./code/lc24.java)
| 026 [Java](./code/lc26.java)
| 027 [Java](./code/lc27.java)
| 028 [Java](./code/lc28.java)
| 029 [Java](./code/lc29.java)
| 031 [Java](./Code/31_Next_Permutation.java)
| 032 [Java](./code/lc32.java)
| 033 [Java](./Code/33_Search_in_Rotated_Sorted_Array.java)
| 034 [Java](./Code/34_Find_First_and_Last_Position_of_Element_in_Sorted_Array.java)
| 035 [Java](./Code/lc35.java)
| 036 [Java](./code/lc36.java)
| 038 [Java](./code/lc38.java)
| 039 [Java](./Code/39_Combination_Sum.java)
| 041 [Java](./code/lc41.java)
| 042 [Java](./code/lc42.java)
| 043 [Java](./code/lc43.java)
| 044 [Java](./code/lc44.java)
| 046 [Java](./Code/46_Permutations.java)
| 048 [Java](./Code/48_Rotate_Image.java)
| 049 [Java](./Code/49_Group_Anagrams.java)
| 050 [Java](./code/lc50.java)
| 051 [Java](./code/lc51.java)
| 053 [Java](./Code/53_Maximum_Subarray.java)
| 054 [Java](./code/lc54.java)
| 055 [Java](./Code/55_Jump_Game.java)
| 056 [Java](./Code/56_Merge_Intervals.java)
| 058 [Java](./code/lc58.java)
| 062 [Java](./Code/62_Unique_Paths.java)
| 063 [Java](./code/lc63.java)
| 064 [Java](./Code/64_Minimum_Path_Sum.java)
| 066 [Java](./code/lc66.java)
| 069 [Java](./code/lc69.java)
| 070 [Java](./Code/70_Climbing_Stairs.java)
| 072 [Java](./code/lc72.java)
| 073 [Java](./code/lc73.java)
| 075 [Java](./Code/75_Sort_Colors.java)
| 076 [Java](./code/lc76.java)
| 078 [Java](./Code/78_Subsets.java)
| 079 [Java](./Code/79_Word_Search.java)
| 084 [Java](./code/lc84.java)
| 085 [Java](./code/lc85.java)
| 088 [Java](./code/lc88.java)
| 091 [Java](./code/lc91.java)
| 094 [Java](./Code/94_Binary_Tree_Inorder_Traversal.java)
| 095 [Java](./code/lc95.java)
| 096 [Java](./Code/96_Unique_Binary_Search_Trees.java)
| 098 [Java](./code/lc98.java)
| 100 [Java](./code/lc100.java)
| 101 [Java](./Code/101_Symmetric_Tree.java)
