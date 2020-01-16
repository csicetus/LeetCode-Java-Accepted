Question classification and idea
===
This is the question classification and idea of Leetcode problems.

Series of stock
===
### Details

T[i][k][0] => On the ith day, we have k transactions and have 0 stock

T[i][k][1] => On the ithe day, we have k transactions and have 1 stock

Base case

```Java
T[-i][k][0] = 0;
T[-i][k][1] = -Inf;
T[i][0][0] = 0;
T[i][0][1] = -Inf;
```

Recursions

```Java
T[i][k][0] = Math.max(T[i - 1][k][0], T[i - 1][k][1] + prices[i]);
// add transactions when selling
T[i][k][1] = Math.max(T[i - 1][k][1], T[i - 1][k - 1][0] - prices[i]);
```

Optimal 1: The cash of ith day is depended on (i-1)th day(or (i-2)th day) => use two variables T_ik0 and T_ik1

```Java
T_ik0 = Math.max(T_ik0, T_ik1 + prices[i])
T_ik1 = Math.max(T_ik1, T_ik0 - prices[i])
```

Optimal 2: For special case
```Java
/*
For k == 1, use the basic case

For k == Inf, note that T[i][k-1][0] = T[i][k][0]

For k == 2， use 4 variables for T_i10, T_i11, T_i20 and T_i21

For k == arbitrary, use array and special case k >= n / 2

For cool down, use one variable to store (i-2)th day cash

For transaction fee, add it when buying or selling
*/
```

LeetCode Problems & Solutions

| \# | Problems | Difficulty | Solution |
|----|----------|-----------|------|
| 121  | [Best I](https://leetcode.com/problems/permutations/) | Easy | [Java](../master/Code/LC121.java)
| 122  | [Best II](https://leetcode.com/problems/combinations/submissions/) | Easy | [Java](../master/Code/LC122.java)
| 123  | [Best III](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/) | Hard | [Java](../master/Code/LC123.java)
| 188  | [Best IV](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/) | Hard | [Java](../master/Code/LC188.java)
| 309  | [Best + cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/) | Medium | [Java](../master/Code/LC309.java)
| 714  | [Best + transaction fee](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/) | Medium | [Java](../master/Code/LC714.java)
