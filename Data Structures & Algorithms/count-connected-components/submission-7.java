class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i=0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];
            adj[node1].add(node2);
            adj[node2].add(node1);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i=0; i < n; i++){
            if (!visited[i]){
                count++;
                dfs(i, adj, visited);
            }
        }
        return count;
    }
    private void dfs(int curr, List<Integer>[] adj, boolean[] visited){
        visited[curr] = true;
        for (int neighbor : adj[curr]){
            if (!visited[neighbor]){
                dfs(neighbor, adj, visited);
            }
        }
    }
}
