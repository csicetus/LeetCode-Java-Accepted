////////// sol 1 HashMap

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // count freq with hashmap
        HashMap<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        
        // sort freq and output max k words
        List<String> topFreq = new ArrayList<>(map.keySet());
        Collections.sort(topFreq, (w1, w2) -> map.get(w1).equals(map.get(w2)) ? w1.compareTo(w2) : map.get(w2) - map.get(w1));
        
        return topFreq.subList(0, k);
    }
}


////////// sol 2 min heap

// Time: O(nlogk); Space: O(n)
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // count freq with hashmap
        HashMap<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        
        // build min heap
        // use equals to check w1 and w2 alphabetical order
        PriorityQueue<String> minHeap = new PriorityQueue<String>(
            (w1, w2) -> map.get(w1).equals(map.get(w2)) ? 
            w2.compareTo(w1) : map.get(w1) - map.get(w2) );
        
        // add each entry to min heap with max k words
        for (String w : map.keySet()) {
            minHeap.offer(w);
            if (minHeap.size() > k) minHeap.poll();
        }
        
        // Extract min from heap
        List<String> topKFreq = new ArrayList<>();
        while(!minHeap.isEmpty()) {
            topKFreq.add(minHeap.poll());
        }
        
        // reverse
        Collections.reverse(topKFreq);        
        return topKFreq;
    }
}
