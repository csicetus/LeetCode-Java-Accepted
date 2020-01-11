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
* [Question classification and idea](./QuestionClassification)

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
| 042 [Java](./Code/LC042.java)
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
| 054 [Java](./Code/54_Spiral_Matrix.java)
| 055 [Java](./Code/55_Jump_Game.java)
| 056 [Java](./Code/56_Merge_Intervals.java)
| 057 Java
| 058 [Java](./Code/58_Length_of_Last_Word.java)
| 059 [Java](./Code/59_Spiral_Matrix_II.java)
| 060 [Java](./Code/60_Permutation_Sequence.java)
| 061 [Java](./Code/61_Rotate_List.java)
| 062 [Java](./Code/62_Unique_Paths.java)
| 063 [Java](./Code/LC063.java)
| 064 [Java](./Code/64_Minimum_Path_Sum.java)
| 065 Java
| 066 [Java](./Code/66_Plus_One.java)
| 067 [Java](./Code/67_Add_Binary.java)
| 068 Java
| 069 [Java](./Code/69_Sqrt(x).java)
| 070 [Java](./Code/70_Climbing_Stairs.java)
| 071 Java
| 072 Java
| 073 [Java](./Code/LC073.java)
| 074 [Java](./Code/74_Search_a_2D_Matrix.java)
| 075 [Java](./Code/75_Sort_Colors.java)
| 076 Java
| 077 [Java](./Code/77_Combinations.java)
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
| 090 [Java](./Code/LC090.java)
| 091 [Java](./Code/91_Decode_Ways.java)
| 092 Java
| 093 Java
| 094 [Java](./Code/94_Binary_Tree_Inorder_Traversal.java)
| 095 Java
| 096 [Java](./Code/96_Unique_Binary_Search_Trees.java)
| 097 Java
| 098 Java
| 099 Java
| 100 [Java](./Code/100_Same_Tree.java)
| 101 [Java](./Code/101_Symmetric_Tree.java)
| 102 [Java](./Code/LC102.java)
| 103 [Java](./Code/LC103.java)
| 104 [Java](./Code/104_Maximum_Depth_of_Binary_Tree.java)
| 105 [Java](./Code/105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal.java)
| 106 Java
| 107 Java
| 108 [Java](./Code/108_Convert_Sorted_Array_to_Binary_Search_Tree.java)
| 109 [Java](./Code/LC109.java)
| 110 [Java](./Code/110_Balanced_Binary_Tree.java)
| 111 [Java](./Code/111_Minimum_Depth_of_Binary_Tree.java)
| 112 [Java](./Code/112_Path_Sum.java)
| 113 [Java](./Code/113_Path_Sum_II.java)
| 114 [Java](./Code/114_Flatten_Binary_Tree_to_Linked_List.java)
| 115 Java
| 116 [Java](./Code/LC116.java)
| 117 Java
| 118 Java
| 119 Java
| 120 [Java](./Code/LC120.java)
| 121 [Java](./Code/121_Best_Time_to_Buy_and_Sell_Stock.java)
| 125 [Java](./Code/125_Valid_Palindrome.java)
| 126 [Java](./Code/LC126.java)
| 127 [Java](./Code/LC127.java)
| 129 [Java](./Code/LC129.java)
| 131 [Java](./Code/131_Palindrome_Partitioning.java)
| 136 [Java](./Code/136_Single_Number.java)
| 138 [Java](./Code/138_Copy_List_with_Random_Pointer.java)
| 139 [Java](./Code/139_Word_Break.java)
| 141 [Java](./Code/141_Linked_List_Cycle.java)
| 146 [Java](./Code/LC146.java)
| 148 [Java](./Code/148_Sort_List.java)
| 151 [Java](./Code/LC151.java)
| 152 [Java](./Code/152_Maximum_Product_Subarray.java)
| 153 [Java](./Code/LC153.java)
| 155 [Java](./Code/155_Min_Stack.java)
| 160 [Java](./Code/160_Intersection_of_Two_Linked_Lists.java)
| 162 [Java](./Code/LC162.java)
| 167 [Java](./Code/167_Two_Sum_II_Input_array_is_sorted.java)
| 171 [Java](./Code/171_Excel_Sheet_Column_Number.java)
| 172 [Java](./Code/172_Factorial_Trailing_Zeroes.java)
| 189 [Java](./Code/189_Rotate_Array.java)
| 190 [Java](./Code/190_Reverse_Bits.java)
| 191 [Java](./Code/191_Number_of_1_Bits.java)
| 198 [Java](./Code/198_House_Robber.java)
| 199 [Java](./Code/LC199.java)
| 200 [Java](./Code/LC200.java)
| 207 [Java](./Code/LC207.java)
| 208 [Java](/Code/208_Implement_Trie_(Prefix_Tree).java)
| 209 [Java](./Code/209_Minimum_Size_Subarray_Sum.java)
| 213 [Java](./Code/213_House_Robber_II.java)
| 215 [Java](./Code/215_Kth_Largest_Element_in_an_Array.java)
| 216 [Java](./Code/LC216.java)
| 221 [Java](./Code/221_Maximal_Square.java)
| 228 [Java](./Code/LC228.java)
| 229 [Java](./Code/LC229.java)
| 230 [Java](./Code/230_Kth_Smallest_Element_in_a_BST.java)
| 236 [Java](./Code/236_Lowest_Common_Ancestor_of_a_Binary_Tree.java)
| 238 [Java](./Code/238_Product_of_Array_Except_Self.java)
| 240 [Java](./Code/240_Search_a_2D_Matrix_II.java)
| 268 [Java](./Code/268_Missing_Number.java)
| 278 [Java](./Code/278_First_Bad_Version.java)
| 279 [Java](./Code/279_Perfect_Squares.java)
| 287 [Java](./Code/287_Find_the_Duplicate_Number.java)
| 288 [Java](./Code/LC288.java)
| 289 [Java](./Code/LC289.java)
| 300 [Java](./Code/300_Longest_Increasing_Subsequence.java)
| 309 [Java](./Code/309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown.java)
| 322 [Java](./Code/322_Coin_Change.java)
| 326 [Java](./Code/326_Power_of_Three.java)
| 328 [Java](./Code/328_Odd_Even_Linked_List.java)
| 337 [Java](./Code/337_House_Robber_III.java)
| 338 [Java](./Code/338_Counting_Bits.java)
| 341 [Java](./Code/LC341.java)
| 344 [Java](./Code/344_Reverse_String.java)
| 347 [Java](./Code/347_Top_K_Frequent_Elements.java)
| 349 [Java](./Code/349_Intersection_of_Two_Arrays.java)
| 350 [Java](./Code/350_Intersection_of_Two_Arrays_II.java)
| 367 [Java](./Code/367_Valid_Perfect_Square.java)
| 371 [Java](./Code/371_Sum_of_Two_Integers.java)
| 374 [Java](./Code/374_Guess_Number_Higher_or_Lower.java)
| 378 [Java](./Code/378_Kth_Smallest_Element_in_a_Sorted_Matrix.java)
| 380 [Java](./Code/LC380.java)
| 387 [Java](./Code/387_First_Unique_Character_in_a_String.java)
| 388 [Java](./Code/LC388.java)
| 394 [Java](./Code/394_Decode_String.java)
| 404 [Java](./Code/404_Sum_of_Left_Leaves.java)
| 406 [Java](./Code/406_Queue_Reconstruction_by_Height.java)
| 412 [Java](./Code/412_Fizz_Buzz.java)
| 416 [Java](./Code/416_Partition_Equal_Subset_Sum.java)
| 438 [Java](./Code/438_Find_All_Anagrams_in_a_String.java)
| 441 [Java](./Code/441_Arranging_Coins.java)
| 442 [Java](./Code/LC442.java)
| 448 [Java](./Code/448_Find_All_Numbers_Disappeared_in_an_Array.java)
| 454 [Java](./Code/454_4Sum_II.java)
| 456 [Java](./Code/LC456.java)
| 457 [Java](./Code/LC457.java)
| 491 [Java](./Code/LC491.java)
| 494 [Java](./Code/494_Target_Sum.java)
| 495 [Java](./Code/LC495.java)
| 496 [Java](./Code/496_Next_Greater_Element_I.java)
| 503 [Java](./Code/503_Next_Greater_Element_II.java)
| 509 [Java](./Code/LC509.java)
| 513 [Java](./Code/LC513.java)
| 515 [Java](./Code/LC515.java)
| 538 [Java](./Code/538_Convert_BST_to_Greater_Tree.java)
| 543 [Java](./Code/543_Diameter_of_Binary_Tree.java)
| 560 [Java](./Code/LC560.java)
| 572 [Java](./Code/572_Subtree_of_Another_Tree.java)
| 581 [Java](./Code/581_Shortest_Unsorted_Continuous_Subarray.java)
| 621 [Java](./Code/621_Task_Scheduler.java)
| 647 [Java](./Code/647_Palindromic_Substrings.java)
| 654 [Java](./Code/LC654.java)
| 671 [Java](./Code/671_Second_Minimum_Node_In_a_Binary_Tree.java)
| 692 [Java](./Code/LC692.java)
| 701 [Java](./Code/LC701.java)
| 739 [Java](./Code/739_Daily_Temperatures.java)
| 819 [Java](./Code/LC819.java)
| 852 [Java](./Code/852_Peak_Index_in_a_Mountain_Array.java)
| 866 [Java](./Code/LC866.java)
| 937 [Java](./Code/LC937.java)
| 957 [Java](./Code/LC957.java)
| 973 [Java](./Code/LC973.java)
| 977 [Java](./Code/LC977.java)
| 994 [Java](./Code/LC994.java)
| 997 [Java](./Code/LC997.java)
| 1091 [Java](./Code/LC1091.java)
