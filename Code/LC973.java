////////// sol 1

// Time: O(NlogN); Space: O(N)
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int N = points.length;
        int dists[] = new int[N];
        int res[][] = new int[K][2];
        for (int i = 0; i < N; i++) {
            dists[i] = calculateDists(points[i]);
        }
        Arrays.sort(dists);
        int distK = dists[K - 1];
        int k = 0;
        for (int j = 0; j < N; j++) {
            if (calculateDists(points[j]) <= distK) {
                res[k++] = points[j];
            }
        }
        return res;
    }
    
    private int calculateDists(int[] points) {
        return points[0] * points[0] + points[1] * points[1];
    }
}
