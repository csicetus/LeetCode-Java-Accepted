/*
 * 86. Partition List
 * Target: Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * Difficulty：Medium
 * Classification：Linked List, Two points
 */

/*
 * Solution 1
 * 2019-07-17  Runtime: 0 ms
 * Algorithm: => Linked List and Two points with same direction. One is for ListNode with value less than x, the other is larger than x.
 * Time Complexity: O(n), Space Conplexity: O(1)
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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode before = dummy1;
        ListNode after = dummy2;
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = dummy2.next;
        return dummy1.next;
    }
}
