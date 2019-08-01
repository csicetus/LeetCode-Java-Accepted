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
* [Question classification and idea](./QuestionClassification.md)

### LeetCode Problems & Solutions

001 [Java](./Code/1_Two_Sum.java)
| 002 [Java](./Code/2_Add_Two_Numbers.java)
| 003 [Java](./Code/3_Longest_Substring_Without_Repeating_Characters.java)
| 004 [Java](./Code/4_Median_of_Two_Sorted_Arrays.java)
| 005 [Java](./Code/5_Longest_Palindromic_Substring.java)
| 006 Java
| 007 [Java](./Code/7_Reverse_Integer.java)
| 008 [Java](./Code/8_String_to_Integer(atoi).java)
| 009 [Java](./Code/9_Palindrome_Number.java)
| 010 [Java](./Code/10_Regular_Expression_Matching.java)
| 011 [Java](./Code/11_Container_With_Most_Water.java)
| 012 [Java](./Code/12_Integer_to_Roman.java)
| 013 [Java](./Code/13_Roman-to_Integer.java)
| 014 [Java](./Code/14_Longest_Common_Prefix.java)
| 015 [Java](./Code/15_3Sum.java)
| 016 [Java](./Code/16_3Sum_Closest.java)
| 017 [Java](./Code/17_Letter_Combinations_of_a_Phone_Number.java)
| 018 [Java](./Code/18_4Sum.java)
| 019 [Java](./Code/19_Remove_Nth_Node_From_End_of_List.java)
| 020 [Java](./Code/20_Valid_Parentheses.java)
| 021 [Java](./Code/21_Merge_Two_Sorted_Lists.java)
| 022 [Java](./Code/22_Generate_Parentheses.java)
| 023 [Java](./Code/23_Merge_k_Sorted_Lists.java)
| 024 [Java](./Code/24_Swap_Nodes_in_Pairs.java)
| 025 Java
| 026 [Java](./Code/26_Remove_Duplicates_from_Sorted_Array.java)
| 027 [Java](./Code/27_Remove_Element.java)
| 028 [Java](./Code/28_Implement_strStr().java)
| 029 [Java](./Code/29_Divide_Two_Integers.java)
| 030 Java
| 031 [Java](./Code/31_Next_Permutation.java)
| 032 Java
| 033 [Java](./Code/33_Search_in_Rotated_Sorted_Array.java)
| 034 [Java](./Code/34_Find_First_and_Last_Position_of_Element_in_Sorted_Array.java)
| 035 [Java](./Code/35_Search_Insert_Position.java)
| 036 [Java](./Code/36_Valid_Sudoku.java)
| 037 Java
| 038 [Java](./Code/38_Count_and_Say.java)
| 039 [Java](./Code/39_Combination_Sum.java)
| 040 [Java](./Code/40_Combination_Sum_II.java)
| 041 Java
| 042 Java
| 043 [Java](./Code/43_Multiply_Strings.java)
| 044 Java
| 045 Java
| 046 [Java](./Code/46_Permutations.java)
| 047 [Java](./Code/47_Permutations_II.java)
| 048 [Java](./Code/48_Rotate_Image.java)
| 049 [Java](./Code/49_Group_Anagrams.java)
| 050 Java
| 051 Java
| 052 Java
| 053 [Java](./Code/53_Maximum_Subarray.java)
| 054 Java
| 055 [Java](./Code/55_Jump_Game.java)
| 056 [Java](./Code/56_Merge_Intervals.java)
| 057 Java
| 058 [Java](./Code/58_Length_of_Last_Word.java)
| 059 Java
| 060 [Java](./Code/60_Permutation_Sequence.java)
| 061 [Java](./Code/61_Rotate_List.java)
| 062 [Java](./Code/62_Unique_Paths.java)
| 063 Java
| 064 [Java](./Code/64_Minimum_Path_Sum.java)
| 065 Java
| 066 [Java](./Code/66_Plus_One.java)
| 067 [Java](./Code/67_Add_Binary.java)
| 068 Java
| 069 [Java](./Code/69_Sqrt(x).java)
| 070 [Java](./Code/70_Climbing_Stairs.java)
| 071 Java
| 072 Java
| 073 Java
| 074 Java
| 075 [Java](./Code/75_Sort_Colors.java)
| 076 Java
| 077 Java
| 078 [Java](./Code/78_Subsets.java)
| 079 [Java](./Code/79_Word_Search.java)
| 080 [Java](./Code/80_Remove_Duplicates_from_Sorted_Array_II.java)
| 081 Java
| 082 [Java](./Code/82_Remove_Duplicates_from_Sorted_List_II)
| 083 [Java](./Code/83_Remove_Duplicates_from_Sorted_List.java)
| 084 Java
| 085 Java
| 086 [Java](./Code/86_Partition_List.java)
| 087 Java
| 088 [Java](./Code/88_Merge_Sorted_Array.java)
| 089 Java
| 090 Java
| 091 Java
| 094 [Java](./Code/94_Binary_Tree_Inorder_Traversal.java)
| 095 Java
| 096 [Java](./Code/96_Unique_Binary_Search_Trees.java)
| 098 Java
| 100 [Java](./Code/100_Same_Tree.java)
| 101 [Java](./Code/101_Symmetric_Tree.java)
| 104 [Java](./Code/104_Maximum_Depth_of_Binary_Tree.java)
| 105 [Java](./Code/105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal.java)
| 108 [Java](./Code/108_Convert_Sorted_Array_to_Binary_Search_Tree.java)
| 111 [Java](./Code/111_Minimum_Depth_of_Binary_Tree.java)
| 114 [Java](./Code/114_Flatten_Binary_Tree_to_Linked_List.java)
| 121 [Java](./Code/121_Best_Time_to_Buy_and_Sell_Stock.java)
| 136 [Java](./Code/136_Single_Number.java)
| 138 [Java](./Code/138_Copy_List_with_Random_Pointer.java)
| 139 [Java](./Code/139_Word_Break.java)
| 141 [Java](./Code/141_Linked_List_Cycle.java)
| 148 [Java](./Code/148_Sort_List.java)
| 152 [Java](./Code/152_Maximum_Product_Subarray.java)
| 160 [Java](./Code/160_Intersection_of_Two_Linked_Lists.java)
| 167 [Java](./Code/167_Two_Sum_II_Input_array_is_sorted.java)
| 200 [Java](./Code/200_Number_of_Islands.java)
| 208 [Java](./Code/208_Implement_Trie_(Prefix_Tree).java)
| 209 [Java](./Code/209_Minimum_Size_Subarray_Sum.java)
| 221 [Java](./Code/221_Maximal_Square.java)
| 236 [Java](./Code/236_Lowest_Common_Ancestor_of_a_Binary_Tree.java)
| 238 [Java](./Code/238_Product_of_Array_Except_Self.java)
| 240 [Java](./Code/240_Search_a_2D_Matrix_II.java)
| 279 [Java](./Code/279_Perfect_Squares.java)
| 287 [Java](./Code/287_Find_the_Duplicate_Number.java)
| 300 [Java](./Code/300_Longest_Increasing_Subsequence.java)
| 309 [Java](./Code/309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown.java)
| 322 [Java](./Code/322_Coin_Change.java)
| 338 [Java](./Code/338_Counting_Bits.java)
| 416 [Java](./Code/416_Partition_Equal_Subset_Sum.java)
| 438 [Java](./Code/438_Find_All_Anagrams_in_a_String.java)
| 494 [Java](./Code/494_Target_Sum.java)
| 528 [Java](./Code/538_Convert_BST_to_Greater_Tree.java)
| 543 [Java](./Code/543_Diameter_of_Binary_Tree)
| 581 [Java](./Code/581_Shortest_Unsorted_Continuous_Subarray.java)
| 647 [Java](./Code/647_Palindromic_Substrings.java)
