class Solution {
    public int countComponents(int n, int[][] edges) {
        int result = 0;
        List<Integer>[] adj = new ArrayList[n];
        for (int i =0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];
            adj[node1].add(node2);
            adj[node2].add(node1);
        }
        boolean[] visited = new boolean[n];
        for (int i=0; i < n; i++){
            if (!visited[i]){
                result++;
                dfs(visited, i, adj);
            }
        }
        return result;
    }
    private void dfs(boolean[] visited, int curr, List<Integer>[] adj){
        visited[curr] = true;
        for (int neighbor : adj[curr]){
            if (!visited[neighbor]){
                dfs(visited, neighbor, adj);
            }
        }
    }
}
