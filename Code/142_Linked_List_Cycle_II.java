/*
 * 142. Linked List Cycle II
 * Target: Given a linked list, determine if it has a cycle in it.
 *         Use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. 
 *         If pos is -1, then there is no cycle in the linked list.
 * Difficulty：Easy
 * Classification：LinkedList, Two Pointers
 * Same as #141. Linked List Cycle
 */

/*
 * Solution 1
 * 2019-07-26  Runtime: 6 ms
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
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        Set<ListNode> s = new HashSet<>();
        while (head != null) {
            if (s.contains(head)) {
                return head;
            } else {
                s.add(head);
            }
            head = head.next;
        }
        return null;
    }
}


/*
 * Solution 2
 * 2019-07-28  Runtime: 0 ms
 * Algorithm: => Two Pointers. ListNode slow and slow2 can meet because they go through the same length of path. Details are in Discuss.
 * Time Complexity: ?. Space Conplexity: O(1)
 */
 
 public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode slow2 = head;
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
