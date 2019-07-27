/*
 * 160. Intersection of Two Linked Lists
 * Target: Write a program to find the node at which the intersection of two singly linked lists begins.
 * Difficulty：Easy
 * Classification：Linked List
 * Best solution: sol 3.
 */

/*
 * Solution 1
 * 2019-07-26  Runtime: 660 ms
 * Algorithm: => Brutal. List operation
 * Time Complexity: O(m*n). Space Conplexity: O(1)
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        while (curA != null) {
            for (ListNode curB = headB; curB != null; curB = curB.next) {
                if (curA == curB) {
                    return curA;
                }
            }
            curA = curA.next;
        }
        return null;
    }
}


/*
 * Solution 2
 * 2019-07-26  Runtime: 7 ms
 * Algorithm: => HashTable. HashSet, firstly go through A list and store the node, then go through B list to find if intersects.
 * Time Complexity: O(m+n). Space Conplexity: O(m) or O(n)
 */
 
 public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        Set<ListNode> s = new HashSet<>();
        while (curA != null) {
            s.add(curA);
            curA = curA.next;
        }
        while (curB != null) {
            if (s.contains(curB)) {
                return curB;
            } 
            curB = curB.next;
        }
        return null;
    }
}

 
 /*
 * Solution 3
 * 2019-07-26  Runtime: 1 ms
 * Algorithm: => Two Pointers. When pApA reaches the end of a list, then redirect it to the head of B (yes, B, that's right.); 
 *               similarly when pBpB reaches the end of a list, redirect it the head of A.
 *               Both pointers travel length of (lengthA + lengthB) when they get to intersection.
 *               If two lists have intersection, then their last nodes must be the same one. 
 * Time Complexity: O(m+n). Space Conplexity: O(1)
 */
 
 public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = (curA != null) ? curA.next : headB;
            curB = (curB != null) ? curB.next : headA;
        }
        return curA;
    }
}
