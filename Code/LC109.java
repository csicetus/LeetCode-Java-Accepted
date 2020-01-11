//////////// sol 1: inorder simulation

// Time: O(n); Space: O(logn) for recursion stack, the height is bounded by logn
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {   
    private ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int size = getSize(head);
        this.head = head;
        ListNode headCopy = head;
        return changeListToBST(0, size - 1);
    }
    
    private TreeNode changeListToBST(int l, int r) {
        //System.out.println("l " + l + " r " + r);
        if (l > r) return null;
        int mid = (l + r) / 2;
        TreeNode left = changeListToBST(l, mid - 1);
        TreeNode root = new TreeNode(this.head.val);
        root.left = left;
        this.head = this.head.next;
        root.right = changeListToBST(mid + 1, r);
        return root;
    }
    
    private int getSize(ListNode head) {
        ListNode ptr = head;
        int count = 0;
        while (ptr != null) {
            ptr = ptr.next;
            count++;
        }
        return count;
    }
}
