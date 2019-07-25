/*
 * 83. Remove Duplicates from Sorted List
 * Target: Given a sorted linked list, delete all duplicates such that each element appear only once.
 * Difficulty：Easy
 * Classification：Linked List
 */

/*
 * Solution 1
 * 2019-07-25  Runtime: 1 ms
 * Algorithm: => Linked List. Iteration
 * Time Complexity: O(n). Space Conplexity: O(1)
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            pre.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}


/*
 * Solution 2
 * 2019-07-25  Runtime: 0 ms
 * Algorithm: => Linked List. Iteration, optimal of solution 1.
 * Time Complexity: O(n). Space Conplexity: O(1)
 */
 
 class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}


/*
 * Solution 3
 * 2019-07-25  Runtime: 0 ms
 * Algorithm: => Linked List. Recursion
 * Time Complexity: O(n). Space Conplexity: O(1)
 */
 
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val == head.next.val) {
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }              
    }
}
