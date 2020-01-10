/////////// sol 1: DFS

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        List<List<Integer>> courses = new ArrayList<List<Integer>>(numCourses);
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, visited, courses)) return false;
        }
                
        return true;
    }
    
    
    private boolean dfs(int curCourse, int[] visited, List<List<Integer>> courses) {
        visited[curCourse] = 1;
        List<Integer> childCourses = courses.get(curCourse);
        for (int i = 0; i < childCourses.size(); i++) {
            int childIndex = childCourses.get(i);
            // cur child already be visited
            if (visited[childIndex] == 1) return false;
            // cur child not be visited
            // don't use if-else because there's exists visited = 2
            if (visited[childIndex] == 0) {
                if (!dfs(childIndex, visited, courses)) {
                    return false;
                }
            }
        }
        visited[curCourse] = 2;
        return true;
    }
}
