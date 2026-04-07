class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<Integer>[] adj = new ArrayList[n];
        for (int i=0; i < adj.length; i++){
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];
            adj[node1].add(node2);
            adj[node2].add(node1);
        }
        if (hasCycle(adj, visited, 0, -1)){
            return false;
        }
        for (int i=0; i < n; i++){
            if (!visited[i]){
                return false;
            }
        }
        return true;
    }
    private boolean hasCycle(List<Integer>[] adj, boolean[] visited, int curr, int parent){
        visited[curr] = true;
        for (int neighbor : adj[curr]){
            if (visited[neighbor] && neighbor != parent){
                return true;
            }else if (!visited[neighbor]){
                if (hasCycle(adj, visited, neighbor, curr)){
                    return true;
                }
            }
        }
        return false;
    }
}
