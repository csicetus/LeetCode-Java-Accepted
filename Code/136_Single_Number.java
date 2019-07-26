/*
 * 136. Single Number
 * Target: Given a non-empty array of integers, every element appears twice except for one. Find that single one.
*          Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * Difficulty：Easy
 * Classification：HashTable, Bit Manipulation
 * Best solution: sol 5.
 */

/*
 * Solution 1
 * 2019-07-26  Runtime: 305 ms
 * Algorithm: => Brutal. List operation
 * Time Complexity: O(n^2). Space Conplexity: O(n)
 */

class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 0) return 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!res.contains(nums[i])) {
                res.add(nums[i]);
            } else {
                for (int j = 0; j < res.size(); j++) {
                    if (nums[i] == res.get(j)) {
                        res.remove(j);
                    }
                }       
            }
        }
        return res.get(0);
    }
}

/*
 * Solution 2
 * 2019-07-26  Runtime: 9 ms
 * Algorithm: => HashTable. If not contains, add it. Otherwise, remove it. The rest number is what we want.
 * Time Complexity: O(n). Space Conplexity: O(n)
 */

import java.util.Enumeration;
import java.util.Hashtable;

class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 0) return 0;
        Hashtable<Integer, Integer> res = new Hashtable<>();
        for (int i = 0; i < nums.length; i++) {
            if (!res.containsKey(nums[i])) {
                res.put(nums[i], 1);
            } else {
                res.remove(nums[i]);
                res.put(nums[i], 2);
            } 
        }
        
        Enumeration e = res.keys();
        while( e.hasMoreElements() ){
            Object x = e.nextElement();
            if(res.get(x)==1){
                return (int)x;
            }
        }
        return 0;
    }
}

/*
 * Solution 3
 * 2019-07-26  Runtime: 7 ms
 * Algorithm: => HashSet. Same as sol 2.
 * Time Complexity: O(n). Space Conplexity: O(n)
 */

class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            if (!s.add(num)) {
                s.remove(num);
            }
        }
        return s.iterator().next();
    }
}

/*
 * Solution 4
 * 2019-07-26  Runtime: 6 ms
 * Algorithm: => Math and HashSet. Based on formula: 2∗(a+b+c) − (a+a+b+b+c) = c.
 * Time Complexity: O(n). Space Conplexity: O(n)
 */

class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }
        return 2 * sum2(s) - sum1(nums);
    }
    
    private int sum1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }  
    
    private int sum2(Set<Integer> s) {
        int sum = 0;
        for (int str : s) {
            sum += str;
        }
        return sum;
    }
}


/*
 * Solution 5
 * 2019-07-26  Runtime: 0 ms
 * Algorithm: => Math: XOR. a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
 *               So we can XOR all bits together to find the unique number.
 * Time Complexity: O(n). Space Conplexity: O(1)
 */
 
 class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
