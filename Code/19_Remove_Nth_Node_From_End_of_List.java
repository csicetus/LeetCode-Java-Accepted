/*
 * 19. Remove Nth Node From End of List
 * Target: Given a linked list, remove the n-th node from the end of list and return its head.
 * Difficulty：Medium
 * Classification：Linked List, Two Pointers
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 /*
 * Solution 1
 * 2019-06-09  Runtime: 0 ms
 * Algorithm: => Traverse the list first to calculate the length, then find the point before n-th and change its' next point.
 * Note: The first time traverse the list to determine the length, store each node in an array in passing. Time: O(n), Space: O(n).
 * Time complexity: O(n), Space complexity: O(1).
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


/*
 * Solution 2
 * 2019-06-09  Runtime: 0 ms
 * Algorithm: => We set two pointers, let the first pointer traverse n steps, and then let them start traversing at the same time, 
 *               so that when the first pointer ends, the second pointer has n from the first pointer. 
 *               Therefore, the position of the second pointer is just the last nth node.
 * Time complexity: O(n), Space complexity: O(1).
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l = dummy;
        ListNode r = dummy;
        
        for (int i = 1; i <= n + 1; i++){
            l = l.next;
        }
        
        while (l != null){
            l = l.next;
            r = r.next;
        }
        r.next = r.next.next;
        return dummy.next;
    }
}
