class Solution {
    public int countComponents(int n, int[][] edges) {
        int result = 0;
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
        int[] visited = new int[n];

        for (int i=0; i < n; i++){
            // if its not visited -> count
            // do dfs, explore all the children mark them as explored
            if (visited[i] == 0){
                result++;
                dfs(adj, i, visited);
            }
        }
        return result;
    }
    private void dfs(List<Integer>[] adj, int curr, int[] visited){
        visited[curr] = 1;
        for (int neighbor : adj[curr]){
            if (visited[neighbor] == 0){
                dfs(adj, neighbor, visited);
            }
        }
    }
}
