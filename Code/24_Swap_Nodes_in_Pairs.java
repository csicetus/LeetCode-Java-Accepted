/*
 * 24. Swap Nodes in Pairs
 * Target: Given a linked list, swap every two adjacent nodes and return its head.
 *         You may not modify the values in the list's nodes, only nodes itself may be changed.
 * Difficulty：Medium
 * Classification：Linked List
 */

/*
 * Solution 1
 * 2019-07-18  Runtime: 0 ms
 * Algorithm: => Iteration. Add a dummy node, then swap two ListNode.
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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode point = dummy;
        while (point.next != null && point.next.next != null) {
            ListNode n1 = point.next;
            ListNode n2 = point.next.next;
            point.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            point = n1;
        }
        return dummy.next;
    }
}

/*
 * Solution 2
 * 2019-07-18  Runtime: 0 ms
 * Algorithm: => Recursion.
 * Time Complexity: O(n), Space Conplexity: O(1)
 */
