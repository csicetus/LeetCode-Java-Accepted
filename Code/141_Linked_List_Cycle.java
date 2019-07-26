/*
 * 141. Linked List Cycle
 * Target: Given a linked list, determine if it has a cycle in it.
 *         Use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. 
 *         If pos is -1, then there is no cycle in the linked list.
 * Difficulty：Easy
 * Classification：LinkedList, Two Pointers
 */

/*
 * Solution 1
 * 2019-07-26  Runtime: 5 ms
 * Algorithm: => HashSet. Go through each node one by one and record each node's reference (or memory address) in a hash table.
 * Time Complexity: O(n). Space Conplexity: O(n)
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        Set<ListNode> s = new HashSet<>();
        while (head != null) {
            if (s.contains(head)) {
                return true;
            } else {
                s.add(head);
            }
            head = head.next;
        }
        return false;
    }
}


/*
 * Solution 2
 * 2019-07-26  Runtime: 0 ms
 * Algorithm: => Two Pointers.
 * Time Complexity: O(n), n is the total number of nodes in the linked list. Space Conplexity: O(1)
 */
 
 public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }             
        }
        return false;
    }
}
