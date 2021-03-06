/*
 * 61. Rotate List
 * Target: Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * Difficulty：Medium
 * Classification：Linked List, Two points
 */

/*
 * Solution 1
 * 2019-07-17  Runtime: 0 ms
 * Algorithm: => Linked List. Find the broken node point by using length of linked list. Same as #19.
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int len = 0;
        ListNode h = head;
        ListNode t = head;
        while (h != null) {
            h = h.next;
            len++;
            if (h != null) t = h;
        }
        int n = k % len;
        if (n == 0) return head;
        ListNode slow = head;
        for (int i = 1; i < len - n; i++) {
            slow = slow.next;
        }
        t.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}


/*
 * Solution 2
 * 2019-07-17  Runtime: 0 ms
 * Algorithm: => Linked List and Two Pointers. Find the broken node point by using fast and slow ListNode. Same as #19.
 * Time Complexity: O(n), Space Conplexity: O(1)
 */

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int len = 0;
        ListNode h = head;
        ListNode t = head;
        while (h != null) {
            h = h.next;
            len++;
            if (h != null) t = h;
        }
        int n = k % len;
        if (n == 0) return head;
        // Use the fast and slow pointer to find the pointer of the reciprocal n + 1 node, save it as slow
        ListNode fast = head;
        while (n >= 0) {
            fast = fast.next;
            n--;
        }
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        t.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}
