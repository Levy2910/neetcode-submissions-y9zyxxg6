class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i=0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        for (int[] edge: edges){
            int node1 = edge[0];
            int node2 = edge[1];
            adj[node1].add(node2);
            adj[node2].add(node1);
        }
        boolean[] visited = new boolean[n];
        if (hasCycle(0, adj, visited, -1)){
            return false;
        }
        for (int i=0; i < n; i++){
            if (!visited[i]){
                return false;
            }
        }
        return true;
    }
    private boolean hasCycle(int curr, List<Integer>[] adj, boolean[] visited, int parent){
        visited[curr] = true;
        for (int neighbor : adj[curr]){
            
            if (visited[neighbor] && parent != neighbor){
                
                return true;
            }else if (!visited[neighbor]){
                if (hasCycle(neighbor, adj, visited, curr)){
                    return true;
                }
            }
        }
        return false;
    }
}
// 0 -> {1, 2, 3}
// 1 -> {0, 4}
// 2 -> {0}
// 3 -> {0}
// 4 -> {1}
