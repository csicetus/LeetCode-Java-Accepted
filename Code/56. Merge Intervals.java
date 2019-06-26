/*
 * 56. Merge Intervals
 * Target: Given a collection of intervals, merge all overlapping intervals.
 * Difficulty：Medium
 * Classification：Array, Greedy
 * Best solution: solution 3.
 */

/*
 * Solution 1
 * 2019-06-25  Runtime: ? ms
 * Algorithm: => Sort and merge.
 * Time complexity: O(n*logn). Space complexity: O(n).
 */
 
private class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval a, Interval b) {
        return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
    }
}

public List<Interval> merge(List<Interval> intervals) {
    Collections.sort(intervals, new IntervalComparator());

    LinkedList<Interval> merged = new LinkedList<Interval>();
    for (Interval interval : intervals) {
        if (merged.isEmpty() || merged.getLast().end < interval.start) {
            merged.add(interval);
        }
        else {
            merged.getLast().end = Math.max(merged.getLast().end, interval.end);
        }
    }

    return merged;
}
