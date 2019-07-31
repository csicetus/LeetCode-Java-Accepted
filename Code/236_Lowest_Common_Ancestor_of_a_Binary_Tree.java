/*
 * 236. Lowest Common Ancestor of a Binary Tree
 * Target: Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * Difficulty：Medium
 * Classification：Tree
 */

/*
 * Solution 1
 * 2019-07-30  Runtime: 1 ms
 * Algorithm: => Recursion.
 * Time Complexity: O(N), where N is the number of nodes in the binary tree. Space Conplexity: O(N). The maximum amount of space 
 *                  utilized by the recursion stack would be N since the height of a skewed binary tree could be N. 
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}


/*
 * Solution 2
 * 2019-07-30  Runtime: 1 ms
 * Algorithm: => Iteration with parent node.
 *               Traverse the tree until we find p and q both, keep storing the parent pointers in a dictionary.
 *               Once we have found both p and q, we get all the ancestors for p using the parent dictionary and add to a set called ancestors.
 *               Traverse through ancestors for node q. If the ancestor is present in the ancestors set for p, 
 *               it means this is the first ancestor common between p and q (while traversing upwards) and hence this is the LCA node.
 * Time Complexity: O(N). Space Conplexity: O(N)
 */
 
 class Solution { 
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        stack.push(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
}



/*
 * Solution 3
 * 2019-07-30  Runtime: 15 ms
 * Algorithm: => Iteration without parent node. Optimal of sol 2.
 * Time Complexity: O(N), where N is the number of nodes in the binary tree. Space Conplexity: O(N).
 */
 
import javafx.util.*;

class Solution {
    // Both left and right traversal pending for a node.
    // Indicates the nodes children are yet to be traversed.
    private static int bothPending = 2;
    
    private static int leftDone = 1;
    
    // Both left and right traversal done for a node.
    // Indicates the node can be popped off the stack.
    private static int bothDone = 0;    
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<TreeNode, Integer>(root, Solution.bothPending));
        // This flag is set when either one of p or q is found.
        boolean oneNodeFound = false;
        TreeNode LCA = null;
        TreeNode childNode = null;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> top = stack.peek();
            TreeNode parentNode = top.getKey();
            int parentState = top.getValue();
            
            // If the parent_state is not equal to BOTH_DONE,
            // this means the parent_node can't be popped off yet.
            if (parentState != Solution.bothDone) {
                if (parentState == Solution.bothPending) {
                    if (parentNode == p || parentNode == q) {                
                        // If one_node_found was set already, we have found both the nodes.
                        if (oneNodeFound) {
                            return LCA;
                        } else {
                            // Otherwise, set one_node_found to True,
                            // to mark one of p and q is found.
                            oneNodeFound = true;
                            // Save the current top element of stack as the LCA.
                            LCA = stack.peek().getKey();
                        }
                    }
                    // if both pending, traverse the left child first
                    childNode = parentNode.left;
                } else {
                    // else both pending, traverse the left child first
                    childNode = parentNode.right;
                }
                
                // Update the node state at the top of the stack
                // Since we have visited one more child.
                stack.pop();
                stack.push(new Pair<TreeNode, Integer>(parentNode, parentState - 1));
                
                // Add the child node to the stack for traversal.
                if (childNode != null) {
                    stack.push(new Pair<TreeNode, Integer>(childNode, Solution.bothPending));
                }
            } else {
                // If the parent_state of the node is both done,
                // the top node could be popped off the stack.
                // Update the LCA node to be the next top node.
                if (LCA == stack.pop().getKey() && oneNodeFound) {
                    LCA = stack.peek().getKey();
                }
            }
        }
        return null;
    }
}
 
 
