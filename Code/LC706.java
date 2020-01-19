/////////////// sol 1: Design - List

class MyHashMap {

    final ListNode[] nodes;
    
    class ListNode {
        int key, val;
        ListNode next;
        
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new ListNode[1000000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = getIndex(key);
        if (nodes[i] == null) {
            nodes[i] = new ListNode(-1, -1);
        }
        ListNode prev = findPre(key, nodes[i]);
        if (prev.next == null) {
            prev.next = new ListNode(key, value);
        } else {
            prev.next.val = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = getIndex(key);
        if (nodes[i] == null) {
            return -1;
        }
        ListNode prev = findPre(key, nodes[i]);
        return prev.next != null ? prev.next.val : -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = getIndex(key);
        if (nodes[i] == null) return;
        ListNode prev = findPre(key, nodes[i]);
        if (prev.next == null) return;
        prev.next = prev.next.next;
    }
    
    public int getIndex(int key) {
        return Integer.hashCode(key) % nodes.length;
    }
    
    public ListNode findPre(int key, ListNode bucket) {
        ListNode node = bucket, prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
