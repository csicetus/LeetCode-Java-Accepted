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


////////// sol 2

// Time: O(n); Space: O(N)
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int len = points.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = kClosestHelper(points, l, r);
            if (mid == K) break;
            if (mid < K) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }      
        return Arrays.copyOfRange(points, 0, K);
    }
    
    private int kClosestHelper(int[][] points, int l, int r) {
        int privot[] = points[l];
        while (l < r) {
            while (l < r && compareDists(points[r], privot)) r--;
            points[l] = points[r];
            while (l < r && !compareDists(points[l], privot)) l++;
            points[r] = points[l];
        }
        points[l] = privot;
        return l;
    }
    
    private boolean compareDists(int[] p1, int[] p2) {
        int res = p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
        return res > 0 ? true : false;
        //return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}


/////////// sol 3

// Time: O(nlogn); Space: O(logK)
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(p -> -p[0] * p[0] - p[1] * p[1]));
        for (int[] p : points) {
            pq.offer(p);
            // poll the last one(K + 1)
            if (pq.size() > K) pq.poll();
        }
        return pq.toArray(new int[K][2]);
    }
}
