//////////////// sol 1: heap

// Time: O(logn) for add numbers with heap; Space: O(n)
class MedianFinder {
    PriorityQueue<Integer> small, large;
    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<Integer>((a, b) -> b - a);
        large = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        large.add(num);
        small.add(large.poll());
        if (small.size() - large.size() > 1) {
            large.add(small.poll());
        }
        if (large.size() - small.size() > 1) {
            small.add(large.poll());
        }
    }
    
    public double findMedian() {
        int smLen = small.size();
        int laLen = large.size();
        return (smLen - laLen > 0) 
            ? small.peek() : (small.peek() + large.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
