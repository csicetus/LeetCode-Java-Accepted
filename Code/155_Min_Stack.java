/*
 * 155. Min Stack
 * Target: Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *         push(x) -- Push element x onto stack.
 *         pop() -- Removes the element on top of the stack.
 *         top() -- Get the top element.
 *         getMin() -- Retrieve the minimum element in the stack.
 * Difficulty：Easy
 * Classification：Stack, Design
 */

/*
 * Solution 1
 * 2019-08-27  Runtime: 47 ms
 * Algorithm: => Stack. Every time put the Node and calculate the minimum value of stack.
 * Time Complexity: O(n). Space Conplexity: O(1)
 */
 
 class MinStack {

    private Node head;
    
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        } else {
            head = new Node(x, Math.min(head.min, x), head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
    
    private class Node {
        int val, min;
        Node next;
        
        private Node(int val, int min) {
            this.val = val;
            this.min = min;
            this.next = null;
        }
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    } 
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
