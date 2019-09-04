/*
 * 328. Odd Even Linked List
 * Target: Given a singly linked list, group all odd nodes together followed by the even nodes.
 *         Please note here we are talking about the node number and not the value in the nodes.
 *         You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *         The relative order inside both the even and odd groups should remain as it was in the input.
 *         The first node is considered odd, the second node even and so on ...
 * Difficulty：Medium
 * Classification：Linked List
 */

/*
 * Solution 1
 * 2019-09-03  Runtime: 0 ms
 * Algorithm: => Select odd and even separately. 
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
