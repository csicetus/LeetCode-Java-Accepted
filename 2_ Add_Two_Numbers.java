/*
 * 2. Add Two Numbers
 * 2019-05-31  Runtime: 2 ms
 * Target: Two linked lists, the numbers on the nodes are reversed, forming numbers, sums, and return lists
 * Difficulty：Medium
 * Classification：Linked List, Math
 * Algorithm: Traversing the two linked lists at the same time, one-to-one bitwise addition.
 * Note that the carry could be 0 or 1;
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode p = l1, q = l2;
        int carry = 0;
        while(p != null || q != null){
            int x = (p != null) ? p.val:0;
            int y = (q != null) ? q.val:0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
