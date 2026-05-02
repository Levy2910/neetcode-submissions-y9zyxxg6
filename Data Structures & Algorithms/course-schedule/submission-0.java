class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i=0; i < numCourses; i++){
            adj[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites){
            int course1 = pre[0];
            int course2 = pre[1];
            adj[course1].add(course2);
        }
        int[] visited = new int[numCourses];
        for (int i=0; i < numCourses; i++){
            if (visited[i] == 0){
                if (!canFinish(i, adj, visited)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean canFinish(int curr, List<Integer>[] adj, int[] visited){
        if (visited[curr] == 2) return true;
        visited[curr] = 1;
        for (int neighbor : adj[curr]){
            if (visited[neighbor] == 1){
                return false;
            }else if (visited[neighbor] == 0){
                if (!canFinish(neighbor, adj, visited)){
                    return false;
                }
            }
        }
        visited[curr] = 2;
        return true;
    }
}














// 0 -> {1}

