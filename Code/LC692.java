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
