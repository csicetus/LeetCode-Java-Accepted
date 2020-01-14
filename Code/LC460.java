////////////// sol 1

// Time: O(1); Space: O(1)
class LFUCache {
    private int minFreq;
    private int capacity;
    // Map <key, value>
    private Map<Integer, Integer> keyToVal;
    // Map <key, frequency>
    private Map<Integer, Integer> keyToFreq;
    // Map <frequency, Set<key>>
    private Map<Integer, Set<Integer>> freqToKeys;
    
    public LFUCache(int capacity) {
        minFreq = -1;
        this.capacity = capacity;
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
    }
    
    public int get(int key) {
        if (!keyToVal.containsKey(key)) return -1;
        int freq = keyToFreq.get(key);
        freqToKeys.get(freq).remove(key);
        if (freq == minFreq && freqToKeys.get(freq).size() == 0) {
            minFreq++;
        }
        putFreq(key, freq + 1);
        return keyToVal.get(key);
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) return;
        
        // key already exists
        if (keyToVal.containsKey(key)) {
            // update key's value
            keyToVal.put(key, value);
            // update key's frequency
            get(key);
            return;
        }
        
        // cache reaches its capacity
        if (keyToVal.size() >= capacity) {
            evict(freqToKeys.get(minFreq).iterator().next());
        }
        
        // cache doesn't reach its capacity
        minFreq = 1;
        putFreq(key, minFreq);
        keyToVal.put(key, value);
    }
    
    public void putFreq(int key, int freq) {
        keyToFreq.put(key, freq);
        freqToKeys.computeIfAbsent(freq, ignore -> new LinkedHashSet<>());
        freqToKeys.get(freq).add(key);
    } 
    
    public void evict(int key) {
        freqToKeys.get(minFreq).remove(key);
        keyToVal.remove(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
