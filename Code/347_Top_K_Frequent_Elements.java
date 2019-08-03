/*
 * 347. Top K Frequent Elements
 * Target: Given a non-empty array of integers, return the k most frequent elements.
 *         You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 *         Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * Difficulty：Medium
 * Classification：HashTable, Heap
 */

 /*
 * Solution 1
 * 2019-08-02  Runtime: 43 ms
 * Algorithm: => Heap and HashTable. 
 *               1. Build a hash map element -> its frequency.
 *               2. Build a heap until the size > k.
 *               3. Build a Linked List to get the numbers from the heap. Note that we should reverse the result.
 * Time Complexity: O(n*logk). Space Conplexity: O(n). 
 */
 
 class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int num : map.keySet()) {
            heap.add(num);
            if (heap.size() > k) heap.poll();
        }
        List<Integer> res = new LinkedList<>();
        while (!heap.isEmpty()) {
            res.add(heap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}


 /*
 * Solution 1
 * 2019-08-02  Runtime: 9 ms
 * Algorithm: => Heap and HashTable. 
 *               1. Build a hash map element -> its frequency.
 *               2. Build a List<Integer>[] bucket to store frequency.
 *               3. Build a Linked List to get the numbers from the bucket[i]. Note that it's not a heap so we don't need to reverse the result.
 * Time Complexity: O(n*logk). Space Conplexity: O(n). 
 */
 
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (bucket[freq] == null) {
                bucket[freq] = new LinkedList<>();
            }
            bucket[freq].add(num);
        }
        List<Integer> res = new LinkedList<>();
        for (int i = bucket.length - 1; k > 0 && i > 0; --i) {
            if (bucket[i] != null) {
                List<Integer> tmp = bucket[i];
                res.addAll(tmp);
                k -= tmp.size();
            }
        }
        return res;
    }
}
