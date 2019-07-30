/*
 * 138. Copy List with Random Pointer
 * Target: A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *         You must return the copy of the given head as a reference to the cloned list.
 * Difficulty：Medium
 * Classification：HashTable, Linked List
 */

/*
 * Solution 1
 * 2019-07-30  Runtime: 0 ms
 * Algorithm: => Three iterations.
 * Time Complexity: O(N). Space Conplexity: O(1)
 */
 
 /*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        // copy nodes
        Node node = head;
        while (node != null) {
            Node next = node.next;
            node.next = new Node(node.val);
            node.next.next = next;
            node = next;
        }
        
        // copy random
        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        
        // get rid of orginal nodes and random
        node = head;
        Node copyHead = head.next;
        Node copy = copyHead;
        while (copy.next != null) {
            node.next = node.next.next;
            node = node.next;
            copy.next = copy.next.next;
            copy = copy.next;
        }
        node.next = node.next.next;
        return copyHead;
    }
}


/*
 * Solution 2
 * 2019-07-30  Runtime: 1 ms
 * Algorithm: => Two iterations.
 * Time Complexity: O(N). Space Conplexity: O(1)
 */
 
 class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node node = head;
        Map<Node, Node> map = new HashMap<>();
        
        // copy nodes
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }
        
        // assign next and random pointers
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get().random = map.get(node.random);
            node = node.next;
        }
        
        return map.get(head);
    }
}
