class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<Integer>[] adj = new ArrayList[n];
        for (int i =0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges){
            int edge1 = edge[0];
            int edge2 = edge[1];
            adj[edge1].add(edge2);
            adj[edge2].add(edge1);
        }
        int count = 0;
        for (int i =0; i < n; i++){
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
