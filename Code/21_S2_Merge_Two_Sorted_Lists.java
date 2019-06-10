/*
 * 21. Merge Two Sorted Lists solution 2
 * 2019-06-10  Runtime: 0 ms
 * Target: Merge two sorted linked lists and return it as a new list.
 * Difficulty：Easy
 * Classification：Linked List
 * Algorithm: => Recursion.
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
        if (l1 != null && l2 != null){
            if (l1.val > l2.val){
                ListNode temp = l1;
                l1 = l2;
                l2 = temp;
            }
            l1.next = mergeTwoLists(l1.next, l2);
        }
        return (l1 != null) ? l1 : l2;
    }
}
