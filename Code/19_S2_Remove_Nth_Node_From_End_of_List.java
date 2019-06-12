/*
 * 19. Remove Nth Node From End of List solution 2
 * 2019-06-09  Runtime: 0 ms
 * Target: Given a linked list, remove the n-th node from the end of list and return its head.
 * Difficulty：Medium
 * Classification：Linked List, Two Pointers
 * Algorithm: => We set two pointers, let the first pointer traverse n steps, and then let them start traversing at the same time, 
 *               so that when the first pointer ends, the second pointer has n from the first pointer. 
 *               Therefore, the position of the second pointer is just the last nth node.
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
