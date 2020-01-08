/////////// sol 1: dfs

// Time: O(n^2); Space: O(n)
class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        int count = 0;
        boolean[] visited = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, i, visited);
                count++;
            }
        }
        return count;
    }
    
    private void dfs(int[][] M, int currPeople, boolean[] visited) {
        // M is N*N matrix so M.length == M.length[0]
        for (int other = 0; other < M.length; other++) {
            if (M[currPeople][other] == 1 && !visited[other]) {
                visited[other] = true;
                // find curr other's direct friend as a whole
                dfs(M, other, visited);
            }
        }
    }
}
