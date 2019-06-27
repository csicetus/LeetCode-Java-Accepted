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
| 002 [Java](./code/lc2.java)
| 003 [Java](./code/lc3.java)
| 004 [Java](./code/lc4.java)
| 005 [Java](./code/lc5.java)
| 007 [Java](./code/lc7.java)
| 008 [Java](./code/lc8.java)
| 009 [Java](./code/lc9.java)
| 010 [Java](./Code/10_Regular_Expression_Matching.java)
| 011 [Java](./Code/11_Container_With_Most_Water.java)
| 013 [Java](./code/lc13.java)
| 014 [Java](./code/lc14.java)
| 015 [Java](./code/lc15.java)
| 016 [Java](./code/lc16.java)
| 017 [Java](./code/lc17.java)
| 019 [Java](./code/lc19.java)
| 020 [Java](./code/lc20.java)
| 021 [Java](./code/lc21.java)
| 022 [Java](./code/lc22.java)
| 023 [Java](./code/lc23.java)
| 024 [Java](./code/lc24.java)
| 026 [Java](./code/lc26.java)
| 027 [Java](./code/lc27.java)
| 028 [Java](./code/lc28.java)
| 029 [Java](./code/lc29.java)
| 031 [Java](./code/lc31.java)
| 032 [Java](./code/lc32.java)
| 033 [Java](./code/lc33.java)
| 034 [Java](./code/lc34.java)
| 034 [Java](./code/lc35.java)
| 036 [Java](./code/lc36.java)
| 038 [Java](./code/lc38.java)
| 039 [Java](./code/lc39.java)
| 041 [Java](./code/lc41.java)
| 042 [Java](./code/lc42.java)
| 043 [Java](./code/lc43.java)
| 044 [Java](./code/lc44.java)
| 046 [Java](./code/lc46.java)
| 048 [Java](./code/lc48.java)
| 049 [Java](./code/lc49.java)
| 050 [Java](./code/lc50.java)
| 051 [Java](./code/lc51.java)
| 053 [Java](./code/lc53.java)
| 054 [Java](./code/lc54.java)
| 055 [Java](./code/lc55.java)
| 056 [Java](./code/lc56.java)
| 058 [Java](./code/lc58.java)
| 062 [Java](./code/lc62.java)
| 063 [Java](./code/lc63.java)
| 064 [Java](./code/lc64.java)
| 066 [Java](./code/lc66.java)
| 069 [Java](./code/lc69.java)
| 070 [Java](./code/lc70.java)
| 072 [Java](./code/lc72.java)
| 073 [Java](./code/lc73.java)
| 075 [Java](./code/lc75.java)
| 076 [Java](./code/lc76.java)
| 078 [Java](./code/lc78.java)
| 079 [Java](./code/lc79.java)
| 084 [Java](./code/lc84.java)
| 085 [Java](./code/lc85.java)
| 088 [Java](./code/lc88.java)
| 091 [Java](./code/lc91.java)
| 094 [Java](./code/lc94.java)
| 095 [Java](./code/lc95.java)
| 096 [Java](./code/lc96.java)
| 098 [Java](./code/lc98.java)
| 100 [Java](./code/lc100.java)
| 101 [Java](./code/lc101.java)
