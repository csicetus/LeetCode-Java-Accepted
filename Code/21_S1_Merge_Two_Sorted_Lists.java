/*
 * 21. Merge Two Sorted Lists solution 1
 * 2019-06-10  Runtime: 0 ms
 * Target: Merge two sorted linked lists and return it as a new list.
 * Difficulty：Easy
 * Classification：Linked List
 * Algorithm: => Iterate.
 * Time complexity: O(m + n), Space complexity: O(1)
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode res = head;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            }
            else {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }
        if (l1 == null){
            head.next = l2;
        }
        if (l2 == null){
            head.next = l1;
        }
        return res.next;
    }
}
