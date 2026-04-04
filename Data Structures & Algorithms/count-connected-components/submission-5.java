class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        List<Integer>[] adj = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for (int i =0; i < adj.length; i++){
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];
            adj[node1].add(node2);
            adj[node2].add(node1);
        }

        for (int i=0; i < n; i++){
            if (!visited[i]){
                count++;
                dfs(i, visited, adj);
            }
        }

        return count;
    }
    private void dfs(int curr, boolean[] visited, List<Integer>[] adj){
        visited[curr] = true;
        for (int neighbor : adj[curr]){
            if (!visited[neighbor]){
                dfs(neighbor, visited, adj);
            }
        }
    }
}
