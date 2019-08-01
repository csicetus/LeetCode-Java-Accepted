/*
 * 148. Sort List
 * Target: Sort a linked list in O(n log n) time using constant space complexity.
 * Difficulty：Medium
 * Classification：Linked List, Sort
 */

/*
 * Solution 1
 * 2019-08-01  Runtime: 6 ms
 * Algorithm: => Left and Right product lists.
 * Time Complexity: O(N). Space Conplexity: O(N) where N represents the number of elements in the input array. 
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
    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int n = 0;
        while (head != null) {
            head = head.next;
            n++;
        }
        for (int i = 1; i < n; i <<= 1) {
            ListNode pre = dummy;
            ListNode cur = dummy.next;
            while (cur != null) {
                ListNode left = cur;
                ListNode right = split(left, i);
                cur = split(right, i);
                pre = merge(left, right, pre);
            }
        }
        return dummy.next;
    }
    
    private ListNode split(ListNode head, int i) {
        if (head == null) return null;
        for (int j = 1; head.next != null && j < i; j++) {
            head = head.next;
        }
        ListNode right = head.next;
        head.next = null;
        return right;
    }
    
    private ListNode merge(ListNode left, ListNode right, ListNode pre) {
        ListNode cur = pre;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left != null) cur.next = left;
        else if (right != null) cur.next = right;
        while (cur.next != null) cur = cur.next;
        return cur;
    }
}
