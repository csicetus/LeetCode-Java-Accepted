/////////// sol 1: Recursion

// Time: O(n); Space: O(1) for this question
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        helper(root.left, root.right);
        return root;
    }
    
    private void helper(Node n1, Node n2) {
        if (n1 == null) return;
        n1.next = n2;
        helper(n1.left, n1.right);
        helper(n2.left, n2.right);
        helper(n1.right, n2.left);
    }
}


///////////// sol 2: Recursion

// Time: O(n); Space: O(1)
class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}

///////////// sol 3

// Time: O(n); Space: O(1)
class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Node rootCopy = root;
        while (rootCopy != null) {
            Node curr = rootCopy;
            while (curr != null) {
                if (curr.left != null) {
                    curr.left.next = curr.right;
                }
                if (curr.right != null && curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            rootCopy = rootCopy.left;
        }
        return root;
    }
}
