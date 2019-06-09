/*
 * 19. Remove Nth Node From End of List solution 1
 * 2019-06-09  Runtime: 0 ms
 * Target: Given a linked list, remove the n-th node from the end of list and return its head.
 * Difficulty：Medium
 * Classification：Linked List, Two Pointers
 * Algorithm: => Traverse the list first to calculate the length, then find the point before n-th and change its' next point.
 * Time complexity: O(n), Space complexity: O(1)
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode h = head;
        while (h != null){
            h = h.next;
            len++;
        }
        
        if (len == 1){
            return null;
        }
        
        int tar = len - n;
        
        if (tar == 0){
            return head.next;
        }
        
        h = head;
        for (int i = 0; i < tar - 1; i++){
            h = h.next;
        }
        h.next = h.next.next;
        return head;
    }
}
