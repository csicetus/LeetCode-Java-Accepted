//////////sol 1

class Node {
    Object key;
    Object value;
    Node pre = null;
    Node next = null;
    Node (Object k, Object v) {
        key = k;
        value = v;
    }
}

class DoubleLinkedList {
    private Node dummy = new Node(null, null);
    private Node tail = dummy;
    
    public void addNode(Node n) {
        tail.next = n;
        n.pre = tail;
        tail = n;
    }
    
    public void remove(Node n) {
        n.pre.next = n.next;
        if (n.next != null) {
            n.next.pre = n.pre;
        } else {
            tail = n.pre;
        }
        n.pre = null;
        n.next = null;
    }
    
    public void moveToTail(Node n) {
        remove(n);
        addNode(n);
    }
    
    public Node getHead() {
        return dummy.next;
    }
}

class LRUCache {
    private int capacity = 0;
    private DoubleLinkedList dbList = new DoubleLinkedList();
    private HashMap<Integer, Node> map = new HashMap<>();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            dbList.moveToTail(n);
            return (int)n.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // if map contains key, we should refresh value and freq of node
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.value = value;
            dbList.moveToTail(n);
        } else {
            // list is full
            if (map.size() == capacity) {
                Node head = dbList.getHead();
                // remove from map
                map.remove((int)head.key);
                // reomve from dbList
                dbList.remove(head);     
            } 
            // add new
            Node n = new Node(key, value);
            dbList.addNode(n);
            map.put(key, n);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
