class Solution {
    public boolean validTree(int n, int[][] edges) {
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
        if (hasCycle(visited, adj, 0, -1)){
            return false;
        }
        for (int i=0; i < n; i++){
            if (!visited[i]){
                return false;
            }
        }
        return true;
    }
    private boolean hasCycle(boolean[] visited, List<Integer>[] adj, int curr, int parent){
        visited[curr] = true;
        for (int neighbor : adj[curr]){
            if (visited[neighbor] && parent == neighbor){
                continue;
            }else if (visited[neighbor] && parent != neighbor){
                return true;
            }else{
                if (hasCycle(visited, adj, neighbor, curr)){
                    return true;
                }
            }
        }
        return false;
    }
}
