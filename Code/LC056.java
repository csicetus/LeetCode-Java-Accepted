// new version problem

// Time: O(nlogn); Space: O(1)(or O(n))
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals == null) {
            return intervals;
        }
        Arrays.sort(intervals, (l1, l2) -> Integer.compare(l1[0], l2[0]));
        List<int[]> res = new ArrayList<int[]>();
        int[] newIntervals = intervals[0];
        /*
        for (int a : newIntervals) {
            System.out.println(a);
        }
        */
        res.add(newIntervals);
        for (int[] inter : intervals) {          
            // overlapping, get max as result
            if (inter[0] <= newIntervals[1]) {
                //System.out.println(inter[0] +"<="+ newIntervals[1]);
                newIntervals[1] = Math.max(newIntervals[1], inter[1]);
            } else {
                //System.out.println(inter[0] +">"+ newIntervals[1]);
                newIntervals = inter;
                res.add(newIntervals);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
